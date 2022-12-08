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
	<caption>��ǰ �󼼺���</caption>
	<tr><th>��ǰ��ȣ</th><td>${dto.goodsNum }</td></tr>
	<tr><th>��ǰ��</th><td>${dto.goodsName }</td></tr>
	<tr><th>��ǰ����</th><td>${dto.goodsPrice }</td></tr>
	<tr><th>��ǰ����</th><td>${dto.goodsContent }</td></tr>
	<tr><th>������</th><td>${dto.company }</td></tr>
	<tr><th>����� ���</th><td>${dto.employeeNum }</td></tr>
	<tr><th>�����</th><td>${dto.goodsRegiDate }</td></tr>
	<tr><th>������ ���� ���</th><td>${dto.employeeUptNum }</td></tr>
	<tr><th>������ ������</th><td>${dto.goodsUptDate }</td></tr>
	<tr><th colspan=2>
		<c:forTokens items="${dto.goodsImage }" delims="`" var="img">
		<img src="goods/images/${img }"/><br/>
		</c:forTokens>
		</th></tr>
	<tr><th colspan=2><a href="goodsUpdate.goods?goodsNum=${dto.goodsNum }">��ǰ ����</a> | <a href="goodsDel.goods?goodsNum=${dto.goodsNum }">��ǰ ����</a> | <a href="goodsList.goods">��ǰ���</a></th></tr>
</table>
</body>
</html>