<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script>
$(function(){
	$("#frm").submit(function(){
		if($("#memberPw").val() != $("#memberPwCon").val()){
			alert("비밀번호와 비밀번호확인이 다릅니다.");
			$("#memberPw").val("");
			$("#memberPwCon").val("");
			$("#memberPw").focus();
			return false;
		}
	});
});
</script>

</head>
<body>
<form action="userRegist.nhn"  method="get" name="frm" id="frm">
<table border="1">
	<tr><td>회원아이디</td>
		<td><input type="text" name="memberId" required="required"/></td></tr>
	<tr><td>회원비밀번호</td>
		<td><input type="password" name="memberPw" id="memberPw"/></td></tr>
	<tr><td>회원비밀번호확인</td>
		<td><input type="password" name="memberPwCon" id="memberPwCon"/></td></tr>
	<tr><td>회원명</td>
		<td><input type="text" name="memberName" /></td></tr>
	<tr><td>회원연락처</td>
		<td><input type="tel" name="memberPhone" /></td></tr>
	<tr><td>회원주소</td>
		<td><input type="text" name="memberAddr" /></td></tr>
	<tr><td>회원성별</td>
		<td><input type="radio" name="memberGender" value="F"/>여자
			<input type="radio" name="memberGender" value="M"/>남자</td></tr>
	<tr><td>회원생년월일</td>
		<td><input type="date" name="memberBirth" /></td></tr>
	<tr><td>회원이메일</td><td><input type="email" name="memberEmail" /></td></tr>
	<tr><td colspan=2>
		<input type="submit" value="회원가입" />
		<input type="button" value="회원가입 취소" 
			onclick ="javascript:location=<c:url value='/' /> "/> 
		</td>
	</tr>
</table>
</form>
</body>
</html>