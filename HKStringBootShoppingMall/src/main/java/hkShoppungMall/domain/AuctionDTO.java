package hkShoppungMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("auctionDTO")
public class AuctionDTO {
	String title;
	long price;
	String metaData;
	String tokenId;
	String owner;
	String active;
	String finalized;
}
