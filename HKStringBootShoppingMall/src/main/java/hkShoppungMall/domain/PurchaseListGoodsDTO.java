package hkShoppungMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("purchaseListGoodsDTO")
public class PurchaseListGoodsDTO {
	PurchaseListDTO purchaseListDTO; // 1
	GoodsDTO goodsDTO;  // 1
}
