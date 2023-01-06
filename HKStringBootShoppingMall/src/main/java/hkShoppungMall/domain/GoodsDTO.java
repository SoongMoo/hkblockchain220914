package hkShoppungMall.domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias(value="goodsDTO")
public class GoodsDTO {
	String goodsNum;
	String goodsName;
	Integer goodsPrice;
	String goodsContent;
	Integer deliveryCost;
	Integer visitCount;
	String empNum;
	Timestamp goodsRegidate;
	Timestamp empUptDate;
	String empUptNum;
	
	byte[] imageCn;
	String imageDataUrl;
	
	String goodsImages; //content 이미지에 대한 storeFileName 
	String goodsOriginal; // content 이미지에 대한 originalFileName 
	
	String goodsMain;  // 대문이미지에 대한 storeFileName 
	String goodsMainOrg; // 대문이미지에 대한 originalFileName 
}
