<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
배송정보 등록<br />
<form action="deliveryWrite.deli" method="get">
주문번호 : <input type = "text" value="${purchaseNum }" name="purchaseNum"  readonly="readonly"/><br />
송장번호 : <input type = "text" required="required" name="deliveryNum"/><br /> 
<input type="submit" value="송장번호등록" />
</form>
</body>
</html>