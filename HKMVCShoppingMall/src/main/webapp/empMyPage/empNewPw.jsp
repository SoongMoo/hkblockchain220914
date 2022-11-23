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
		if($("#employeePw").val() == ""){
			alert("비밀번호를 입력해주세요.");
			return false;
		}
		if($("#employeePw").val() != $("#employeePwCon").val()){
			alert("비밀번호와 비밀번호확인이 다릅니다.");
			$("#employeePw").val("");
			$("#employeePwCon").val("");
			$("#employeePw").focus();
			return false;
		}
	});
});
</script>
</head>
<body>
<form action="empPasswordPro.naver" method="get" name="frm" id="frm">
새 비밀번호 : <input type="password" 
				name="employeePw" id="employeePw" required="required" /><br />
새 비밀번호 확인 : <input type="password" 
				name="employeePwCon" id="employeePwCon" required="required"/><br />
		
<input type="submit" value="비밀번호 변경"/>
</form>
</body>
</html>