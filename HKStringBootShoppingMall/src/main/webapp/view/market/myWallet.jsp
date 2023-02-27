<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/gh/ethereum/web3.js/dist/web3.min.js"></script>
<script type="text/javascript" src="/static/js/myWallet.js"></script>
<script type="text/javascript" src="/static/js/marketConfig.js"></script>
</head>

<body>
  <div class="containWrap">      
      <v-card class="cardG">
        <div>                 
          <p class="text-center address">
             <span class="account">${accountAddress }</span> <span class="reftxt">(Address)</span>
          </p>
          <p class="text-center balance">
             <span id="balanceVal"></span> Ether <span class="reftxt">(Balance)</span>
          </p>
        </div>
      </v-card>
      <c:if test="${empty privateKey }">
     	<hr />
		인증서 가져오기 : <input type="file" onchange="onFileSelected(event)">
		<hr />
      </c:if>
      
      <h2>Transfer</h2>
      <select id="selectedAuction"  label="Asset" onchange="getAuctionById(this)"></select>
      <div v-show="selectedAuction">
        <h3>Auction Info</h3>
        <div>Title: <span id="title"></span></div>
        <div>Price: <span id="price"></span> Ether</div>
        <div>TokenId: <span id="tokenId"></span></div>
        <div>Owner: <span id="owner"></span></div>
        <div>Metadata: <span id="metadata"></span></div>
      </div>
      To Address<br />
       <hr />
		인증서 가져오기 : <input type="file" onchange="onFileSelected1(event)">
	   <hr />
      <input type="text"  size="200" id = "toAddress" required="required"/><br />

      <button type="button" onclick="finalizeAuction()" >Finalize</button>
  </div>
</body>
</html>