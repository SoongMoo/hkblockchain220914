import * from './marketConfig.js';


const account = "0x7f72c88c9641113f7e1c114b498841461f348905"; // 디비에서 가져올 것

window.addEventListener("load", function() {
	window.web3 = new Web3(new Web3.providers.HttpProvider("http://localhost:7545"));
	console.log("account : " + web3.eth.accounts);
	web3.eth.defaultAccount = web3.eth.accounts[0];
	ciMyNFT = web3.eth.contract(MYNFT_ABI).at(MYNFT_CA);
	ciAuctions = web3.eth.contract(AUCTIONS_ABI).at(AUCTIONS_CA);
	$(".account").text(account);
	getMyAuctions();
});

function getMyAuctions() {
	ciAuctions.getAuctionsOf(account,{ from: account, gas: GAS_AMOUNT }
			,function(error, result){
			console.log(result.length);
			auctionIds = result;
			select_option = "<option value='-1'>원하는 번호를 선택해주세요</option>";
			auctionIds.forEach((currentElement, index, array )=>{
				select_option += "<option>"+currentElement+"</option>";
			});
			$("#selectedAuction").html(select_option);
		});
		web3.eth.getBalance(account, function (error, result){        
		        balance = web3.fromWei(result, 'ether');
		        $("#balanceVal").text(balance);
	   });
}

function getAuctionById(target){
	ciAuctions.getAuctionById(target.value,{ from: account, gas: GAS_AMOUNT }
			,function(error, result){
		$("#title").text(result[0]);
		$("#tokenId").text(result[3]);
		$("#price").text(web3.fromWei(result[1], 'ether'));
		$("#owner").text(result[5]);
	} );
}
function finalizeAuction(){
	if(!$("#toAddress").val()){
		alert("toAddress를 입력해 주세요");
		return;
	}
    
    ciAuctions.finalizeAuction($("#selectedAuction").val(), $("#toAddress").val(), 
    	{from: account, gas: GAS_AMOUNT}, (error, result) => {        
          console.log(error)
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
