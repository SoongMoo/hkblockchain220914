<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<SCRIPT>
	function goodsDetail(goodsNum){
		window.open(
				"goodsDetail.goods?goodsNum=${dto.goodsNum}"
				,"상품정보","width=300,height=700,left=100,top=100");
	}
</SCRIPT>

</head>
<body>
<form action="inquireRepleUpdate.inq">
<input type="hidden" name="inquireNum" value="${dto.inquireNum }" />
<table>
<tr><td>문의 번호</td><td>${dto.inquireNum }</td></tr>
<tr><td>질문자</td><td>${dto.memberNum }</td></tr>
<tr><td><a href="javascript:goodsDetail('${dto.goodsNum }');">제품번호</a></td><td>${dto.goodsNum }</td></tr>
<tr><td>문의 제목</td><td>${dto.inquireSubject }</td></tr>
<tr><td>문의 내용</td><td>${dto.inquireContent }</td></tr>
<tr><td>답변한 사람</td>
	<td>${dto.employeeNum }</td></tr>
<tr><td>문의 답변</td>
	<td><input type="text" name="answerReply" value="${dto.answerReply }"/></td></tr>
<tr><td>문의 답변일</td>
	<td>${dto.answerDate }</td></tr>
<tr><td colspan="2"><input type="submit" value="답변달기" /></td></tr>
</table>
</form>
</body>
</html>