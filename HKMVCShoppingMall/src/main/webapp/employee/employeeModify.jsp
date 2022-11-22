<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
직원 수정 페이지<br />
<form action="employeeModify.emp" method="post" >
직원번호 : <input type="text" name="employeeNum" value="${dto.employeeNum }"/> <br />
직원명 : <input type="text" name="employeeName" value="${dto.employeeName }"/> <br />
직원연락처 : <input type="tel" name="employeePhone" value="${dto.employeePhone }"/><br />
직원주소 : <input type="text" name="employeeAddr" value="${dto.employeeAddr }"/><br />
입사일 : <input type="date" name="employeeHireDate" value="${dto.employeeHireDate }"/><br />
<input type="submit" value="수정완료" />
<input type="button" onclick="javascript:history.back()" value="뒤로가기"/>
</form>

</body>
</html>