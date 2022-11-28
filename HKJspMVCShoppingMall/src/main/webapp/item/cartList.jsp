<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(function(){
	$("#checkBoxs").click(function(){
		if($("#checkBoxs").prop("checked")){
			$("input[name=prodCk]").prop("checked",true);
		}else{
			$("input[name=prodCk]").prop("checked",false);
		}
	});
});
function goodsCartAdd(goodsNum){
	$.ajax({
		url:"cart.item",
		type:"post",
		dataType:"text",
		data:{"goodsNum":goodsNum,"qty":1 },
		success: function(){
			location.href="cartList.item";
		} , 
		error: function(){
			alert("서버에 접속하지 못했습니다. 다시 시도해주세요.");
			return;
		}
	});
}
function cartItemDel(goodsNum){
	con = confirm ("정말 삭제하시겠나?"); // 예 : true/ 아니오 : false
	if(con){
	 	location.href="cartItemDel.item?goodsNum="+goodsNum;
	}
}
function checkQty(goodsNum, qty){
	if(qty > 1){
		location.href="cartQtyDown.item?goodsNum="+goodsNum;
	}else{
		alert("최소수량은 1이상이어야 합나다.");
		return false;
	}
} 
</script>
</head>
<body>
<form action="itemBuy.item" method="get" onsubmit="return goodsCheck();">
<table width="600" align = "center">
<tr><td><input type="checkbox" id="checkBoxs" checked="checked" /></td>
	<td>이미지</td><td>제품이름</td><td>수량</td><td>합계금액</td>
	<td><input type="button" value="선택상품삭제" onclick="" /></td>
</tr>
<c:forEach items="${list }" var="dto">
<tr>
	<td><input type="checkbox" id="itemCk" checked="checked" name="prodCk" /></td>
	<td><img width="30" src="goods/images/${dto.goodsImage.split('`')[0] }" /></td><td>${dto.goodsName }</td>	
	<td>
		<a href="javascript:goodsCartAdd('${dto.goodsNum }');">+</a> 
		<span id="${dto.goodsNum }">${dto.cartQty }</span> 
		<a href="javascript:checkQty('${dto.goodsNum }','${dto.cartQty }');">-</a>
	</td>
	<td><span id="total_${dto.goodsNum }">${dto.totalPrice }</span></td>
	<td><input type="button" value="삭제" onclick="javascript:cartItemDel('${dto.goodsNum }');" /></td>
</tr>
</c:forEach>
<tr><td colspan="6" align="center">
		<input type="submit" value="구매하기"/>
	</td></tr>
</table>
</form>
</body>
</html>