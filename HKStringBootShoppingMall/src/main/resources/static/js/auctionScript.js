const MYNFT_ABI = [
	{
		"constant": true,
		"inputs": [],
		"name": "name",
		"outputs": [
			{
				"name": "",
				"type": "string"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "_tokenId",
				"type": "uint256"
			}
		],
		"name": "getApproved",
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
		"inputs": [
			{
				"name": "_to",
				"type": "address"
			},
			{
				"name": "_tokenId",
				"type": "uint256"
			}
		],
		"name": "approve",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [],
		"name": "totalSupply",
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
		"constant": false,
		"inputs": [
			{
				"name": "_from",
				"type": "address"
			},
			{
				"name": "_to",
				"type": "address"
			},
			{
				"name": "_tokenId",
				"type": "uint256"
			}
		],
		"name": "transferFrom",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "_owner",
				"type": "address"
			},
			{
				"name": "_index",
				"type": "uint256"
			}
		],
		"name": "tokenOfOwnerByIndex",
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
		"constant": false,
		"inputs": [
			{
				"name": "_from",
				"type": "address"
			},
			{
				"name": "_to",
				"type": "address"
			},
			{
				"name": "_tokenId",
				"type": "uint256"
			}
		],
		"name": "safeTransferFrom",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [
			{
				"name": "_name",
				"type": "string"
			},
			{
				"name": "_symbol",
				"type": "string"
			}
		],
		"name": "initialize",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "_tokenId",
				"type": "uint256"
			}
		],
		"name": "exists",
		"outputs": [
			{
				"name": "",
				"type": "bool"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "_index",
				"type": "uint256"
			}
		],
		"name": "tokenByIndex",
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
		"inputs": [
			{
				"name": "_tokenId",
				"type": "uint256"
			}
		],
		"name": "ownerOf",
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
		"inputs": [
			{
				"name": "_owner",
				"type": "address"
			}
		],
		"name": "balanceOf",
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
		"name": "symbol",
		"outputs": [
			{
				"name": "",
				"type": "string"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [
			{
				"name": "_to",
				"type": "address"
			},
			{
				"name": "_approved",
				"type": "bool"
			}
		],
		"name": "setApprovalForAll",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [
			{
				"name": "_from",
				"type": "address"
			},
			{
				"name": "_to",
				"type": "address"
			},
			{
				"name": "_tokenId",
				"type": "uint256"
			},
			{
				"name": "_data",
				"type": "bytes"
			}
		],
		"name": "safeTransferFrom",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [
			{
				"name": "_to",
				"type": "address"
			},
			{
				"name": "_tokenId",
				"type": "uint256"
			},
			{
				"name": "_tokenURI",
				"type": "string"
			}
		],
		"name": "registerUniqueToken",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "_tokenId",
				"type": "uint256"
			}
		],
		"name": "tokenURI",
		"outputs": [
			{
				"name": "",
				"type": "string"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "_owner",
				"type": "address"
			},
			{
				"name": "_operator",
				"type": "address"
			}
		],
		"name": "isApprovedForAll",
		"outputs": [
			{
				"name": "",
				"type": "bool"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"inputs": [
			{
				"name": "_name",
				"type": "string"
			},
			{
				"name": "_symbol",
				"type": "string"
			}
		],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "constructor"
	},
	{
		"anonymous": false,
		"inputs": [
			{
				"indexed": false,
				"name": "_by",
				"type": "address"
			},
			{
				"indexed": false,
				"name": "_tokenId",
				"type": "uint256"
			}
		],
		"name": "TokenRegistered",
		"type": "event"
	},
	{
		"anonymous": false,
		"inputs": [
			{
				"indexed": true,
				"name": "_from",
				"type": "address"
			},
			{
				"indexed": true,
				"name": "_to",
				"type": "address"
			},
			{
				"indexed": false,
				"name": "_tokenId",
				"type": "uint256"
			},
			{
				"indexed": false,
				"name": "_timestamp",
				"type": "uint256"
			}
		],
		"name": "Transfer",
		"type": "event"
	},
	{
		"anonymous": false,
		"inputs": [
			{
				"indexed": true,
				"name": "_owner",
				"type": "address"
			},
			{
				"indexed": true,
				"name": "_approved",
				"type": "address"
			},
			{
				"indexed": false,
				"name": "_tokenId",
				"type": "uint256"
			}
		],
		"name": "Approval",
		"type": "event"
	},
	{
		"anonymous": false,
		"inputs": [
			{
				"indexed": true,
				"name": "_owner",
				"type": "address"
			},
			{
				"indexed": true,
				"name": "_operator",
				"type": "address"
			},
			{
				"indexed": false,
				"name": "_approved",
				"type": "bool"
			}
		],
		"name": "ApprovalForAll",
		"type": "event"
	}
]

