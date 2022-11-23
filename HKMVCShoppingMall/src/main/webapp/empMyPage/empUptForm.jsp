<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="empModify.naver" method="post" >
직원번호 : <input type="text" name="employeeNum" readonly="readonly" 
			value="${dto.employeeNum }"/> <br />
이름 : <input type="text" name="employeeName" readonly="readonly" 
			 value="${dto.employeeName }"/> <br />
연락처 : <input type="tel" name="employeePhone" value="${dto.employeePhone }"/><br />
주소 : <input type="text" name="employeeAddr" value="${dto.employeeAddr }"/><br />
입사일 : <input type="date" name="employeeHireDate" readonly="readonly"
			 value="${dto.employeeHireDate }"/><br />
<input type="submit" value="내 정보 수정 완료" />
<input type="button" onclick="javascript:history.back()" value="뒤로가기"/>
</form>
</body>
</html>