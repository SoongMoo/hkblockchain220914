package hkShoppungMall.command;

import lombok.Data;

@Data
public class PurchaseCommand {
	String recieveName;
	String purchaseAddr;
	String purchasePhone;
	String message;
	String goodsNums;
	Long goodsTotalPrice;
	Long goodsTotalDelivery;
	Long totalPrice;
}
