<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
결제 페이지<br />
<form action="doPayment" method="post" >
<input type="hidden" name="purchaseNum" value="${purchaseNum }" />
<input type="hidden" name="totalPrice" value="${totalPrice }" />
<table >
	<tr><td>구매번호</td><td>${purchaseNum }</td></tr>
	<tr><td>결제금액</td><td>${totalPrice }원</td></tr>
	<tr><td>결제방법</td><td>카드</td></tr>
	<tr><td>카드번호</td><td><input type="text" name="cardNumber"/></td></tr>
	<tr><td align = "center" colspan="2">
		<input type="submit" value="결제 완료" />
		<input type="button" value="주문목록" onclick="javascript:location.href='orderList'"/>
		</td>
	</tr>
</table>
</form>
</body>
</html>