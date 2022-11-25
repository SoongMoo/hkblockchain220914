<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script>
$(function(){
	$("#frm").submit(function(){
		if($("#memberPw").val() != $("#memberPwCon").val()){
			alert("비밀번호와 비밀번호 확인이 다릅니다.");
			$("#memberPw").val("");
			$("#memberPwCon").val("");
			$("#memberPw").focus();
			return false;
		}
	})
});
</script>
</head>
<body>
<form action="myPasswordPro.nhn" method="get" name="frm" id="frm">
새 비밀번호 : <input type="password" name="memberPw" id="memberPw" required="required"><br/>
새 비밀번호 확인 : <input type="password" name="memberPwCon" id="memberPwCon" required="required"><br/>
<input type="submit" value="확인"/>
</form>
</body>
</html>