<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
상품정보 정보 <br />
<br /><br /><br /><br /><br />
리뷰등록<br />
<form action="reviewWrite.review" >
<input type="hidden" name="goodsNum" value=${goodsNum } /><br />
후기 제목 : <input type="text" name="reviewSubject" /><br />
후기 내용 : <textarea rows="5" cols="50" name="reviewContent"></textarea>
<br />
<input type="submit" value="후기 등록" />
</form>






</body>
</html>