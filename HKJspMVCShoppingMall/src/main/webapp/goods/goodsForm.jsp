<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
��ǰ��� �������Դϴ�<br/>
<form action="goodsRegist.goods" method="post" enctype="multipart/form-data">
<table border=1>
 <caption>��ǰ���</caption>
 <tr><th>��ǰ��ȣ</th><td><input type="text" name="goodsNum" value="${goodsNum }" readonly="readonly"/>��ȣ�ڵ��ο�</td></tr>
 <tr><th>��ǰ��</th><td><input type="text" name="goodsName"/></td></tr>
 <tr><th>��ǰ ����</th><td><input type="number" name="goodsPrice"/></td></tr>
 <tr><th>��ǰ ����</th><td><textarea rows="10" cols="30" name="goodsContent"></textarea></td></tr>
 <tr><th>������</th><td><input type="text" name="company"/></td></tr>
 <tr><th>�̹���</th><td><input type="file" name="img1"/><br/><input type="file" name="img2"/><br/><input type="file" name="img3"/><br/></td></tr>
 <tr><th colspan=2><input type="submit" value="��ǰ ���"></th></tr>
</table>
</form>
</body>
</html>