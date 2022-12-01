package model.DTO;

public class BuyListDTO {
	Long purchaseNum;
	Long totalPrice; 
	String memberNum; 
	Long conformNum;
	Long deliveryNum;
	public Long getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(Long purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}
	public Long getConformNum() {
		return conformNum;
	}
	public void setConformNum(Long conformNum) {
		this.conformNum = conformNum;
	}
	public Long getDeliveryNum() {
		return deliveryNum;
	}
	public void setDeliveryNum(Long deliveryNum) {
		this.deliveryNum = deliveryNum;
	}
	
	
	
}
