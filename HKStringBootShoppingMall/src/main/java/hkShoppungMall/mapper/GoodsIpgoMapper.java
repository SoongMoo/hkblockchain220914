package hkShoppungMall.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import hkShoppungMall.command.GoodsIpgoCommand;
import hkShoppungMall.domain.GoodsDTO;
import hkShoppungMall.domain.GoodsIpgoDTO;
import hkShoppungMall.domain.GoodsIpgoGoodsDTO;
import hkShoppungMall.domain.StartEndPageDTO;

@Repository("hkShoppungMall.mapper.GoodsIpgoMapper")
public interface GoodsIpgoMapper {
	public List<GoodsDTO> selectItem(StartEndPageDTO dto);
	public Integer ipgoInsert(GoodsIpgoDTO dto);
	public List<GoodsIpgoDTO> ipgoSelect(StartEndPageDTO dto);
	public Integer goodsIpgoCount();
	public GoodsIpgoGoodsDTO ipgoDetail(GoodsIpgoDTO idto);
	public Integer goodsIpgoUpdate(GoodsIpgoDTO dto);
	public Integer goodsIpgoDelete(GoodsIpgoCommand goodsIpgoCommand);
	public Integer goodsIpgoDels(List<String[]> condition);
}
