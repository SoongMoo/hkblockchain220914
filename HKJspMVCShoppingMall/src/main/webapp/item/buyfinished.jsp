<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>buyfinished.jsp</title>
</head>
<body>
${memberId }님  ${totalPrice }원이 결제완료되었습니다.
<a href="purchaseList.item" >구매리스트</a>
<a href="<c:url value='/' />">홈으로</a>
</body>
</html>