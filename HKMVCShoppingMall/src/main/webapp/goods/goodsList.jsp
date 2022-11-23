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
상품리스트 <br />
<table border = 1>
	<tr><td>상품번호</td><td>상품명</td><td>가격</td><td>등록일</td></tr>
	<c:forEach items="${list }" var="dto">
		<tr><td>${dto.goodsNum }</td><td>${dto.goodsName }</td>
		<td>${dto.goodsPrice }</td><td>${dto.goodsRegiDate }</td></tr>
	</c:forEach>
</table>
<a href="goodsWrite.goods">상품등록</a>
</body>
</html>