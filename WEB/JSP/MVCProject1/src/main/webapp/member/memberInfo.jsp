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
회원 상세 페이지<br />
<table  border = 1>
<tr><th>고객 번호 </th><td>${memberDTO.memNum }</td></tr>
<tr><th>고객 이름  </th><td>${memberDTO.memName }</td></tr>
<tr><th>고객 가입일 </th><td>${memberDTO.memRegiDate } </td></tr>
<tr><th>고객 아이디 </th><td>${memberDTO.memId } </td></tr>
<tr><th>고객 연락처1 </th><td>${memberDTO.memPhone1 } </td></tr>
<tr><th>고객 연락처2  </th><td>${memberDTO.memPhone2 }</td></tr>
<tr><th>고객 주소  </th><td>${memberDTO.memAddr }</td></tr>
<tr><th>고객 이메일  </th><td>${memberDTO.memEmail }</td></tr>
<tr><th>성별  </th>
    <td><c:if test="${memberDTO.memGender == 'M' }"> 남자 </c:if>
        <c:if test="${memberDTO.memGender == 'F' }"> 여자 </c:if></td></tr>

<tr><th>생년월일 </th><td>${memberDTO.memBirth }</td></tr>
<tr><th><a href="memberList.mem" >회원리스트</a> | 
<a href="memberModify.mem?num=${memberDTO.memNum }" >회원 수정</a> |
<a href="memberDelete.mem?num=${memberDTO.memNum }" >회원 강퇴</a></th></tr> 
</table>
</body>
</html>