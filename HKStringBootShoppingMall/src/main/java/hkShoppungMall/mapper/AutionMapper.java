package hkShoppungMall.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import hkShoppungMall.domain.AuctionDTO;

@Repository(value="hkShoppungMall.mapper.AutionMapper")
public interface AutionMapper {
	public Integer createAution(AuctionDTO dto);
	public List<AuctionDTO> auctionSelectAll();
}
