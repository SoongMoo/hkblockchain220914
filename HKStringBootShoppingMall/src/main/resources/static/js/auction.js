var auctionABI = [
	{
		"constant": true,
		"inputs": [],
		"name": "Mycar",
		"outputs": [
			{
				"name": "Brand",
				"type": "string"
			},
			{
				"name": "Rnumber",
				"type": "string"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [],
		"name": "get_owner",
		"outputs": [
			{
				"name": "",
				"type": "address"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [],
		"name": "bid",
		"outputs": [
			{
				"name": "",
				"type": "bool"
			}
		],
		"payable": true,
		"stateMutability": "payable",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [],
		"name": "cancel_auction",
		"outputs": [
			{
				"name": "",
				"type": "bool"
			}
		],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [],
		"name": "withdraw",
		"outputs": [
			{
				"name": "",
				"type": "bool"
			}
		],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "",
				"type": "address"
			}
		],
		"name": "bids",
		"outputs": [
			{
				"name": "",
				"type": "uint256"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [],
		"name": "auction_start",
		"outputs": [
			{
				"name": "",
				"type": "uint256"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [],
		"name": "highestBidder",
		"outputs": [
			{
				"name": "",
				"type": "address"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [],
		"name": "auction_end",
		"outputs": [
			{
				"name": "",
				"type": "uint256"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [],
		"name": "STATE",
		"outputs": [
			{
				"name": "",
				"type": "uint8"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [],
		"name": "highestBid",
		"outputs": [
			{
				"name": "",
				"type": "uint256"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"anonymous": false,
		"inputs": [
			{
				"indexed": true,
				"name": "highestBidder",
				"type": "address"
			},
			{
				"indexed": false,
				"name": "highestBid",
				"type": "uint256"
			}
		],
		"name": "BidEvent",
		"type": "event"
	},
	{
		"anonymous": false,
		"inputs": [
			{
				"indexed": false,
				"name": "withdrawer",
				"type": "address"
			},
			{
				"indexed": false,
				"name": "amount",
				"type": "uint256"
			}
		],
		"name": "WithdrawalEvent",
		"type": "event"
	},
	{
		"anonymous": false,
		"inputs": [
			{
				"indexed": false,
				"name": "message",
				"type": "string"
			},
			{
				"indexed": false,
				"name": "time",
				"type": "uint256"
			}
		],
		"name": "CanceledEvent",
		"type": "event"
	}
]
var contractAddress = "0xd5BD9DaA2B4Bd86B30C036EbDf030fa135B68125";

//  ws은 웹소켓, 웹소켓으로 가나슈에 접속
var web3 = new Web3('ws://localhost:7545');

var auctionContract =  new web3.eth.Contract(auctionABI);
auctionContract.options.address = contractAddress;
//auctionContract = auctionContract.at(contractAddress); 

var bidder; // auction_owner
web3.eth.getAccounts().then(function(acc){  // 가나슈에 있는 계정을 가지고 오기
	console.log(acc);
	bidder= acc[1]; // 현재 접속한 계정 , 경매자
	auctionContract.methods.auction_end().call().then((result)=>{
		document.getElementById("auction_end").innerHTML = result;
	});
	auctionContract.methods.highestBid().call().then((result)=>{
		console.log(result);
		var bidEther = web3.utils.fromWei(web3.utils.toBN(result),'ether');
		document.getElementById("HighestBid").innerHTML=bidEther;
	});
	auctionContract.methods.highestBidder().call().then( (result)=>{
		document.getElementById("HighestBidder").innerHTML=result;
	}); 
	auctionContract.methods.STATE().call().then( (result)=>{
		document.getElementById("STATE").innerHTML=result;
	});
	auctionContract.methods.Mycar().call().then( (result)=>{
		document.getElementById("car_brand").innerHTML=result[0];
		document.getElementById("registration_number").innerHTML=result[1];
	});
	var my_account = document.getElementById("my_account").value;
	auctionContract.methods.bids(my_account).call().then( (result)=>{
		document.getElementById("MyBid").innerHTML=result;
	});

	var auction_owner=null;
	auctionContract.methods.get_owner().call().then((result)=>{
		console.log(bidder);
		console.log(result);
		auction_owner = result;
		if(bidder != auction_owner)
			$("#auction_owner_operations").hide();
	});

});

function bid(){
	var my_account = document.getElementById("my_account").value;
	var mybid = document.getElementById('value').value;
	auctionContract.methods.bid().send({from:my_account
								,value:web3.utils.toWei(mybid,"ether"),gas:300000}).then((result)=>{
		console.log(result);
		document.getElementById("biding_status").innerHTML="성공한 경매, transaction ID : "
														  +result.transactionHash;
	});
	location.href="/auction?my_account="+my_account;
}

function cancel_auction(){
	auctionContract.methods.cancel_auction().call().then( (result)=>{
  		console.log(result)
	});
}

function Destruct_auction(){
	auctionContract.methods.destruct_auction().call().then( (result)=>{
  		console.log(result)
  	});
}


auctionContract.events.BidEvent(function(error, event){ 
      console.log(event); 
  })
.on("connected", function(subscriptionId){
	console.log(subscriptionId);
})
.on("data", function(event){
	console.log(event);
	$("#eventslog").html(event.returnValues.highestBidder 
						+ ' has bidden(' 
						+ event.returnValues.highestBid + ' wei)');
})
.on("changed", function(event){
	console.log(event);
})

auctionContract.events.CanceledEvent(function(error,event){
	console.log(event);
})
.on("connected", function(subscriptionId){
	console.log(subscriptionId);
})
.on("data", function(event){
	console.log(event);
	$("#eventslog").html(event.args.message + 'at' + event.args.time);
})
.on("changed", function(event){
	console.log(event);
})








