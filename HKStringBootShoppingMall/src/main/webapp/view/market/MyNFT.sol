pragma solidity ^0.4.24;

import "github/district0x/memefactory-contracts/contracts/token/ERC721Token.sol";

contract MyNFT is ERC721Token { // ERC721Token을 상속
    constructor (string _name, string _symbol) public
        ERC721Token(_name, _symbol) {} // 생성자로서 토큰의 이름과 심볼을 지정

    function registerUniqueToken(
        address _to,   // 소유권의 어드레스 
        uint256 _tokenId, // 토큰의 유니크한 아이디
        string  _tokenURI // 세부 메타데이터가 포함되어 있는 URI
    ) public
    {
        super._mint(_to, _tokenId);  // 새 토큰을 생성하는 함수, 소유할 계정과 토큰의 아이디를 넘겨준다,
        super._setTokenURI(_tokenId, _tokenURI); // 세부메타데이터를 해당 tokenId와 함께 넘기는 함수
        emit TokenRegistered(_to, _tokenId); // 아래에 있는 토큰이벤트 등록시 같이 실행
    }

   event TokenRegistered(address _by, uint256 _tokenId); // 토큰 등록에 대한 이벤트를 정의
}
