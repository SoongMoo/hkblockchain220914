package hkShoppungMall.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("purchaseDTO")
public class PurchaseDTO {
	String purchaseNum;
	Date purchaseDate;
	Long totalPrice;
	String deliveryAddr;
	String deliveryPhone;
	String message;
	String purchaseStatus;  // 결제대기중 , 결제완료, 배송중, 배송완료, 구매확정
	String memberNum;
	String recieveName;
}
