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
<table width="800" align="center">
<tr><td>주문번호 / 결제번호</td><td>상품명 </td><td>주문상태</td></tr>
<c:forEach items="${list }" var="dto">
<tr><td><c:if test="${empty dto.conformNum }">${dto.purchaseNum } / 입금대기중</c:if>
		<c:if test="${!empty dto.conformNum }">${dto.purchaseNum } / ${dto.conformNum }</c:if>
	</td>
	<td>${dto.goodsName }</td>
	<td><c:if test="${empty dto.conformNum }">
			<a href="paymentOk.item?purchaseNum=${dto.purchaseNum }" >결제하기</a>
		</c:if>
		<c:if test="${!empty dto.conformNum and empty dto.delivery_state}">결제취소</c:if>
		<c:if test="${!empty dto.conformNum and !empty dto.delivery_state =='배송중'}">배송중</c:if>
		<c:if test="${dto.deliveryState == '배송완료' and empty dto.reviewContent }">리뷰등록</c:if>	
		<c:if test="${!empty dto.reviewContent }">
			리뷰수정 
			리뷰삭제
		</c:if>	
	</td></tr>
</c:forEach>

</table>
</body>
</html>