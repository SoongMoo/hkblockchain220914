<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script>
$(function(){
	$("#frm").submit(function(){
		if($("#employeePw").val() != $("#employeePwCon").val()){
			alert("��й�ȣ�� ��й�ȣȮ���� �ٸ��ϴ�.")
			$("#employeePw").val("");
			$("#employeePwCon").val("");
			$("#employeePw").focus();
			return false;
		}
	})
});
</script>
</head>
<body>
<form action="empPasswordPro.naver" method="get" name="frm" id="frm">
�� ��й�ȣ : <input type="password" name="employeePw" id="employeePw" required="required"/><br/>
�� ��й�ȣ Ȯ�� : <input type="password" name="employeePwCon" id="employeePwCon" required="required"/><br/>
<input type="submit" value="��й�ȣ ����"/>
</form>
</body>
</html>