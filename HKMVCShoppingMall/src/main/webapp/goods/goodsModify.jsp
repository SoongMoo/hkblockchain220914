<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="goodsRegist.goods" method="get" >
<table border = 1>
	<caption>상품 등록</caption>
	<tr><th>상품번호</th>
		<td><input type="text" name="goodsNum" readonly="readonly" 
			value="${dto.goodsNum }"></td></tr>
	<tr><th>상품명</th>
		<td><input type="text" name="goodsName" 
			value="${dto.goodsName }"></td></tr>
	<tr><th>상품 가격</th>
		<td><input type="number" name="goodsPrice" 
			value="${dto.goodsPrice}" ></td></tr>
	<tr><th>상품 설명</th>
		<td><textarea rows="10" cols="30" name="goodscontent">${dto.goodsContent }</textarea> </td></tr>
	<tr><th>제조사</th>
		<td><input type="text" name="company" 
			value="${dto.company}"></td></tr>
	<tr><th>등록한 사원</th>
		<td><input type="text" name="employeeNum" readonly="readonly"
			value="${dto.employeeNum}"></td></tr>
	<tr><th>등록일</th>
		<td><input type="date" name="goodsRegiDate" readonly="readonly"
			value="${dto.goodsRegiDate}"></td></tr>
	<tr><th>마지막 수정 사원</th>
		<td><input type="text" name="employeeUptNum" readonly="readonly"
			value="${dto.employeeUptNum}"></td></tr>
	<tr><th>마지막 수정일</th>
		<td><input type="date" name="goodsUpdDate" readonly="readonly"
			value="${dto.goodsUpdDate}"></td></tr>
	<tr><th colspan=2>
			<input type="submit" value="상품등록"/>
		</th></tr>
</table>
</form>	
</body>
</html>