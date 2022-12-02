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
<c:forEach items="${list }" var="dto">
<p>
<table>
	<tr><td>${dto.memberNum }</td></tr>
	<tr><td>${dto.reviewSubject }</td></tr>
	<tr><td>${dto.reviewContent }</td></tr>
</table>
</p>
</c:forEach>
</body>
</html>