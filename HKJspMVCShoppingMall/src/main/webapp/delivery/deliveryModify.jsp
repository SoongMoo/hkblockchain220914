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
배송정보 수정<br />
<form action="deliveryUpdate.deli" method="get">
주문번호 : <input type = "text" value="${dto.purchaseNum }" name="purchaseNum"  readonly="readonly"/><br />
송장번호 : <input type = "text" value="${dto.deliveryNum }" required="required" name="deliveryNum"/><br /> 
송장입력 날짜 : ${dto.deliveryDate } <br />
배송상태 : <select name="deliveryState" >
			<option <c:if test="${dto.deliveryState == '배송중' }">selected</c:if>>배송중</option>
			
			<option <c:if test="${dto.deliveryState == '배송완료' }">selected</c:if>>배송완료</option>
		</select>
<br />
<input type="submit" value="배송정보수정" />
</body>
</html>