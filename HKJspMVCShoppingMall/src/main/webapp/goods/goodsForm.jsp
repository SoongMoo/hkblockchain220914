<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
상품등록 페이지입니다<br/>
<form action="goodsRegist.goods" method="post" enctype="multipart/form-data">
<table border=1>
 <caption>상품등록</caption>
 <tr><th>상품번호</th><td><input type="text" name="goodsNum" value="${goodsNum }" readonly="readonly"/>번호자동부여</td></tr>
 <tr><th>상품명</th><td><input type="text" name="goodsName"/></td></tr>
 <tr><th>상품 가격</th><td><input type="number" name="goodsPrice"/></td></tr>
 <tr><th>상품 설명</th><td><textarea rows="10" cols="30" name="goodsContent"></textarea></td></tr>
 <tr><th>제조사</th><td><input type="text" name="company"/></td></tr>
 <tr><th>이미지</th><td><input type="file" name="img1"/><br/><input type="file" name="img2"/><br/><input type="file" name="img3"/><br/></td></tr>
 <tr><th colspan=2><input type="submit" value="상품 등록"></th></tr>
</table>
</form>
</body>
</html>