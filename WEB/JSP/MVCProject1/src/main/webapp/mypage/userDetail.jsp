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
${authInfo.userId }님의 정보입니다.<br />
고객 번호 : ${dto.memNum }<br />
이름 : ${dto.memName }<br />
가입일 : ${dto.memRegiDate } <br />
아이디: ${dto.memId }<br />
연락처1 : ${dto.memPhone1 }<br />
연락처2 : ${dto.memPhone2 }<br />
주소 : ${dto.memAddr }<br />
이메일 : ${dto.memEmail }<br />
성별 : <c:if test="${dto.memGender == 'M' }">남자</c:if>
      <c:if test="${dto.memGender == 'F' }">여자</c:if> <br />
생년월일 : ${dto.memBirth } <br />
<a href="memberInfoModify.mem"> 내 정보 수정 </a>
</body>
</html>