<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="goodsModify.goods" method="get">
<table border=1>
	<caption>��ǰ �󼼺���</caption>
	<tr><th>��ǰ��ȣ</th><td><input type="text" name="goodsNum" value="${dto.goodsNum }" readonly="readonly"/></td></tr>
	<tr><th>��ǰ��</th><td><input type="text" name="goodsName" value="${dto.goodsName }" required="required"/></td></tr>
	<tr><th>��ǰ����</th><td><input type="number" name="goodsPrice" value="${dto.goodsPrice }" required="required"/></td></tr>
	<tr><th>��ǰ����</th><td><textarea name="goodsContent" rows="10" cols="30" required="required">${dto.goodsContent }</textarea></td></tr>
	<tr><th>������</th><td><input type="text" name="company" value="${dto.goodsCompany }" required="required"/></td></tr>
	<tr><th>����� ���</th><td><input type="text" name="employeeNum" value="${dto.employeeNum }" readonly="readonly"/></td></tr>
	<tr><th>�����</th><td><input type="date" name="goodsRegiDate" value="${dto.goodsRegiDate }" readonly="readonly"/></td></tr>
	<tr><th>������ ���� ���</th><td><input type="text" name="employeeUptNum" value="${dto.employeeUptNum }" readonly="readonly"/></td></tr>
	<tr><th>������ ������</th><td><input type="date" name="goodsUpdate" value="${dto.goodsUpdate }" readonly="readonly"/></td></tr>
	<tr><th colspan=2><input type="submit" value="���� �Ϸ�"/></th></tr>
</table>
</form>
</body>
</html>