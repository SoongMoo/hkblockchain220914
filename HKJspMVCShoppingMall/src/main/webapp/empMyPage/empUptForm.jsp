<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
내 정보 수정 페이지<br />
<form action="empModify.naver" method="post" >
직원번호 : <input type="text" name="employeeNum" value="${dto.employeeNum }" readonly="readonly"/> <br />
이름 : <input type="text" name="employeeName" value="${dto.employeeName }" readonly="readonly"/> <br />
연락처 : <input type="tel" name="employeePhone" value="${dto.employeePhone }"/><br />
주소 : <input type="text" name="employeeAddr" value="${dto.employeeAddr }"/><br />
입사일 : <input type="date" name="hireDate" value="${dto.hireDate }" readonly="readonly"/><br />
<input type="submit" value="내정보 수정완료" />
<input type="button" onclick="javascript:history.back()" value="뒤로가기"/>
</form>
</body>
</html>