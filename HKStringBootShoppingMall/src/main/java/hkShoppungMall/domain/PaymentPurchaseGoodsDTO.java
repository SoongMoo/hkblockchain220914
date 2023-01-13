package hkShoppungMall.domain;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("paymentPurchaseGoodsDTO")
public class PaymentPurchaseGoodsDTO {
	PaymentDTO paymentDTO; // 1
	PurchaseDTO purchaseDTO; // 1
	
	List<GoodsDTO> goodsDTOs; // n
}
