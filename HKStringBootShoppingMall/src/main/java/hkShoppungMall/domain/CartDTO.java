package hkShoppungMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("cartDTO")
public class CartDTO {
	String goodsNum;
	String memberNum;
	Long cartQty;
	Long totalPrice;
	String [] goodsNums;
}
