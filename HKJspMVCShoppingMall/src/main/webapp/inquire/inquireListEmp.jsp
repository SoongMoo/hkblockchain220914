<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1 >
	<tr><td>번호</td><td>문의제목</td><td>제품번호</td></tr>
	<c:forEach items="${list }" var="dto" varStatus="cnt">
		<tr><td><a href="inquireUpdateEmp.inq?inquireNum=${dto.inquireNum }" >${cnt.count }</a></td>
			<td>${dto.inquireSubject }</td>
		<td>${dto.goodsNum }</td></tr>
	</c:forEach>
</table>
</body>
</html>