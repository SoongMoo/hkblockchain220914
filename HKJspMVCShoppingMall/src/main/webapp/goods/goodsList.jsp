<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
��ǰ ���<br/>
<table border=1>
	<tr><td>��ǰ��ȣ</td><td>��ǰ��</td><td>��ǰ����</td><td>�����</td></tr>
	<c:forEach items="${list }" var="dto">
	<tr><td><a href="goodsDetail.goods?goodsNum=${dto.goodsNum }">${dto.goodsNum }</a></td><td>${dto.goodsName }</td><td>${dto.goodsPrice }</td><td>${dto.goodsRegiDate }</td></tr>
	</c:forEach>
</table>
<a href="goodsWrite.goods">��ǰ �߰�</a>
</body>
</html>