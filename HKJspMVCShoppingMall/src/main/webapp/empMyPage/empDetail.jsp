<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
내 정보 보기<br/>
직원번호 : ${dto.employeeNum }<br />
직원명 : ${dto.employeeName }<br />
직원연락처 : ${dto.employeePhone }<br />
직원주소 : ${dto.employeeAddr }<br />
입사일 : ${dto.hireDate }<br />

<a href="empUpdate.naver">수정</a> |
<a href="empMyPage.naver">홈으로 가기</a>
</body>
</html>