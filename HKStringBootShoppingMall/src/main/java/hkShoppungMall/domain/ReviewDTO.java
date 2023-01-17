package hkShoppungMall.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Data
@Alias("reviewDTO")
public class ReviewDTO {
	Long reviewNum;
	String goodsNum;
	Date reviewDate;
	String reviewContent;
	String purchaseNum;
	
	
	String memberId; 

}
