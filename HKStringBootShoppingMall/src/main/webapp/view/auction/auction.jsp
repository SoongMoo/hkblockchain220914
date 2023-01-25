<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script
	src=https://cdn.jsdelivr.net/gh/ethereum/web3.js@3.0.0/dist/web3.min.js></script>
<script src="/static/js/auction.js" type="text/javascript"></script>

</head>
<body >
	<div class="col-lg-12">
		<div class="page-header">
			<h3>Car Auction Dapp</h3>
		</div>
		<div class="col-lg-6">
			<div class="well">
				<div>
					<legend class="lead">Car Details</legend>
					<label class="lead"> Brand: </label>
					<text id='car_brand'></text>
					<br> <label class="lead">Registration Number: </label>
					<text id='registration_number'></text>
				</div>
				<legend class="lead">Bid value</legend>
				<small>eg. 100</small>
				<div class="form-group">
					<input class="form-control" type="text" id="value" value="10"></input>
					<text id="valueValidation"></text>
				</div>

				<div>
					<button class="btn btn-default" id="transfer" type="button"
						onClick="bid()">Bid!</button>
					<br>
					<text id="biding_status"></text>
				</div>
			</div>
		</div>
		<div class="col-lg-6">
			<div class="well">
				<div>
					<legend class="lead">Auction Details</legend>
				</div>
				<div>
					<input type="text" id="my_account" value="${my_account}">
				</div>
				<div>
					<ul id='transfers'>
						<li><label class="lead">Auction End: </label> <text
								id="auction_end"></text></li>
						<li><label class="lead">Auction Highest Bid: </label> <text
								id="HighestBid"></text></li>
						<li><label class="lead">My Bid: </label> <text id="MyBid"></text></li>
						<li><label class="lead">Auction Highest Bider: </label> <text
								id="HighestBidder"></text></li>
						<li><label class="lead">Auction Status: </label> <text
								id="STATE"></text></li>
					</ul>
				</div>
				<br>
				<div>
					<legend class="lead">Events Logs </legend>

					<text id="eventslog"></text>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-6" id="auction_owner_operations">
		<div class="well">
			<div>
				<legend class="lead">Auction Operations</legend>
				<button class="btn btn-default" id="transfer" type="button"
					onClick="cancel_auction()">Cancel auction!</button>
				<button class="btn btn-default" id="transfer" type="button"
					onClick="Destruct_auction()">Destruct auction!</button>
			</div>
		</div>
	</div>
</body>
</html>