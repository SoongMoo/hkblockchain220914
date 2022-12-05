<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.min.js"></script>
<script>
	function buyItem(){
		location.href="buyItem.item?goodsNum=${goodsDTO.goodsNum}&qty="+$("#qty").val();
	}
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
		$("#wish").click(function(){
			$.ajax({
				type:"post",
				url:"wishItem.item",
				dataType:"text",
				data:{"goodsNum":"${goodsDTO.goodsNum}"},
				success:function(){
					if($("#wish").attr("src")== "images/img1.jpg" ){
						$("#wish").attr("src","images/img2.jpg");
						alert("관심상품등록이 등록 되었습니다.");
					}else{
						$("#wish").attr("src","images/img1.jpg");
						alert("관심상품등록이 취소 되었습니다.");
					}
				},
				error:function(){
					alert('로그인 아웃 되었습니다.\n다시 로그인 해 주세요.');
					location.href='<c:url value="/"/>';
					return false;
				}
			});
		});
		/*
		$("#inquire").click(function(){
			$.ajax({
				type : "POST",
				url : "inquireList.inq",
				dataType : "html",
				data : {"goodsNum":"${goodsDTO.goodsNum}"},
				success : function(result){
					$("#notice").html(result);
				},
				error : function(){
					alert('에러가 나왔다 홀홀홀~');
					return;
				}
			});
		});
		*/
	
		
		review();
	});
	function inquire(){
		//location.href="inquireList.inq?goodsNum=${goodsDTO.goodsNum}"
		$.ajax({
			type : "POST",
			url : "inquireList.inq",
			dataType : "html",
			data : {"goodsNum":"${goodsDTO.goodsNum}"},
			success : function(result){
				$("#notice").html(result);
			},
			error : function(){
				alert('에러가 나왔다 홀홀홀~');
				return;
			}
		});
	}
	function review(){
		$.ajax({
			type : "POST",
			url : "reviewList.review",
			dataType : "html",
			data:{"goodsNum":"${goodsDTO.goodsNum}"},
			success : function(result){
				$("#notice").html(result);
			},
			error : function(){
				alert('에러가 나왔다 홀홀홀~');
				return;
			}
		});
	}
</script>
</head>
<body>
<table width="600" border=1>
	<tr><td rowspan=5 width="300"><img width="300px" src="goods/images/${goodsDTO.goodsImage.split('`')[0] }"></td>
		<td>${goodsDTO.goodsName }
			<c:if test="${empty isTrue }">
			<img src="images/img1.jpg" width ="30" id="wish"/>
			</c:if>
			<c:if test="${!empty isTrue }">
			<img src="images/img2.jpg" width ="30" id="wish"/>
			</c:if>
		</td>
	</tr>
	<tr><td>${goodsDTO.goodsPrice }</td></tr>
	<tr><td>${goodsDTO.company }</td></tr>
	<tr><td>수량 : <input type="number" min="1" step="1" value="1" id="qty"/></td></tr>
	<tr><td align="center"><button type="button" id="cartBtn">장바구니</button>
						   <button type="button" id="butBtn" onclick="buyItem()">구매하기</button></td></tr>
	<tr><td colspan=2>${goodsDTO.goodsContent }<br/>
		<c:forTokens items="${goodsDTO.goodsImage }" delims="`" var="image" begin="1">
		<img src="goods/images/${image }"/>
		</c:forTokens>
		</td></tr>
</table>
<span id="review" onclick="review();">리뷰</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<span id="inquire" onclick="inquire();">상품문의</span><br />
<span id="notice" ></span>
</body>
</html>