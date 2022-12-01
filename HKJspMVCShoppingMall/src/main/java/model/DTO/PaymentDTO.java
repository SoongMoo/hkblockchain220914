package model.DTO;

import java.util.Date;

public class PaymentDTO {
	int purchaseNum;
	String paymentMethod;
	Date paymentDate;
	Date conformDate;
	String paymentCompany;
	int conformNum;
	String carNum;
	
	public int getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(int purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Date getConformDate() {
		return conformDate;
	}
	public void setConformDate(Date conformDate) {
		this.conformDate = conformDate;
	}
	public String getPaymentCompany() {
		return paymentCompany;
	}
	public void setPaymentCompany(String paymentCompany) {
		this.paymentCompany = paymentCompany;
	}
	public int getConformNum() {
		return conformNum;
	}
	public void setConformNum(int conformNum) {
		this.conformNum = conformNum;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
}
