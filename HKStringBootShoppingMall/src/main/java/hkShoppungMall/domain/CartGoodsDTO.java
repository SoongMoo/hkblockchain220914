package hkShoppungMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("cartGoodsDTO")
public class CartGoodsDTO {
	int totalPrice;
	
	CartDTO cartDTO;
	GoodsDTO goodsDTO;
}
