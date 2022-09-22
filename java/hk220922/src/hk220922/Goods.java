package hk220922;

public class Goods {
	private String goodsName;
	private int goodsPrice;
	private String goodsContent;

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public void setGoodsContent(String goodsContent) {
		this.goodsContent = goodsContent;
	}
	
	public String getGoodsName() {
		return goodsName;
	}
	public String getGoodsContent() {
		return goodsContent;
	}
	public int getGoodsPrice() {
		return goodsPrice;
	}
}
