package hk220922;

public class Member {
	private String memberName;
	private String memberAddr;
	private int memberAge;
		
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public void setMemberAge(int memberAge) {
		this.memberAge = memberAge;
	}
	
	public String getMemberName() {
		return memberName;
	}
	public int getMemberAge() {
		return memberAge;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	
}
