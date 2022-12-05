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
	function open1(id1){
		
		status = $('#'+id1).css('display');
		if(status == 'none'){
			$('#'+id1).css('display','');
			$('#'+id1+'1').text('답변 닫기');
		}else{
			$('#'+id1).css('display','none');
			$('#'+id1+'1').text('답변 열기');
		}
	}
	function inquireUpdate(inquireNum){
		window.open("inquireUpdate.inq?inquireNum="+inquireNum,"문의수정",
				"width=700, height=650, top=100, left=100");
	}
	function inquireDelete(inquireNum){
		$.ajax({
			type:"post",
			url:"inquireDelete.inq",
			data:{"inquireNum":inquireNum},
			dataType:"html",
			success:function(){
				inquire();
			},
			error : function(){
				alert('에러가 나왔다 홀홀홀~');
				return;
			}
		});
		
		//location.href="inquireDelete.inq?inquireNum="+inquireNum;
	}
</script>
</head>
<body>
<table width="600" align="center" border="1">
<tr><td colspan="3" align="right">
		<button type="button" id="inquire1" >문의 하기</button>
	</td>
</tr>
<tr><th width="15%">답변 상태</th><th>작성자</th><th>답변일자</th></tr>
<c:forEach items="${list }" var="dto12">
<tr>
	<td colspan = 3>제목 : ${dto12.inquireSubject}   
					<a href="javascript:open1('ingu${dto12.inquireNum }');">
						<span id="ingu${dto12.inquireNum }1">답변열기</span></a>
	</td>
</tr>
<tr>
	<c:if test="${empty dto12.answerReply }">
		<th >검토중</th>
	</c:if>
	<c:if test="${! empty dto12.answerReply }"  >
		<th width="15%">답변완료</th>
	</c:if>
	<th>${dto12.memberNum }</th>
	<th>${dto12.answerDate }
		<c:if test="${memberNum == dto12.memberNum}">
		<button type="button" onclick="inquireUpdate('${dto12.inquireNum }');">수정 하기</button>
		<button type="button" onclick="inquireDelete('${dto12.inquireNum }');">삭제 하기</button>
		</c:if>
	</th>
</tr>
<tr>
	<td colspan = 3>${dto12.inquireContent}</td>
</tr>
<tr style="display:none;" id="ingu${dto12.inquireNum }">
	<c:if test="${ empty dto12.answerReply }">
		<td colspan="3" >검토중</td>
	</c:if>
	<c:if test="${! empty dto12.answerReply }">
		<td colspan="3" >${dto12.answerReply }
	</c:if>
</tr>
</c:forEach>
</table>
</body>
</html>