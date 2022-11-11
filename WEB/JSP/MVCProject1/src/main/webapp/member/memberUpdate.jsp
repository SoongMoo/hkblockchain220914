<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원 수정 페이지 입니다.<br />
<form action="memberUpdate.mem" method="get" name="frm" id="frm">
<table border = 1>
<tr><td>고객 번호 </td><td> <input type="text" name="memNum" value="${memberDTO.memNum }" readonly="readonly" required="required"></td></tr>
<tr><td>고객 이름 </td><td> <input type="text" name="memName" value="${memberDTO.memName }" required="required"></td></tr>
<tr><td>고객 생년월일 </td><td> <input type="datetime-local" name="memBirth" value="${memberDTO.memBirth }T00:00" required="required"></td></tr>
<tr><td>고객 성별 </td><td> <input type="radio" name="memGender" value="F" 
                         	 	<c:if test="${memberDTO.memGender == 'F' }"> checked </c:if>  
                          />여자
                          
                          <input type="radio" name="memGender" value="M" 
                          		<c:if test="${memberDTO.memGender == 'M' }"> checked </c:if>
                          />남자</td></tr>
<tr><td>고객 가입일 </td><td> <input type="date" name="memRegiDate" value="${memberDTO.memRegiDate }" required="required"/></td></tr>
<tr><td>고객 아이디  </td><td><input type="text" name="memId" value="${memberDTO.memId }"  required="required">
<tr><td>고객 연락처1 </td><td> <input type="tel" name="memPhone1" placeholder="031-1234-1234" value="${memberDTO.memPhone1 }"></td></tr>
<tr><td>고객 연락처2 </td><td> <input type="tel" name="memPhone2" value="${memberDTO.memPhone2 }"></td></tr>
<tr><td>고객 주소 </td><td> <input type="text" name="memAddr" value="${memberDTO.memAddr }"></td></tr>
<tr><td>고객 이메일 </td><td> <input type="email" name="memEmail" value="${memberDTO.memEmail }"></td> </tr>
<tr><td colspan=2 align=center><input type="submit" value="회원 수정 완료" /></td></tr>
</table>

</form>
</body>
</html>