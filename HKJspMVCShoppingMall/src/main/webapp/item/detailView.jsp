<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.min.js"></script>
<script>
	$(function(){
		$("#cartBtn").click(function(){
			if(${dto != null}){
				$.ajax({
					type : "post",
					url : "cart.item",
					dataType : "html",
					data : {"goodsNum":"${goodsDTO.goodsNum}","qty":$("#qty").val()},
					success : function(){
						con = confirm("장바구니로 이동하시겠습니까?")
						if(con){
							location.href="cartList.item";
						}
					},
					error : function(){
						alert('서버연결이 되지않았습니다');
						return
					}
				});
			}else{
				window.open("loginCk.login","loginck","width=400,height=400")
			}
			
		});
	});
</script>
</head>
<body>
<table width="600" border=1>
	<tr><td rowspan=5 width="300"><img width="300px" src="goods/images/${goodsDTO.goodsImage.split('`')[0] }"></td><td>${goodsDTO.goodsName }</td></tr>
	<tr><td>${goodsDTO.goodsPrice }</td></tr>
	<tr><td>${goodsDTO.company }</td></tr>
	<tr><td>수량 : <input type="number" min="1" step="1" value="1" id="qty"/></td></tr>
	<tr><td align="center"><button type="button" id="cartBtn">장바구니</button>
						   <button type="button" id="butBtn">구매하기</button></td></tr>
	<tr><td colspan=2>${goodsDTO.goodsContent }<br/>
		<c:forTokens items="${goodsDTO.goodsImage }" delims="`" var="image" begin="1">
		<img src="goods/images/${image }"/>
		</c:forTokens>
		</td></tr>
</table>

</body>
</html>