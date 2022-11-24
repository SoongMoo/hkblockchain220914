<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = 1>
	<caption>${dto.goodsName } 상세보기</caption>
	<tr><th>상품번호</th><td>${dto.goodsNum }</td></tr>
	<tr><th>상품명</th><td>${dto.goodsName }</td></tr>
	<tr><th>상품 가격</th><td>${dto.goodsPrice }</td></tr>
	<tr><th>상품 설명</th><td>${dto.goodsContent }</td></tr>
	<tr><th>제조사</th><td>${dto.company }</td></tr>
	<tr><th>등록한 사원</th><td>${dto.employeeNum }</td></tr>
	<tr><th>등록일</th><td>${dto.goodsRegiDate }</td></tr>
	<tr><th>마지막 수정 사원</th><td>${dto.employeeUptNum }</td></tr>
	<tr><th>마지막 수정일</th><td>${dto.goodsUpdDate }</td></tr>
	<tr><th colspan=2>
		<a href="goodsUpdate.goods?goodsNum=${dto.goodsNum }">상품 수정</a> | 
		<a href="#">상품 삭제</a> | 
		<a href="goodsList.goods">상품 목록</a>
		</th></tr>
</table>
</body>
</html>