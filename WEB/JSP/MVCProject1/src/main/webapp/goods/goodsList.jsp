<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
</head>
<body>
<h2>상품목록</h2>
<table border = 1>
 <tr><td>상품번호</td><td>상품명 </td><td>가격 </td></tr>
 <c:forEach items="${lists }" var="dto" >
 	<tr><td>${dto.goodsNum }</td><td>${dto.goodsName } </td><td>${dto.goodsPrice } </td></tr>
 </c:forEach>
</table>
<a href="goodsWrite.goods">상품등록</a> 
</body>
</html>