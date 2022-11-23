<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
상품등록 페이지입니다. <br />
<form action="goodsRegist.goods" method="get" >
<table border = 1>
	<caption>상품 등록</caption>
	<tr><th>상품번호</th>
		<td><input type="text" name="goodsNum" ></td></tr>
	<tr><th>상품명</th>
		<td><input type="text" name="goodsName"></td></tr>
	<tr><th>상품 가격</th>
		<td><input type="number" name="goodsPrice"></td></tr>
	<tr><th>상품 설명</th>
		<td><textarea rows="10" cols="30" name="goodscontent"></textarea> </td></tr>
	<tr><th>제조사</th>
		<td><input type="text" name="company"></td></tr>
	<tr><th colspan=2>
			<input type="submit" value="상품등록"/>
		</th></tr>
</table>
</form>	
</body>
</html>