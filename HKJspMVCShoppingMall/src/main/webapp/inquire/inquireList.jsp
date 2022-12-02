<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script>
	$(function(){
		$("#inquire1").click(function(){
			window.open("inquireWrite.inq?goodsNum=${goodsNum}","문의하기",
					"width=700, height=650, top=100, left=100");
		});
	});
</script>
</head>
<body>
<table width="600" align="center" border="1">
<tr><td colspan="3" align="right">
		<button type="button" id="inquire1" >문의 하기</button>
	</td>
</tr>
<tr><th width="15%">답변 상태</th><th>작성자</th><th>작성일자</th></tr>
<c:forEach items="${list }" var="dto">
<tr>
	<td colspan = 3>제목 : ${dto.inquireSubject}   답변열기 </td>
</tr>
<tr>
	<td colspan = 3>${dto.inquireContent}</td>
</tr>
<tr>
	<c:if test="${empty dto.answerReply }">
		<th  colspan="3">검토중</th>
	</c:if>
	<c:if test="${! empty dto.answerReply }">
		<th width="15%">답변완료</th>
		<th>${dto.employeeNum }</th>
		<th>${dto.answerDate }</th>
	</c:if>
</tr>
</c:forEach>
</table>
</body>
</html>