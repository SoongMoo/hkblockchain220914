data = [{
			account:null,
			contractInstance : null,
			file : null,
			tokenId : null,
			isRegistered : false,
			dataURI : null
}];

auction = {
        contractInstance: null      
}

window.addEventListener("load", function() {
	window.web3 = new Web3(new Web3.providers.HttpProvider("http://localhost:7545"));
	console.log("account : " + web3.eth.accounts);
	web3.eth.defaultAccount = $("#accountAddress").val();
	console.log($("#accountAddress").val());
	getDefault();
});
function getDefault() {
	web3.eth.getAccounts(function(e, r) {
		data[0].account = $("#accountAddress").val();
		console.log("data.account : " + data[0].account);
	});
	data[0].contractInstance = web3.eth.contract(MYNFT_ABI).at(MYNFT_CA);
	auction.contractInstance = web3.eth.contract(AUCTIONS_ABI).at(AUCTIONS_CA);
	data[0]['tokenId'] = _getRandomInt(123456789,999999999);
	$(".tokenID").text(data[0]['tokenId']);
	$("#tokenID").val(data[0]['tokenId']);
}

function _getRandomInt(min, max) {
	return Math.floor(Math.random()*(max - min)) + min;
}

$(function() {
	$("#UPLOADIMG").click(function(){
		var formData = new FormData();
		const imageInput = $("#captureFile")[0];
		formData.append("captureFile", imageInput.files[0]);
		const projectId = '2Jkqzx8dF6daV4V1fn5fBir0hCJ';
		const projectSecret = 'cea502289b0e4bd94874f1a402b2a11f';
		const authorization = "Basic " + btoa(projectId + ":" + projectSecret);
		var option = {
			type: "POST",
			dataType: 'json',
			url: "https://ipfs.infura.io:5001/api/v0/add", 
			headers: {authorization},
			data:formData,
			contentType: false,
			processData: false, 
			enctype: 'multipart/form-data', 
			success : function(response){
				data[0]['dataURI'] = response.Hash;
				$("#uploadedImg").attr("src","https://gateway.ipfs.io/ipfs/" + data[0]['dataURI']);
				$("#Data_URI").text(data[0]['dataURI']);
			},
			error : function(res){
				console.log(res);
				alert("에러가 발생했습니다.");
			}
		};
		$.ajax(option);
		return false;
	});
	$("#submit").click(function() {
		if(!data[0]['dataURI']){
        	alert("Fill in dataURI on the input")
        	return;
     	}  
		registerUniqueToken(data[0]['contractInstance'], data[0]['account'], data[0]['tokenId'], data[0]['dataURI']);
		
		/*
		watchTokenRegistered(function(error, result) {
			if (!error) {
				alert("Token registered...!");
				data[0].isRegistered = true;
			}
		});
		*/
		
		data[0].isRegistered = true;
		$("#transferToCA").css("display", "");
	});
	$("#transferToCA").click(function(){
		transferToCA(data[0]['contractInstance'], data[0]['account'], data[0]['tokenId']);
	});
	
	$("#createAution").click(function(){
		if (!data[0]['tokenId']) {
			alert("Check for tokenId")
			return
		}
		const price = web3.toWei($("#auctionPrice").val(),'ether');
		auction.contractInstance.createAuction(MYNFT_CA,data[0]['tokenId'], $("#auctionTitle").val() 
								,data[0]['dataURI'],price,
								{from:data[0]['account']
								,gas: GAS_AMOUNT}
								,function(error, transactionHash){
									
				$.ajax({
					url:"createAution",
					type: 'post',
					data: {'title': $('#auctionTitle').val()
						 , 'price': $('#auctionPrice').val()
						 , 'metadata': data[0]['dataURI']
						 , 'tokenId' : data[0]['tokenId']
						 , 'owner' : data[0]['account']
						 , 'active':'T'
						 , 'finalized' : 'F' },
					success: function(result){
						console.log("txhash", transactionHash);
						alert(transactionHash);
						location.reload();
					},
					error: function(){
						alert("서버 오류");
					}
				});				
				
		});
		/*
		watchCreated(function (error, result){
			if (!error) alert("Creation completed...!")
		})
		*/
	});
});
function watchCreated(cb) {
	const currentBlock = getCurrentBlock()
    const eventWatcher = auction.contractInstance.AuctionCreated({}, {fromBlock: currentBlock - 1, toBlock: 'latest'})
    eventWatcher.watch(cb)
}
function transferToCA(contractInstance,account,tokenId){
	contractInstance.transferFrom(account,AUCTIONS_CA, tokenId, {from:account,gas:GAS_AMOUNT},
		function(error,result){
			 console.log("result",result)    ;
		} );
		
	/*
	watchTransfered(function(error, result){
		if(!error) alert("Token transfered to CA...!")	
	});
	*/
	
}

function registerUniqueToken(contractInstance, account,tokenId,dataURI  ){
	contractInstance.registerUniqueToken(account, tokenId, dataURI, 
	{ from: account, gas: GAS_AMOUNT }, 
	function(error, result) {
		console.log("result", result);
		if (!error) {
			alert("Token registered...!");
			$("#isRegistered").css("display", "");
		}
	});
}
function watchTokenRegistered(cb) {
      const currentBlock = getCurrentBlock()
      const eventWatcher = data[0]['contractInstance'].TokenRegistered({}, {fromBlock: currentBlock - 1, toBlock: 'latest'})
      eventWatcher.watch(cb);
}

function watchTransfered(cb) {
      const currentBlock = getCurrentBlock()
      const eventWatcher = data[0]['contractInstance'].Transfer({}, {fromBlock: currentBlock - 1, toBlock: 'latest'})
      eventWatcher.watch(cb)
}

function getCurrentBlock() {
      return new Promise((resolve, reject ) => {
        web3.eth.getBlockNumber((err, blocknumber) => {
            if(!err) resolve(blocknumber)
            reject(err)
        })
      })
}



