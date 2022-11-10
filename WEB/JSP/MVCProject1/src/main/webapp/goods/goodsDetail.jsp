<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border=1>
	<tr><td>제품번호</td><td>${goods.goodsNum }</td></tr>
	<tr><td>제품이름</td><td>${goods.goodsName }</td></tr>
	<tr><td>제품가격</td><td>${goods.goodsPrice }</td></tr>
	<tr><td>제조일</td><td>${goods.goodsDate }</td></tr>
	<tr><td>제품설명</td><td>${goods.goodsContent }</td></tr>
	<tr><td>수량</td><td>${goods.goodsQty }</td></tr>
	<tr><td>제조사</td><td>${goods.goodsCompany }</td></tr>
	<tr><td colspan=2>
	    <a href="goodsUpdate.goods?num=${goods.goodsNum }">수정</a> | 
	    <a href="goodsDelete.goods?num=${goods.goodsNum }">삭제</a> | <a href="goodsList.goods">목록으로 가기</a>
	    </td></tr>
</table>
</body>
</html>



