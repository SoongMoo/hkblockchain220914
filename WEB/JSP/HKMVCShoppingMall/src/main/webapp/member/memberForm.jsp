<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
회원등록 페이지입니다.<br />
<form action="memberRegist.mem"  method="get">
회원번호 : <input type="text" name="memberNum" />자동부여<br />
회원아이디 : <input type="text" name="memberId" /><br />
회원비밀번호 : <input type="password" name="memberPw" /><br />
회원비밀번호확인 : <input type="password" name="memberPwCon" /><br />
회원명 : <input type="text" name="memberName" /><br />
회원연락처 : <input type="tel" name="memberPhone" /><br />
회원 주소 : <input type="text" name="memberAddr" /><br />
회원성별 : <input type="radio" name="memberGender" value="F"/>여자
		<input type="radio" name="memberGender" value="M"/>남자<br />
회원생년월일 : <input type="date" name="memberBirth" /><br />
회원이메일 : <input type="email" name="memberEmail" /><br />
<input type="submit" value="회원등록" />
<input type="button" value="목록으로" 
	onclick="javascript:location.href='memberList.mem'"/>
</form>
</body>
</html>