const AUCTIONS_ABI = [
	{
		"constant": false,
		"inputs": [
			{
				"name": "_auctionId",
				"type": "uint256"
			},
			{
				"name": "_to",
				"type": "address"
			}
		],
		"name": "finalizeAuction",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "_auctionId",
				"type": "uint256"
			}
		],
		"name": "getAuctionById",
		"outputs": [
			{
				"name": "name",
				"type": "string"
			},
			{
				"name": "price",
				"type": "uint256"
			},
			{
				"name": "metadata",
				"type": "string"
			},
			{
				"name": "tokenId",
				"type": "uint256"
			},
			{
				"name": "repoAddress",
				"type": "address"
			},
			{
				"name": "owner",
				"type": "address"
			},
			{
				"name": "active",
				"type": "bool"
			},
			{
				"name": "finalized",
				"type": "bool"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "",
				"type": "uint256"
			}
		],
		"name": "auctions",
		"outputs": [
			{
				"name": "name",
				"type": "string"
			},
			{
				"name": "price",
				"type": "uint256"
			},
			{
				"name": "metadata",
				"type": "string"
			},
			{
				"name": "tokenId",
				"type": "uint256"
			},
			{
				"name": "repoAddress",
				"type": "address"
			},
			{
				"name": "owner",
				"type": "address"
			},
			{
				"name": "active",
				"type": "bool"
			},
			{
				"name": "finalized",
				"type": "bool"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [
			{
				"name": "_repoAddress",
				"type": "address"
			},
			{
				"name": "_tokenId",
				"type": "uint256"
			},
			{
				"name": "_auctionTitle",
				"type": "string"
			},
			{
				"name": "_metadata",
				"type": "string"
			},
			{
				"name": "_price",
				"type": "uint256"
			}
		],
		"name": "createAuction",
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
		"inputs": [],
		"name": "getCount",
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
		"inputs": [
			{
				"name": "_owner",
				"type": "address"
			}
		],
		"name": "getAuctionsOf",
		"outputs": [
			{
				"name": "",
				"type": "uint256[]"
			}
		],
		"payable": false,
		"stateMutability": "view",
		"type": "function"
	},
	{
		"constant": true,
		"inputs": [
			{
				"name": "",
				"type": "address"
			},
			{
				"name": "",
				"type": "uint256"
			}
		],
		"name": "auctionOwner",
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
		"inputs": [
			{
				"name": "_owner",
				"type": "address"
			}
		],
		"name": "getAuctionsCountOfOwner",
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
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "fallback"
	},
	{
		"anonymous": false,
		"inputs": [
			{
				"indexed": false,
				"name": "_owner",
				"type": "address"
			},
			{
				"indexed": false,
				"name": "_auctionId",
				"type": "uint256"
			}
		],
		"name": "AuctionFinalized",
		"type": "event"
	},
	{
		"anonymous": false,
		"inputs": [
			{
				"indexed": false,
				"name": "_owner",
				"type": "address"
			},
			{
				"indexed": false,
				"name": "_auctionId",
				"type": "uint256"
			}
		],
		"name": "AuctionCreated",
		"type": "event"
	}
]


const GAS_AMOUNT=500000;

const MYNFT_CA = "0x922d90fFe03abaE20f01DB0e508bb8396cF876b1";
const AUCTIONS_CA = "0x2e584C2A2c6Fbef9FAfd84742A5bC52645fC929D";

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
	web3.eth.defaultAccount = web3.eth.accounts[0];
	getDefault();
});
function getDefault() {
	web3.eth.getAccounts(function(e, r) {
		data[0].account = r[0];
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
									console.log("txhash", transactionHash);
									alert(transactionHash);
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



