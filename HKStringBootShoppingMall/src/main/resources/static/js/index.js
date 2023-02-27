window.addEventListener("load", function() {
	web3 = new Web3(new Web3.providers.HttpProvider("http://localhost:7545"));
});
function onFileSelected(event) {
	const file = event.target.files[0];
	const reader = new FileReader();

	reader.onload = function(event) {
		console.log("safadfca : " + event.target.result);

		const privateKey = event.target.result;
		const account = web3.eth.accounts.privateKeyToAccount(privateKey);
		const address = account.address;
		console.log('address : ' + address );
		$.ajax({
			type: "post",
			dataType: "text",
			url: "/login/privateLogin",
			data: { "address": address, 'privateKey':privateKey},
			success: function(result) {
				if (result == "1") {
					location.href = "/";
				} else {
					alert("인증서에 해당하는 사용자가 없어 로그인되지 않았습니다.");
					location.reload();
				}
			},
			error: function() {
				alert("오류입니다.");
				return false;
			}
		});
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
	
*/



