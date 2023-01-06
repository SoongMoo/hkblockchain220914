package hkShoppungMall.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import hkShoppungMall.domain.GoodsDTO;
import hkShoppungMall.domain.StartEndPageDTO;

@Repository(value = "hkShoppungMall.mapper.GoodsMapper")
public interface GoodsMapper {
	public String goodsAutoNum();
	public Integer goodsInsert(GoodsDTO dto);
	public List<GoodsDTO> goodsList(StartEndPageDTO dto);
	public GoodsDTO goodsSelectOne(String goodsNum);
	public Integer goodsVisitCnt(String goodsNum);
	public Integer goodsUpdate(GoodsDTO dto);
	public Integer goodsDelete(String goodsNum);
	public Integer count(String goodsWord);
}
