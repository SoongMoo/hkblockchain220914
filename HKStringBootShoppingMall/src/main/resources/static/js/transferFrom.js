let auctionIds = [];
let balance;

var account; 
var tokenId;


window.addEventListener("load", function() {
	window.web3 = new Web3(new Web3.providers.HttpProvider("http://localhost:7545"));
	web3.eth.defaultAccount = account; //web3.eth.accounts[0]
	ciMyNFT = web3.eth.contract(MYNFT_ABI).at(MYNFT_CA);
	ciAuctions = web3.eth.contract(AUCTIONS_ABI).at(AUCTIONS_CA);
	getMyAuctions();
});
function getMyAuctions() {
	console.log($("#ownerAddress").val());
	account = $("#ownerAddress").val() ;
	tokenId = $("#tokenId").val();
	ciAuctions.getAuctionsOf(account,{ from: account, gas: GAS_AMOUNT }
			,function(error, result){
		result.forEach((num, index, array )=>{
			console.log(num);
			getAuctionById(Number(num));
		});
	});
}
function getAuctionById(value){
	ciAuctions.getAuctionById(value,{ from: account, gas: GAS_AMOUNT }
			,function(error, result){
		console.log(result);
		console.log(result[3]['c']);
		if(result[3]['c'] == tokenId){
			$("#auctionId").val(value);
			$("#title").text(result[0]);
			$("#price").text(web3.fromWei(result[1], 'ether'));
			$("#owner").text(result[5]);
		}
	} );
}
function finalizeAuction(){
	if(!$("#toAddress").val()){
		alert("toAddress를 입력해 주세요");
		return;
	}
	ciAuctions.finalizeAuction($("#auctionId").val(),$("#toAddress").val()
						,{from: account, gas: GAS_AMOUNT}
						, (error, result) => {
		console.log(result);
		$.ajax({
			url: "finalizeAuction",
			type: 'post',
			data: {'tokenId' : $("#tokenId").val(),
					'toAddress' : $("#toAddress").val()},
			success: function(){
				alert("소유권이 정상적으로 변경되었습니다.");
				location.href="/main";
			},
			error: function(){
						alert("서버 오류");
			}
		});					
	} );
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


