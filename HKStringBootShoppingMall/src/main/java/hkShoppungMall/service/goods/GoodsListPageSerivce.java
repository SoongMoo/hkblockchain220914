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
		List<GoodsDTO> list = goodsMapper.goodsList(new StartEndPageDTO());
		model.addAttribute("list", list);
	}
}
