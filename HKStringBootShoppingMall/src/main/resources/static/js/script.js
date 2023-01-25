function candidate() {
		window.open("candidate","후보자 등록",
		"width=300, height=200, top=100, left=100");
}


function setRemoveCandidate(idx){
	$.ajax({
		url:"voteRemoveCandidate",
		type: 'post',
		data: { idx: idx},
		success: function(resp) {
			if(resp){
				location.reload();
			}else{
				alert("삭제되지 않았습니다.");
			}
		},
		error: function(){
			alert("서버 오류");
		}
	});
}

var abi = [
	{
		"constant": true,
		"inputs": [],
		"name": "getVoter",
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
		"inputs": [],
		"name": "getCandidate",
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
		"inputs": [],
		"name": "setVote_cancel",
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	},
	{
		"constant": false,
		"inputs": [
			{
				"name": "name",
				"type": "string"
			}
		],
		"name": "setVote",
		"outputs": [
			{
				"name": "",
				"type": "address"
			}
		],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	}
]

var isVote = false;
const contract_address = "0x6818645B4Dc0048E949eF1C228984e48536898E7";

window.addEventListener("load", function() {
	window.web3 = new Web3(new Web3.providers.HttpProvider("http://localhost:7545"));
	// web3.eth.defaultAccount = web3.eth.accounts[0]; 
	
	console.log("web3.eth.accounts :: " + web3.eth.accounts);
	voting = web3.eth.contract(abi).at(contract_address);
	//getDefault();
})


function getDefault() {
	account_address = $("#voteAccount").val();
	web3.eth.defaultAccount = account_address ;
	//계정
	/*
	web3.eth.getAccounts(function(e, r) {
		console.log("account :: " + r)
		account_address = r[0];
		
		console.log("account : " + account_address);
	});
	*/
	//투표 여부
	voting.getVoter(function(e, r) {
		isVote = r;
		console.log('Smart Contract Vote :: ' + r);
		if (r) {
			voting.getCandidate(function(e1,r1) {
				vote_candidate = r1;
				console.log('Smart Contract Vote Candidate :: ' + r1);
			});
		}
	});
}

function setVote(idx, name){
	getDefault();
	
	if(isVote){
		alert('Contract에 이미 투표를 하였습니다.');
		return;
	}
	if(account_address == ""){
		alert("주소를 입력해주세요.");
		return;
	}
	voting.setVote(name, { gas: 200000 }, function(e, r) {
			vote_transaction_id = r;
			console.log("vote_transaction_id :: " +r);
			if(r){
				$.ajax({
					url: '/voteWrite',
					type: 'post',
					data:{'idx': idx,'name':name,'account':account_address,'tx_id':r},
					success: function(resp) {
						console.log('resp :: ' + resp);
						if(resp){
							alert("성공입니다.");
							location.href="vote?account="+account_address;
						}else{
							alert("디비 : 이미 투표하였습니다.");
						}
					},
					error:function(){
						alert("서버오류");
					}							
				});
			}
	});
}
function setVote_cancel(){
	getDefault();
	if(!isVote){
		alert('투표를 안했습니다.');
		return;
	}
	if(account_address == ""){
		alert("주소를 입력해주세요.");
		return;
	}
	if (confirm('투표를 취소 하시겠습니까?')) {
		voting.setVote_cancel({gas:200000},function(e, r){
			vote_transaction_id = r;
			console.log('vote_transaction_id :: ' + r);
			if(r){
				$.ajax({
					url: '/vote_cancel',
					type: 'post',
					data: { account: account_address },
					success: function(resp) {
						console.log('resp :: ' + resp);
						location.href="vote?account="+account_address;
					},
					error:function(){
						alert("서버오류");
					}
				});
			}
		});
	}
}











