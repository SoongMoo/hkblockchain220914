var account; // 디비에서 가져올 것

window.addEventListener("load", function() {
	web3 = new Web3(new Web3.providers.HttpProvider("http://localhost:7545"));
	web3.eth.getAccounts()
						  .then(accounts => console.log(accounts))
						  .catch(error => console.error(error));
	web3.eth.defaultAccount = $(".account").text();;
	ciMyNFT = new web3.eth.Contract(MYNFT_ABI,MYNFT_CA);
	ciAuctions = new web3.eth.Contract(AUCTIONS_ABI,AUCTIONS_CA);
	account = $(".account").text();
	console.log('$(".account").text() : ' +$(".account").text());
	getMyAuctions();
});

function getMyAuctions() {
	console.log("account :" + account);
	ciAuctions.methods.getAuctionsOf(account).call()
			.then(result => {
				console.log("result :" + result);
				auctionIds = result;
				select_option = "<option value='-1'>원하는 번호를 선택해주세요</option>";
				auctionIds.forEach((currentElement, index, array )=>{
					select_option += "<option>"+currentElement+"</option>";
				});
			$("#selectedAuction").html(select_option);
		});
		web3.eth.getBalance(account, function (error, result){        
		        balance = web3.utils.fromWei(result, 'ether');
		        $("#balanceVal").text(balance);
	   });
}

let metadata;
let privateKey;

function onFileSelected(event){
  const file = event.target.files[0];
  const reader = new FileReader();

  reader.onload = function(event) {
    console.log(event.target.result);
    $.ajax({
		url: 'sessionPrivateKey',
		type: "POST",
		data: {"privateKey" : event.target.result},
		success:function(result){
			console.log(result);
			location.reload();
		}
	});
  };
  reader.readAsText(file);
}

function getAuctionById(target) {
	alert(target.value)
	ciAuctions.methods.getAuctionById(target.value).call({ from: account, gas: GAS_AMOUNT }).then(
		(result) => {
			console.log("result : " + result[2]);
			$.ajax({
				url: 'sessionValue',
				type: "POST",
				success: function(response) {
					console.log(response);
					if(response == ""){
						alert("인증서가 존재하지 않습니다.");
						location.reload();
						return false;
					}
					console.log(response)
					const privateKey = response.trim();
					const message = result[2];
					const messageHash = web3.utils.sha3(message);
					const signature = web3.eth.accounts.sign(messageHash, privateKey);
					const signature1 = {
						  messageHash: signature.messageHash,
						  v: signature.v,
						  r: signature.r,
						  s: signature.s
					};
					const signerAddress = web3.eth.accounts.recover(signature1);
					if (signerAddress == web3.eth.accounts.recover(messageHash, result[6], result[7], result[8])) {
						$("#title").text(result[0]);
						$("#tokenId").text(result[3]);
						$("#price").text(web3.utils.fromWei(result[1], 'ether'));
						$("#owner").text(result[5]);
						$("#metadata").text(result[2]);
					} else {
						alert('서명이 유효하지 않습니다. 다시 로그인 하여주세요');
						location.href="/login/logout";
					}
				},
				error: function(res) {
					console.log(res);
					alert("에러가 발생했습니다.");
				}
			});
		});
}
function onFileSelected1(event){
  const file = event.target.files[0];
  const reader = new FileReader();

  reader.onload = function(event) {
    console.log(event.target.result);
    privateKey = event.target.result;
  };
  reader.readAsText(file);
}
function finalizeAuction(){
	if(!$("#toAddress").val()){
		alert("toAddress를 입력해 주세요");
		return;
	}
    console.log('$("#selectedAuction").val() : ' + $("#selectedAuction").val());
    console.log('$("#toAddress").val() : ' + $("#toAddress").val());
    
    
	const message = $("#metadata").text();

	// 메시지 해시 생성
	const messageHash = web3.utils.sha3(message);

	// 서명 생성
	const signature = web3.eth.accounts.sign(messageHash, privateKey);

    ciAuctions.methods.finalizeAuction($("#selectedAuction").val(), $("#toAddress").val(), signature.v,signature.r,signature.s).send(
    	{from: account, gas: GAS_AMOUNT}).then((result) => {        
          console.log(result)
    })
	
/*
	watchFinalized(function(error, result){
          if(!error) alert("Auction finalized...!")
    });
*/
}


function watchFinalized(cb) {
      const currentBlock = getCurrentBlock()
      const eventWatcher = ciAuctions.AuctionFinalized({}, {fromBlock: currentBlock - 1, toBlock: 'latest'})
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
