<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.*" %>
<%
	Cookie [] cookies = request.getCookies();
	if(cookies != null && cookies.length > 0){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("autoLogin")){
				AuthInfo authInfo = new AuthInfo();
				authInfo.setUserId(cookie.getValue());
				session.setAttribute("authInfo", authInfo);
			}
			if(cookie.getName().equals("storeId")){
				request.setAttribute("storeId", cookie.getValue());
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${authInfo.grade}
<c:if test="${!empty authInfo }">
	<a href="boardList.board">게시글 보기</a><br />
	<a href="hklogout.login">로그아웃</a><br />
	<c:if test="${authInfo.grade == 'emp' }">
		<a href="goodsList.goods">상품목록보기</a><br />
		<a href="employeeList.emp">직원 리스트 </a><br />
		<a href="memberList.mem">고객리스트</a><br />
		
		<a href="empMyPage.emp">직원 마이 페이지</a><br />
	</c:if>
	<c:if test="${authInfo.grade == 'mem' }">
		<a href="mypage.mem">마이 페이지</a><br />
	</c:if>
</c:if>
<c:if test="${empty authInfo }">
<form action="hklogin.login" method="get">
	<table border = 1>
		<tr><td colspan=2>
				<input type="checkbox" name="keeplogin" value="on"/>로그인 유지 | 
				<input type="checkbox" name="storeId" value="store"
					<c:if test="${storeId != null }">checked</c:if>
				/>아이디 저장
			</td></tr>
		<tr><td>
			<input type="text" name="userId" value="${storeId }"/>
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