<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
내 정보 보기 <br />
직원번호 : ${dto.employeeNum }<br />
이름 : ${dto.employeeName }<br />
연락처 : ${dto.employeePhone }<br />
주소 : ${dto.employeeAddr }<br />
입사일 : ${dto.employeeHireDate }<br />
<a href="empUpdate.naver?num=${dto.employeeNum }">수정</a> | 
<a href="#">홈으로 가기</a>
</body>
</html>