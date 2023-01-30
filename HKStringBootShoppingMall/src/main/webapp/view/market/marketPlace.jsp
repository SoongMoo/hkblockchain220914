<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>    


안녕하세요.<br />
<table id="table">
	<tr>
	<c:forEach items="${list }" var="dto" varStatus="cnt">
			<td>title: ${dto.title } <br />
				price: ${dto.price } <br />
				<a href="transferForm?owner=${dto.owner }&tokenId=${dto.tokenId }" >
				<img src="https://gateway.ipfs.io/ipfs/${metaData }" with="100px"/><br />
				</a>
				tokenId:${dto.tokenId } <br />
				owner: ${dto.owner } <br />
				active: ${dto.active } <br /></td>
			<c:if test="${cnt.count % 3 == 0 }"></tr><tr></c:if>
	</c:forEach>
	</tr>
</table>  
</body>
</html>