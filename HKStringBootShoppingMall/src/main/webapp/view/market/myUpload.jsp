<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/web3@0.19.0/dist/web3.js"></script>
<script type="text/javascript" src="/static/js/auctionScript.js"></script>
<script type="text/javascript" src="/static/js/marketConfig.js"></script>
</head>
<body>
<input type="hidden" id="accountAddress" value="${accountAddress }" />
<p>
Upload Page
</p>
Unique ID <br />
<span class="tokenID"></span>(tokenID)
<br />
<hr />
<input type="file" name="captureFile" id="captureFile" multiple="multiple" />
<button type="button" id="UPLOADIMG">UPLOADIMG</button><BR />
<img src="" id="uploadedImg" width="300" />
Data URI : <span id="Data_URI"></span>     <br />
<hr />
<button id="submit">Submit</button><br />
<div id="isRegistered" style="display:none">
<button id="transferToCA" style="display:none" >TransferToCA</button>
</div>
<hr />


<span class="tokenID"></span>(tokenID)


tokenID<br />
<input type="text" name="tokenID"  id="tokenID" readonly="readonly"/><br />
Auction Title<br />
<input type="text" name="auctionTitle" id="auctionTitle"/><br />
<hr />
price <br />
<input type="text" name="price" id="auctionPrice" />
<hr />
<button id="createAution">CREATE AUCTION</button>

</body>
</html> 