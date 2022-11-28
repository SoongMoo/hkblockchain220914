<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원등록</title>
</head>
<body>
<form action="employeeJoinOk.emp" method="get">
<table border=1>
	<tr><td>직원번호</td><td><input type="text" name="employeeNum" value="${employeeNum }" />번호자동부여</td></tr>
	<tr><td>직원이름</td><td><input type="text" name="employeeName" /></td></tr>
	<tr><td>직원비밀번호</td><td><input type="password" name="employeePw" /></td></tr>
	<tr><td>직원비밀번호확인</td><td><input type="password" name="employeePwCon" /></td></tr>
	<tr><td>직원주소</td><td><input type="text" name="employeeAddr" /></td></tr>
	<tr><td>직원연락처</td><td><input type="tel" name="employeePhone" /></td></tr>
	<tr><td>직원입사일</td><td><input type="date" name=employeeHireDate /></td></tr>	
	<tr><td colspan=2 align="center"><input type="submit" value="직원등록완료"/></td></tr>
</table>
</form>
</body>
</html>