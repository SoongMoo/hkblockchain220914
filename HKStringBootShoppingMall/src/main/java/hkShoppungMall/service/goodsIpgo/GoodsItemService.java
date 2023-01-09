package hkShoppungMall.service.goodsIpgo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.GoodsDTO;
import hkShoppungMall.domain.StartEndPageDTO;
import hkShoppungMall.mapper.GoodsIpgoMapper;
import hkShoppungMall.mapper.GoodsMapper;
import hkShoppungMall.service.StartEndPageService;

@Service
public class GoodsItemService {
	@Autowired
	GoodsIpgoMapper goodsIpgoMapper;
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsWord, Integer page, Model model) {
		int limit = 2; // 한페이지에 보여줄 item의 갯수
		int limitPage = 10 ; // 1~10페이지, 11~20페이지,...
		Long startRow = ((long)page - 1) * limit + 1;
		Long endRow = startRow + limit -1;

		StartEndPageDTO dto = new StartEndPageDTO();
		dto.setStartRow(startRow);
		dto.setEndRow(endRow);
		dto.setGoodsWord(goodsWord);
		
		int count = goodsMapper.count(goodsWord);// 
		
		List<GoodsDTO> list = goodsIpgoMapper.selectItem(dto);
		StartEndPageService seps = new StartEndPageService();
		seps.execute(model, count, limit, page, limitPage, goodsWord, list);	
	}
}
