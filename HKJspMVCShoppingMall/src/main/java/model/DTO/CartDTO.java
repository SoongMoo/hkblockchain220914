package model.DTO;

import java.util.Date;

public class CartDTO {
	String memberNum;
	   String goodsNum;
	   int cartQty;
	   Date cartDate;
	   
	   public String getMemberNum() {
	      return memberNum;
	   }
	   public void setMemberNum(String memberNum) {
	      this.memberNum = memberNum;
	   }
	   public String getGoodsNum() {
	      return goodsNum;
	   }
	   public void setGoodsNum(String goodsNum) {
	      this.goodsNum = goodsNum;
	   }
	   public int getCartQty() {
	      return cartQty;
	   }
	   public void setCartQty(int cartQty) {
	      this.cartQty = cartQty;
	   }
	   public Date getCartDate() {
	      return cartDate;
	   }
	   public void setCartDate(Date cartDate) {
	      this.cartDate = cartDate;
	   }

}
