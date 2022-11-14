<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script>
	$(function(){
		$("#frm").submit(function(){
			if($("#memPw").val() != $("#memPwCon").val()){
				alert("비밀번호와 비밀번호확인이 다릅니다.");
				$("#memPw").val("");
				$("#memPwCon").val("");
				$("#memPw").focus();
				return false;
			}
		});
	});
</script>
</head>
<body>
<form action="memberJoinOk.mem" method="get" name="frm" id="frm">
이름 : <input type="text" name="memName" required="required"> <br />
아이디: <input type="text" name="memId" required="required"><br />
비밀번호 : <input type="password" name="memPw" id="memPw" required="required"><br />
비밀번호 확인 : <input type="password" name="memPwCon" id="memPwCon" required="required"><br />
연락처 1 : <input type="tel" name="memPhone1" required="required"><br />
연락처 2 : <input type="tel" name="memPhone2"><br />
주소 : <input type="text" name="memAddr" required="required"><br />
이메일 :  <input type="email" name="memEmail"><br />
성별 : <input type="text" name="memGender"  size=1 maxlength="1" required="required"/>
		뒷자리 첫번째 숫자를 입력하세요.<br />
생년월일 : <input type="date" name="memBirth" required="required"><br />
<input type="submit" value="회원 등록" />
</form>
</body>
</html>