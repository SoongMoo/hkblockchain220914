package model.DTO;

public class PurchaseListDTO {
	int purchaseNum;
	String goodsNum;
	int purchaseQty;
	public int getPurchaseNum() {
		return purchaseNum;
	}
	public void setPurchaseNum(int purchaseNum) {
		this.purchaseNum = purchaseNum;
	}
	public String getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}
	public int getPurchaseQty() {
		return purchaseQty;
	}
	public void setPurchaseQty(int purchaseQty) {
		this.purchaseQty = purchaseQty;
	}
}
