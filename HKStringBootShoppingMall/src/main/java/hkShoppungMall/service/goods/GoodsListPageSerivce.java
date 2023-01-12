package hkShoppungMall.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.GoodsDTO;
import hkShoppungMall.domain.StartEndPageDTO;
import hkShoppungMall.mapper.GoodsMapper;

@Service
public class GoodsListPageSerivce {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(Model model) {
		StartEndPageDTO dto = new StartEndPageDTO();
		dto.setSort("desc");
		dto.setCol("goods_num");
		List<GoodsDTO> list = goodsMapper.goodsList(dto);
		model.addAttribute("list", list);
	}
}
