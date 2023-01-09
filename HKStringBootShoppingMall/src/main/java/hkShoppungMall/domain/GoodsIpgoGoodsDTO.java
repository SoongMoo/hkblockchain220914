package hkShoppungMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias(value = "goodsIpgoGoodsDTO")
public class GoodsIpgoGoodsDTO {
	GoodsDTO goodsDTO; // 1
	GoodsIpgoDTO goodsIpgoDTO; // 1
}
