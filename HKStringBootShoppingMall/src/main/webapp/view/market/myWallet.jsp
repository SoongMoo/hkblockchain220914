<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/web3@0.19.0/dist/web3.js"></script>
<script type="text/javascript" src="/static/js/myWallet.js"></script>
</head>
<body>
  <div class="containWrap">      
      <v-card class="cardG">
        <div>                 
          <p class="text-center address">
             <span class="account"></span> <span class="reftxt">(Address)</span>
          </p>
          <p class="text-center balance">
             <span id="balanceVal"></span> Ether <span class="reftxt">(Balance)</span>
          </p>
        </div>
      </v-card>
      <h2>Transfer</h2>
      <select id="selectedAuction"  label="Asset" onchange="getAuctionById(this)"></select>
      <div v-show="selectedAuction">
        <h3>Auction Info</h3>
        <div>Title: <span id="title"></span></div>
        <div>Price: <span id="price"></span> Ether</div>
        <div>TokenId: <span id="tokenId"></span></div>
        <div>Owner: <span id="owner"></span></div>
      </div>
      To Address<br />
      <input type="text"  size="200" id = "toAddress" required="required"/><br />

      <button type="button" onclick="finalizeAuction()" >Finalize</button>
  </div>
</body>
</html>