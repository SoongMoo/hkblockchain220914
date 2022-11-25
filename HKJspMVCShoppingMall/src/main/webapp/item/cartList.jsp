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
<form action="itemBuy.item" method="get" onsubmit="return goodsCheck();">
<table width="600" align = "center">
<tr><td><input type="checkbox" id="checkBoxs" checked="checked" /></td>
	<td>이미지</td><td>제품이름</td><td>수량</td><td>합계금액</td>
	<td><input type="button" value="선택상품삭제" onclick="" /></td>
</tr>
<c:forEach items="${list }" var="dto">
<tr>
	<td><input type="checkbox" id="itemCk" checked="checked" name="prodCk[]" /></td>
	<td><img width="30" src="goods/images/${dto.goodsImage.split('`')[0] }" /></td><td>${dto.goodsName }</td>	
	<td>
		<a href="#">+</a> 
		${dto.cartQty } 
		<a href="#">-</a>
	</td>
	<td>${dto.totalPrice }</td>
	<td><input type="button" value="삭제" onclick="" /></td>
</tr>
</c:forEach>
<tr><td colspan="6" align="center">
		<input type="submit" value="구매하기"/>
	</td></tr>
</table>
</form>
</body>
</html>