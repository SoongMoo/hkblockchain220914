package hkShoppungMall.service.goodsIpgo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.GoodsIpgoDTO;
import hkShoppungMall.domain.StartEndPageDTO;
import hkShoppungMall.mapper.GoodsIpgoMapper;
import hkShoppungMall.service.StartEndPageService;

@Service
public class GoodsIpgoListService {
	@Autowired
	GoodsIpgoMapper goodsIpgoMapper;
	public void execute(Model model,Integer page) {
		int limit = 2; 
		int limitPage = 2;
		Long startRow = ((long)page - 1 ) * limit + 1 ;
		Long endRow = startRow + limit -1;		
		
		StartEndPageDTO dto = new StartEndPageDTO();
		dto.setStartRow(startRow);
		dto.setEndRow(endRow);
		
		int count = goodsIpgoMapper.goodsIpgoCount();
		
		List<GoodsIpgoDTO> list = goodsIpgoMapper.ipgoSelect(dto);
		StartEndPageService seps = new StartEndPageService();
		seps.execute(model, count, limit, page, limitPage, null, list);	
	}
}
