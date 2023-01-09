<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>goodsList2.jsp</title>
<link href="/static/css/memberLayout.css" rel="stylesheet" >
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
</head>
<body>
<div id="wrapper">
	<div id="leftMenu">
		<ul>
			<li><a href="goodsList">상품 리스트</a></li>
			<li><a href="goodsList2">상품 리스트2</a></li>
			<li><a href="goodsRegist">상품 등록</a></li>
			<li><a href="goodsIpgoList">상품 입고 현황</a></li>
			<li><a href="goodsIpgo">상품 입고</a></li>
			<li><a href="purchaseList">주문 내역</a></li>
			<li><a href="goodsQuestion">상품 문의</a></li>
		</ul>
	</div>
<div id="MemberInfo">
상품관리<br />
<p>
<table width="600" >
<tr><th>
<form action="goodsList" method="get" >
	상품 조회 : <input type="search" name="goodsWord" size="50"/> 
	<input type="submit" value="검색" />
</form>
</th></tr>
</table>
</p>
<form action="goodsDels" method="post" id="frm">
<table border=1 width="600" >
	<tr>
		<th colspan="6">상품 리스트</th>
		<th width = "100">상품 개수 : ${count}</th>
	</tr>
	<tr>
		<th>번호</th><th>상품 번호</th>
		
		<th>이미지</th>
		
		<th>상품명</th><th>가격</th><th>조회수</th>
		<th><input type="submit" value="삭제"/></th>
	</tr>
	<c:forEach items="${list }" var="goodsCommand" varStatus="idx">
	<tr >
		<th>${(page -1) * limit + idx.count}</th>
		<th><a href="goodsDetail/${goodsCommand.goodsNum}">${goodsCommand.goodsNum}</a></th>
		<th><img src="/goods/upload/${goodsCommand.goodsMain}" width="30px" /></th>
		<th>${goodsCommand.goodsName}</th>
		<th>${goodsCommand.goodsPrice}</th>
		<th>${goodsCommand.visitCount}</th>
		<th><input type="checkbox" id="delete"  name="delete"/></th>
	</tr>
	</c:forEach>
</table>
</form>
</div>
</div>
</body>
</html>