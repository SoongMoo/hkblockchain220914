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
<c:if test="${!empty authInfo }">
	<a href="boardList.board">게시글 보기</a><br />
	
	<a href="goodsList.goods">상품목록보기</a><br />
	<a href="employeeList.emp">직원 리스트 </a><br />
	<a href="memberList.mem">고객리스트</a><br />
	<a href="hklogout.login">로그아웃</a><br />
	<a href="#">마이 페이지</a><br />
</c:if>
<c:if test="${empty authInfo }">
<form action="hklogin.login" method="get">
	<table border = 1>
		<tr><td colspan=2>
				로그인 유지 | 아이디 저장
			</td></tr>
		<tr><td>
			<input type="text" name="userId" />
			</td>
			<td rowspan=2>
			<input type="submit" value="로그인" />
			</td></tr>
		<tr><td>
			<input type="password" name="userPw" />
		    </td></tr>
		<tr><td colspan=2>
				아이디 찾기/비밀번호 찾기 | 
				<a href="memberAgree.mem">회원가입</a>
			</td></tr>
	</table>
</form>
</c:if>
</body>
</html>