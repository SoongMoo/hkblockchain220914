<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${dto.goodsName }<br />
<table width="600" >
	<tr><td rowspan=3 width="300" >
		<img width="300" src="goods/images/${dto.goodsImage.split('`')[0] }" />
		</td>
		<td width="300">${dto.goodsName }</td></tr>
	<tr><td>${dto.goodsPrice }</td></tr>
	<tr><td>${dto.company }</td></tr>
	<tr><td colspan=2>
		${dto.goodsContent }<br />
		<c:forTokens items="${dto.goodsImage }" delims="`" var="image" begin="1" >
		<img src="goods/images/${image }" /><br />
		</c:forTokens>
		</td></tr>
</table>
</body>
</html>