package hkShoppungMall.domain;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("paymentPurchaseGoodsDTO")
public class PaymentPurchaseGoodsDTO {
	
	PurchaseDTO purchaseDTO; // 1
	PaymentDTO paymentDTO; // 1
	DeliveryDTO deliveryDTO; // 1
	
	List<GoodsDTO> goodsDTOs; // n
}
