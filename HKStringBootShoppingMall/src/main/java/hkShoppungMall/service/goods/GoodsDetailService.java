package hkShoppungMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.GoodsDTO;
import hkShoppungMall.mapper.GoodsMapper;

@Service
public class GoodsDetailService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(Model model, String goodsNum) {
		goodsMapper.goodsVisitCnt(goodsNum);
		GoodsDTO dto = goodsMapper.goodsSelectOne(goodsNum);
		model.addAttribute("goodsCommand", dto);
	}
}
