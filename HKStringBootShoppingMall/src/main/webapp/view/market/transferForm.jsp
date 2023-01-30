<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>transferForm.jsp</title>
<script type="text/javascript" src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/web3@0.19.0/dist/web3.js"></script>
<script type="text/javascript" src="/static/js/transFrom.js"></script>
</head>
<body>
<input type="hidden" id="ownerAddress" value="${ownerAddress }"/>
<input type="hidden" id="tokenId" name="tokenId" value="${tokenId }"/>
안녕하세요<br />
 <div >
        <h3>Auction Info</h3>
        <div>Title: <span id="title"></span></div>
        <div>Price: <span id="price"></span> Ether</div>
        <div>TokenId: <span id="tokenId"></span></div>
        <div>Owner: <span id="owner"></span></div>
 </div>
 To Address<br />
 <input type="text"  size="200" id = "toAddress" required="required"/><br />
 <button type="button" onclick="finalizeAuction()" >Finalize</button>
</body>
</html>