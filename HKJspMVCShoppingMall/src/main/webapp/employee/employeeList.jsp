<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
직원 리스트 페이지<br />
<table border = 1>
	<tr><td>직원번호</td><td>직원명</td><td>입사일</td></tr>
	<c:forEach items="${list }" var="dto">
	<tr><td><a href="employeeDetail.emp?num=${dto.employeeNum }">
			${dto.employeeNum }
			</a>
		</td>
		<td>${dto.employeeName }</td><td>${dto.hireDate }</td></tr>
	</c:forEach>
</table>
<a href="employeeJoin.emp">직원등록</a>
</body>
</html>