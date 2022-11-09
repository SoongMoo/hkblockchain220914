<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
제품등록페이지입니다.<br />
<form action = "goodsRegist.goods" name="frm" method="get">
<table border=1>
	<tr><td>제품번호</td>
		<td><input type="text" name="goodsNum" /></td></tr>
	<tr><td>제품이름</td>
		<td><input type="text" name="goodsName" /></td></tr>
	<tr><td>제품가격</td>
	    <td><input type="number" name="goodsPrice" min=1000 step="500" /></td></tr>
	<tr><td>제조일</td>
	    <td><input type="Date" name="goodsDate" /></td></tr>
	<tr><td>제품설명</td>
		<td><textarea rows="10" cols="60" name="goodsContent"></textarea></td></tr>
	<tr><td>수량</td>
	    <td><input type="number" name="goodsQty" min=1 step="1" value="1"/></td></tr>
	<tr><td>제조사</td>
		<td><input type="text" name="goodsCompany" /></td></tr>
	<tr><td>제품이미지</td>
	    <td></td></tr>
	<tr><td colspan=2 align=center><input type="submit" value="상품등록"/></td></tr>
</table>
</form>
</body>
</html>