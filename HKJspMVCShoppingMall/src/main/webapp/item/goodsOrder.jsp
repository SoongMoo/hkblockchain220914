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
<table width="700" align="center">
<tr>
	<td>
	주문서
	<hr />
	1. 주문상품
	</td>
</tr>
</table>
<p>
<table width="700" align="center" >
	<tr><td>주문 상품 정보 </td><td>수량/상품금액</td></tr>
	<c:forEach items="${list }" var="dto">
	<tr><td><img src="goods/images/${dto.goodsImage.split('`')[0] }" width ="30"/><br /> 
	        ${dto.goodsName }
	    </td>
		<td>${dto.cartQty } / ${dto.totalPrice / dto.cartQty }</td></tr>
    </c:forEach>

</table>
</p>
<p>
<form action="goodsOrder.item" method="post">
<input type="hidden" name="goodsNums" />
<input type="hidden" name="goodsTotalPrice" />
<table width="700"  align="center">
<tr>
	<td align = "left">
		<table width="350">
			<tr><td colspan=2>2. 배송 정보</td></tr>
			<tr><td>받는 사람 </td>
			    <td><input type="text" name="receiveName" /></td></tr>
			<tr><td>받는 사람 주소 </td>
				<td><input type="text" name="receiveAddr" /></td></tr>
			<tr><td>받는 사람 연락처 </td>
				<td><input type="text" name="receivePhone" /></td></tr>
			<tr><td>주문 메세지 </td>
				<td><input type="text" name="receiveMessage" /></td></tr>
			<tr><td>결제방법</td>
				<td>
					<select name="paymentMethod">
							<option>카드</option>
							<option>카카오페이</option>
					</select>
				</td></tr>
		</table>
	</td>
	<td align = "left">
		<table width="350">
			<tr><td colspan=2 align="left">3. 결제금액</td></tr>
			<tr><td align="left"> 총결제 금액 <br /><br /><br /><br /><br /> </td>
			    <td>30000원<br /><br /><br /><br /><br /></td></tr>
			<tr><td align="center"  colspan=2><input type="submit" value="결제하기"/></td></tr>
		</table>
	</td>
</tr>
</table>
</form>
</p>
</body>
</html>