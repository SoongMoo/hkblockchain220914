<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상세보기</h2>
<form action="boardModify.board" name="frm" method="get">
<input type="hidden" name="boardNum" value="${dto.boardNum }"/>
<table border=1>
	<tr><td>방문자수</td><td>${dto.visitCount }</td>
	    <td>등록한 사용자의 ip주소</td><td>${dto.writerIp }</td></tr>
	<tr><td>글번호</td><td colspan=3>${dto.boardNum }</td></tr>
	<tr><td>글쓴이</td>
	    <td colspan=3>
	    <input type=text name="boardWriter" value="${dto.boardWriter }" />
	    </td></tr>
	<tr><td>제목</td>
	    <td colspan=3>
	    <input type="text" name="boardSubject" value="${dto.boardSubject }"/>
	    </td></tr>
	<tr><td>내용</td>
		<td colspan=3>
		<textarea rows="6" cols="30" name="boardContent">${dto.boardContent }</textarea>
		</td></tr>
	<tr><td>등록일</td><td colspan=3>${dto.boardDate }</td></tr>
	<tr><th colspan=4>
	<input type="submit" value="수정완료" />
	<input type="button" value="뒤로가기" onclcik="javascript:history.back();" />			
	</th></tr>
</table>
</form>
</body>
</html>