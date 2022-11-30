package model.DTO;

public class PurchaseDTO {
	
	int puchaseNum; // 주문번호 
	int totalPrice; //결제금액 
	String location; // 배송지
	String receivePhone; // 받는 사람 연락처
	String receiveName; // 받는 사람 이름
	String memberNum; // 주문자 

	public int getPuchaseNum() {
		return puchaseNum;
	}
	public void setPuchaseNum(int puchaseNum) {
		this.puchaseNum = puchaseNum;
	}
	
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getReceivePhone() {
		return receivePhone;
	}
	public void setReceivePhone(String receivePhone) {
		this.receivePhone = receivePhone;
	}
	public String getReceiveName() {
		return receiveName;
	}
	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}
	public String getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}
}
