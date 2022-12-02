<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="inquireWritePro.inq" id="frmMain">
<input type="hidden" name="goodsNum" value="${dto.goodsNum }"/>
<h1 class="fl"> 판매자에게 문의하기 </h1>
<p>상품명 : ${dto.goodsName }</p>
<table >
<tr >
	<th>제목</th>
	<td><input type="text" name="inquireSubject"  /></td>
<tr >
	<th>내용</th>
	<td>
		<textarea cols="50" rows="10" name="inquireContent"></textarea>
	</td>
</tr>
<tr>
	<th>문의유형</th>
	<td class="type">
	<input type="radio" id="hchkQueryType1"	name="hchkQueryType" value="상품"/>상품(성능/사이즈) 
	<input type="radio" id="hchkQueryType2" name="hchkQueryType" value="배송"/>배송
	<input type="radio" id="hchkQueryType3" name="hchkQueryType" value="교환"/>교환
	<input type="radio" id="hchkQueryType4" name="hchkQueryType" value="반품/취소/환불"/>반품/취소/환불 
	<input type="radio" id="hchkQueryType5" name="hchkQueryType" value="기타"/>기타
	</td>
</tr><tr>
<th colspan=2>
	<input type="submit"  id="btnInsert" value="문의하기" />
	<input type="button" value="취소" onclick="javascript:self.close();"/>
</th>
</tr>


</tr>
</table>
</form>
</body>
</html>