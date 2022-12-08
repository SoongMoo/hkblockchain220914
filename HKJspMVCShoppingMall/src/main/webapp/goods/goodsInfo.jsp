<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border=1>
	<caption>상품 상세보기</caption>
	<tr><th>상품번호</th><td>${dto.goodsNum }</td></tr>
	<tr><th>상품명</th><td>${dto.goodsName }</td></tr>
	<tr><th>상품가격</th><td>${dto.goodsPrice }</td></tr>
	<tr><th>상품설명</th><td>${dto.goodsContent }</td></tr>
	<tr><th>제조사</th><td>${dto.company }</td></tr>
	<tr><th>등록한 사원</th><td>${dto.employeeNum }</td></tr>
	<tr><th>등록일</th><td>${dto.goodsRegiDate }</td></tr>
	<tr><th>마지막 수정 사원</th><td>${dto.employeeUptNum }</td></tr>
	<tr><th>마지막 수정일</th><td>${dto.goodsUptDate }</td></tr>
	<tr><th colspan=2>
		<c:forTokens items="${dto.goodsImage }" delims="`" var="img">
		<img src="goods/images/${img }"/><br/>
		</c:forTokens>
		</th></tr>
	<tr><th colspan=2><a href="goodsUpdate.goods?goodsNum=${dto.goodsNum }">상품 수정</a> | <a href="goodsDel.goods?goodsNum=${dto.goodsNum }">상품 삭제</a> | <a href="goodsList.goods">상품목록</a></th></tr>
</table>
</body>
</html>