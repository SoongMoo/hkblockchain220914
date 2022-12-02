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
	<td><img src="goods/images/${dto.goodsImage.split('-')[0] }" 
			width="30px"/>
		${dto.goodsName }</td>
	<td><c:if test="${empty dto.conformNum }">
			 
			<a href="paymentOk.item?purchaseNum=${dto.purchaseNum }" >결제하기</a>
		</c:if>
		<c:if test="${!empty dto.conformNum and empty dto.deliveryState}">
			<a href="paymentDelete.item?purchaseNum=${dto.purchaseNum }" >결제취소</a>
		</c:if>
		<c:if test="${!empty dto.conformNum and dto.deliveryState == '배송중'}">배송중</c:if>
		<c:if test="${!empty dto.conformNum and dto.deliveryState == '배송완료' and empty dto.reviewNum }">
			<a href="revireRegist.review?goodsNum=${dto.goodsNum }">리뷰등록</a>
		</c:if>	
		<c:if test="${!empty dto.conformNum and !empty dto.reviewNum }">
			<a href="goodsReviewUpdate.review?reviewNum=${dto.reviewNum }">리뷰수정</a> 
			<a href="goodsReviewDelete.review?reviewNum=${dto.reviewNum }">리뷰삭제</a>
		</c:if>	
	</td></tr>
</c:forEach>

</table>
</body>
</html>