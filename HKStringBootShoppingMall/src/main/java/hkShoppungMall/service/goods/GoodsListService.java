package hkShoppungMall.service.goods;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.GoodsDTO;
import hkShoppungMall.mapper.GoodsMapper;

@Service
public class GoodsListService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(Model model, String goodsWord) {
		List<GoodsDTO> list = goodsMapper.goodsList(goodsWord);
		model.addAttribute("list", list);
	}
}
