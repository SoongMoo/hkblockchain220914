<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="hklogin.login" method="get">
	<table border = 1>
		<tr><td colspan=2>
				로그인 유지 | 아이디 저장
			</td></tr>
		<tr><td>
			<input type="text" name="userId"  valus="${userId }" />
			<br /><span style="color:red;">${errId }</span>
			</td>
			<td rowspan=2>
			<input type="submit" value="로그인" />
			</td></tr>
		<tr><td>
			<input type="password" name="userPw" />
			<br /><span style="color:red;">${errPw }</span>
		    </td></tr>
		<tr><td colspan=2>
				아이디 찾기/비밀번호 찾기 | 
				<a href="memberAgree.mem">회원가입</a>
			</td></tr>
	</table>
</form>
</body>
</html>