<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberForm.jsp</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script>
$(function(){
	$("#frm").submit(function(){
		if($("#memPw").val() != $("#memPwCon").val()){
			alert("비밀번호와 비밀번호확인이 일치하지 않습니다.");
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
<h2>고객 등록</h2>
<form action="memberWrite.mem" method="get" name="frm" id="frm">
<table border = 1>

<tr><td>고객 번호 </td><td> <input type="text" name="memNum" required="required"></td></tr>
<tr><td>고객 이름 </td><td> <input type="text" name="memName" required="required"></td></tr>
<tr><td>고객 생년월일 </td><td> <input type="datetime-local" name="memBirth" required="required"></td></tr>
<tr><td>고객 성별 </td><td> <input type="radio" name="memGender" value="F" checked/>여자
                          <input type="radio" name="memGender" value="M" />남자</td></tr>
<tr><td>고객 가입일 </td><td> <input type="date" name="memRegiDate" required="required"/></td></tr>
<tr><td>고객 아이디  </td><td><input type="text" name="memId" required="required">
<tr><td>고객 비밀번호 </td><td> <input type="password" name="memPw" id="memPw" required="required"></td></tr>
<tr><td>고객 비밀번호 확인 </td><td> <input type="password" name="memPwCon" id="memPwCon" required="required"></td></tr>
<tr><td>고객 연락처1 </td><td> <input type="tel" name="memPhone1" placeholder="031-1234-1234"></td></tr>
<tr><td>고객 연락처2 </td><td> <input type="tel" name="memPhone2"></td></tr>
<tr><td>고객 주소 </td><td> <input type="text" name="memAddr"></td></tr>
<tr><td>고객 이메일 </td><td> <input type="email" name="memEmail"></td> </tr>
<tr><td colspan=2 align=center><input type="submit" value="회원 등록" /></td></tr>
</table>
</form>
</body>
</html>