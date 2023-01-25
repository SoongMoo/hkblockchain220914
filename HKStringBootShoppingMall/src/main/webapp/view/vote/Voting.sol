pragma solidity ^0.4.23;

contract Voting{

    address voter;
    mapping (address => bool)  voters;
    mapping (address => string)  candidates;

    constructor() public{
        voter = msg.sender;
    }
    function getVoter() public constant returns(bool){
        return voters[msg.sender];
    }
    function getCandidate() public constant returns(string){
        return candidates[msg.sender];
    }
    function setVote(string name)  public  {
        if(voters[msg.sender] != true){
            voters[msg.sender] = true;
            candidates[msg.sender] = name;
        }
    }
    function setVote_cancel() public{
        voters[msg.sender] = false;
        candidates[msg.sender] = "";
    }

} 