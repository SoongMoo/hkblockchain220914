package hkShoppungMall.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;


@Data
@Alias("paymentDTO")
public class PaymentDTO {
	String purchaseNum;
	String paymentKind;
	String paymentPrice;
	String paymentDate;
	String confirmNumber;
	String cardNumber;
}