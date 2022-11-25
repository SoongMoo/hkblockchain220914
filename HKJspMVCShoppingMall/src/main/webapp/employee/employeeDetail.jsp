<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
직원 상세 정보 <br />
직원번호 : ${dto.employeeNum }<br />
직원명 : ${dto.employeeName }<br />
직원연락처 : ${dto.employeePhone }<br />
직원주소 : ${dto.employeeAddr }<br />
입사일 : ${dto.hireDate }<br />

<a href="employeeUpdate.emp?num=${dto.employeeNum }">수정</a> | 
<a href="employeedelete.emp?num=${dto.employeeNum }">퇴사</a> | 
<a href="employeeList.emp">직원 리스트</a>

</body>
</html>