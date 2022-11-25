<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
내 정보 수정<br />
<form action="userUpdate.nhn" method="get" name="frm">
회원아이디 : <input type="text" name="memberId" readonly="readonly" 
			value="${memVO.memberId }"/><br />
회원이름 : <input type="text" name="memberName" readonly="readonly" 
			value="${memVO.memberName }"/><br />
연락처 : <input type="tel" name="memberPhone" value="${memVO.memberPhone }"/><br />
주소 : <input type="text" name="memberAddr" value="${memVO.memberAddr }"/><br />
성별 : <c:if test="${memVO.memberGender == 'F'}">여자</c:if>
	  <c:if test="${memVO.memberGender == 'M'}">남자</c:if>
생년월일 : <input type="date" name="memberBirth" readonly="readonly" 
			value="${memVO.memberBirth }"/><br />
이메일 : <input type="text" name="memberEmail" value="${memVO.memberEmail }"/><br />
<input type="submit" value="내 정보 수정 완료" />
<input type="button" value="뒤로가기" 
	onclick="javascript:history.back();" />
</form>
</body>
</html>