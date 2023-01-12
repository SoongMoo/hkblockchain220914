package hkShoppungMall.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.GoodsDTO;
import hkShoppungMall.domain.StartEndPageDTO;
import hkShoppungMall.mapper.GoodsMapper;
import hkShoppungMall.service.StartEndPageService;

@Service
public class GoodsListService {
	@Autowired
	GoodsMapper goodsMapper; // 2
	public void execute(Model model, String goodsWord, int page,String sort,String column) {
		int limit = 2; // 한페이지에 보여줄 item의 갯수
		int limitPage = 10 ; // 1~10페이지, 11~20페이지,...
		Long startRow = ((long)page - 1) * limit + 1;
		Long endRow = startRow + limit -1;

		StartEndPageDTO dto = new StartEndPageDTO();
		dto.setStartRow(startRow);
		dto.setEndRow(endRow);
		dto.setGoodsWord(goodsWord);
		dto.setCol(column);
		dto.setSort(sort);
		
		if(sort.equals("desc")) sort = "asc";
		else sort = "desc";
		
		model.addAttribute("column", column);
		model.addAttribute("sort", sort);
		
		
		int count = goodsMapper.count(goodsWord);// 
		List<GoodsDTO> list = goodsMapper.goodsList(dto);
		
		StartEndPageService seps = new StartEndPageService();
		seps.execute(model, count, limit, page, limitPage, goodsWord, list);		
	}
}
