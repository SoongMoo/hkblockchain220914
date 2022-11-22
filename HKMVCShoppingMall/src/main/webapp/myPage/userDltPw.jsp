<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userDltPw.jsp</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script>
	$(function(){
		$("#frm").submit(function(){
			if($("#userPw").val() == ""){
				alert("비밀번호를 입력해주세요.");
				$("#userPw").focus();
				return false
			}else{
				con = confirm("정말 사실 리얼 진짜 탈퇴하시겠습니까?");
				if(!con){
					return false;
				}
			}
		});
	});
</script>
</head>
<body>
<form action="userDeleteOk.nhn" id="frm">
	<input type="password" name="userPw" id="userPw" /><br/>
	<span style="color:red">${errPw }</span><br />
	<input type="submit" value="탈퇴" />
</form>
</body>
</html>