<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList.jsp</title>
</head>
<body>
회원리스트 페이지입니다.<br />
<table border = 1>
	<tr><td>고객번호 </td><td>고객명 </td><td>아이디</td><td>연락처</td></tr>
	<c:forEach items="${lists }" var="dto" >
	<tr><td><a href="memberDetail.mem?num=${dto.memNum }">${dto.memNum }</a></td><td>${dto.memName }</td>
	    <td>${dto.memId }</td><td>${dto.memPhone1 }</td></tr>
	</c:forEach>
</table>
<a href="memberRegist.mem">회원등록</a>
</body>
</html>