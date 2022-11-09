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
<table border=1>
	<tr><td>방문자수</td><td>${dto.visitCount }</td><td>등록한 사용자의 ip주소</td><td>${dto.writerIp }</td></tr>
	<tr><td>글번호</td><td colspan=3>${dto.boardNum }</td></tr>
	<tr><td>글쓴이</td><td colspan=3>${dto.boardWriter }</td></tr>
	<tr><td>글쓴이</td><td colspan=3>${dto.boardSubject }</td></tr>
	<tr><td>내용</td><td colspan=3>${dto.boardContent }</td></tr>
	<tr><td>등록일</td><td colspan=3>${dto.boardDate }</td></tr>
	<tr><th colspan=4>
			<a href="boardUpdate.board?num=${dto.boardNum}">수정</a> 
			| <a href="boardDel.board?num=${dto.boardNum}">삭제</a> | 게시글 리스트
	</th></tr>
</table>
</body>
</html>