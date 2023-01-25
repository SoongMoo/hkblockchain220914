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
		"outputs": [],
		"payable": false,
		"stateMutability": "nonpayable",
		"type": "function"
	}
]

var isVote = false;
const contract_address = "0x073b389008440cbf09d367A7228e3b0C8Bd0dAC2";

window.addEventListener("load", function() {
	window.web3 = new Web3(new Web3.providers.HttpProvider("http://localhost:7545"));
	web3.eth.defaultAccount = web3.eth.accounts[0]; 
	voting = web3.eth.contract(abi).at(contract_address);
	getDefault();
})

function getDefault() {
	//계정
	web3.eth.getAccounts(function(e, r) {
		console.log(r)
		account_address = r[0];
		console.log("account : " + account_address);
	});
	//투표 여부
	voting.getVoter(function(e, r) {
		vote_tf = r;
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
	
	if(vote_tf){
		alert('이미 투표를 하였습니다.');
		return;
	}
	
	voting.setVote(name, { gas: 200000 }, function(e, r) {
			vote_transaction_id = r;
			$.ajax({
				url: '/voteWrite',
				type: 'post',
				data:{'idx': idx,'name':name,'account':account_address,'tx_id':r},
				success: function(resp) {
					console.log('resp :: ' + resp);
					if(resp){
						location.reload();
					}else{
						alert("디비 : 이미 투표하였습니다.");
					}
				},
				error:function(){
					alert("사버오류");
				}							
			});
	};
}


