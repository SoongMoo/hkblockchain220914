package hkShoppungMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("deliveryDTO")
public class DeliveryDTO {
	String purchaseNum;
	String deliveryCompany;
	String deliveryNumber;
}
