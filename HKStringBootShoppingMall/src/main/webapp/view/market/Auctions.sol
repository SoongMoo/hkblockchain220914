pragma solidity ^0.4.18;

import "./MyNFT.sol";

contract Auctions {
	// 상태 변수
	Auction[] public auctions; //Auction을 저장하는 전체 배열
 	mapping(address => uint[]) public auctionOwner; // 각 소유자 어드래스를 가지고 있는 tokenId릐 배열을 매핑

	struct Auction {  // 옥션의 구조체
	  string name; // 제목
	  uint256 price; // 가격
	  string metadata; // 메타데이터 : ipfs hash
	  uint256 tokenId; // 토큰 아이디
	  address repoAddress; // nft 컨트랙트 어드레스
	  address owner; // 소유자				
	  string v;
	  string r;
	  string s;
	}

	function() public {
	  revert();
	}
    
	// 해당 컨트랙트가 특정 NFT 소유권을 가지고 있는지 확인
	modifier contractIsNFTOwner(address _repoAddress, uint256 _tokenId) {
	  // 임토트한 MyNFT에 컨트랙트 어드래스를 넣고, ownerOf(_tokenId)함수로 해당 토큰의 소유자 어드래스를 가져온다.
	  address nftOwner = MyNFT(_repoAddress).ownerOf(_tokenId); 
	  // 어드레스가 현재 Auctions의 컨트랙트 어드래스와 일치하는지 확인하고 문제 없으면 다음 프로세스로 진행
	  require(nftOwner == address(this)); //address(this)는 이컨트랙트의 어드래스를 반환하는 함수
	  _;
	}

    // 먼저 contractIsNFTOwner함수를 이용해서 해당 토큰이 auctions 컨트랙트 어드레스의 소유인지 확인
	function createAuction(address _repoAddress, uint256 _tokenId, string _auctionTitle, string _metadata, uint256 _price, string _v, string _r, string _s) public contractIsNFTOwner(_repoAddress, _tokenId) returns(bool) {
		uint auctionId = auctions.length;
		Auction memory newAuction;
		newAuction.name = _auctionTitle;
		newAuction.price = _price;
		newAuction.metadata = _metadata;
		newAuction.tokenId = _tokenId;
		newAuction.repoAddress = _repoAddress;
		newAuction.owner = msg.sender;
		newAuction.v = _v;
		newAuction.r = _r;
		newAuction.s = _s;

		// 새 옥션을 배열에 추가 
		auctions.push(newAuction);
		// 컨트랙트를 호출하는 어드래스를 키로 auctionOwner맵에 auctionId 를 추가
		auctionOwner[msg.sender].push(auctionId); 

		emit AuctionCreated(msg.sender, auctionId);  // AuctionCreated 이벤트 송출
		return true;
	}

    // 옥션을 소유자에게 전달하는 함수
	function finalizeAuction(uint _auctionId, address _to) public {
		// _auctionId를 가지고 옥션에 접근, memory는 휘발성으로 잠시메모리에 저장
		Auction memory myAuction = auctions[_auctionId];
		// NFT컨트랙트 어드래스(repoAddress) , tokenId, 현재 컨트랙트 어드래스address(this)와 받는 어드래스 _to를 approveAndTransfer함수에 전달 
		// 받는 어드래스에 소유권이 승인되고 잔달되는 함수, 완료되면 해당 옥션 상태를 종료로 바꾼다. 
		// AuctionFinalized 이벤트 송출
		if(approveAndTransfer(address(this) , _to, myAuction.repoAddress, myAuction.tokenId)){
			
			delete auctionOwner[auctions[_auctionId].owner];
			auctions[_auctionId].owner = _to;
			auctionOwner[_to].push(_auctionId);
		    emit AuctionFinalized(msg.sender, _auctionId);
		}
	}
	
	// internal은 컨트랙트 내에서만 호출
	function approveAndTransfer(address _from, address _to, address _repoAddress, uint256 _tokenId) internal returns(bool) {
		MyNFT remoteContract = MyNFT(_repoAddress);// MyNFT 컨트랙트에 컨트랙트 어드래스를 넣고 인스턴스를 가져온 후 
		remoteContract.approve(_to, _tokenId); // 인스턴스에 있는 approve(_to, _tokenId)를 통해 해당 토큰을 받는 어드레스(_to)를 승인하고
		remoteContract.transferFrom(_from, _to, _tokenId); // 해당 어드레스를 전송
		return true;
	}

	// constant는 읽기 전용함수, 옥션 전체의 개수를 반환
    function getCount() public constant returns(uint) {
		return auctions.length;
	}
	// 소유자의 리스트를 반환하는 함수 
	function getAuctionsOf(address _owner) public constant returns(uint[]) {
		uint[] memory ownedAuctions = auctionOwner[_owner];
		return ownedAuctions;
	}
	// _owner의 옥션 갯수를 반환하는 함수
	function getAuctionsCountOfOwner(address _owner) public constant returns(uint) {
		return auctionOwner[_owner].length;
	}
	// 특정 ID에 대한 옥션을 반환하는 함수 
	function getAuctionById(uint _auctionId) public constant returns(
		string name,
		uint256 price,
		string metadata,
		uint256 tokenId,
		address repoAddress,
		address owner,
		string v,
		string r,
		string s
		) {
		Auction memory auc = auctions[_auctionId];
		return (
			auc.name,
			auc.price,
			auc.metadata,
			auc.tokenId,
			auc.repoAddress,
			auc.owner,
			auc.v,
			auc.r,
			auc.s

		);
	}

	event AuctionCreated(address _owner, uint _auctionId);
	event AuctionFinalized(address _owner, uint _auctionId);
}