package model.DTO;

import java.util.Date;

public class DeliveryDTO {
	Long deliveryNum;
	Long purchaseNum;
	Date deliveryDate;
	String deliveryState;
	public Long getDeliveryNum() {
		return deliveryNum;
	}
	public void setDeliveryNum(Long deliveryNum) {
		this.deliveryNum = deliveryNum;
	}
	public Long getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(Long purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getDeliveryState() {
		return deliveryState;
	}
	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

}
