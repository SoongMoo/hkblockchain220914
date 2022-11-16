<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${authInfo.userEmail }님의 정보<br />
<ul>
	<li><a href="memberDscript.mem">내정보 보기</a></li>
	<li><a href="memberPass.mem">비밀번호 변경</a></li>
	<li><a href="memberDrop.mem">탈퇴</a></li>
</ul>
</body>
</html>