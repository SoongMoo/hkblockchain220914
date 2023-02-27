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
	web3 = new Web3(new Web3.providers.HttpProvider("http://localhost:7545"));
	console.log(Web3);
	web3.eth.getAccounts()
						  .then(accounts => console.log(accounts))
						  .catch(error => console.log(error));
	web3.eth.defaultAccount = $("#accountAddress").val();
	console.log($("#accountAddress").val());
	
	getDefault();
});
function getDefault() {
	web3.eth.getAccounts(function(e, r) {
		data[0].account = $("#accountAddress").val();
		console.log("data.account : " + data[0].account);
	});
	data[0].contractInstance = new web3.eth.Contract(MYNFT_ABI,MYNFT_CA);
	auction.contractInstance = new web3.eth.Contract(AUCTIONS_ABI,AUCTIONS_CA);
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
				$("#uploadedImg").attr("src","https://rhee.infura-ipfs.io/" + data[0]['dataURI']);
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
		

		watchTokenRegistered(function(error, result) {
			if (!error) {
				alert("Token registered...!");
				data[0].isRegistered = true;
			}
		});

		
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
				const message = $("#Data_URI").text();
				
				// 메시지 해시 생성
				const messageHash = web3.utils.sha3(message);
				
				// 서명 생성
				const signature = web3.eth.accounts.sign(messageHash, privateKey);
				
				// 결과 출력
				console.log("signature.messageHash : " + signature.messageHash);
				console.log("signature.v : " + signature.v);
				console.log("signature.r : " + signature.r);
				console.log("signature.s : " + signature.s);
		const price = web3.utils.toWei($("#auctionPrice").val(),'ether');
		auction.contractInstance.methods.createAuction(MYNFT_CA,data[0]['tokenId'], $("#auctionTitle").val() 
								,data[0]['dataURI'],price, signature.v, signature.r, signature.s)
								.send({from:data[0]['account'],gas: GAS_AMOUNT})
								.then( (transactionHash) => {
				if(transactionHash){					
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
				}		
				
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
	contractInstance.methods.transferFrom(account,AUCTIONS_CA, tokenId).send({from:account,gas:GAS_AMOUNT}).then(
		function(result){
			 console.log("result",result)    ;
		} );
		
	/*
	watchTransfered(function(error, result){
		if(!error) alert("Token transfered to CA...!")	
	});
	*/
	
}

function registerUniqueToken(contractInstance, account,tokenId,dataURI  ){
	contractInstance.methods.registerUniqueToken(account, tokenId, dataURI).send({ from: account, gas: GAS_AMOUNT }).then( 
	function(result) {
		console.log("result", result);
		if (result.transactionHash) {
			alert("Token registered...!");
			$("#isRegistered").css("display", "");
		}
	});
}
function watchTokenRegistered(cb) {
     data[0]['contractInstance'].events.TokenRegistered().on('data',(event)=>{
		  console.log('이벤트 : ' + event);
	  });
      //eventWatcher.watch(cb);
}

function watchTransfered(cb) {
      const currentBlock = getCurrentBlock()
      const eventWatcher = data[0]['contractInstance'].events.Transfer({}).call({fromBlock: currentBlock - 1, toBlock: 'latest'});
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
let privateKey;

function onFileSelected(event){
  const file = event.target.files[0];
  const reader = new FileReader();

  reader.onload = function(event) {
    console.log(event.target.result);
    privateKey = event.target.result;
  };
  reader.readAsText(file);
}


/*
	// 개인 키 문자열
	const privateKey = '50bbb209c37a97768e5b947e0f89b2d4643ab3a4d73edd0950e1a9c1e5893e49';
	
	// Account 객체 생성
	const account = web3.eth.accounts.privateKeyToAccount(privateKey);
	// Account 객체의 주소 얻기
	const address = account.address;
	
	console.log('Address: ', account);


	const message = 'QmPeWHzqmQ6nNdxdjAZqJmHiGBTyhkJkR3PUySPqDAxUMW';

	// 메시지 해시 생성
	const messageHash = web3.utils.sha3(message);
	
	// 서명 생성
	const signature = web3.eth.accounts.sign(messageHash, privateKey);
	
	// 결과 출력
	console.log("signature.messageHash : " + signature.messageHash);
	console.log("signature.v : " + signature.v);
	console.log("signature.r : " + signature.r);
	console.log("signature.s : " + signature.s);
*/
