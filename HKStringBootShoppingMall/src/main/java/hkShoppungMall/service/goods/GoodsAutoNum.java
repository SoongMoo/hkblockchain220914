package hkShoppungMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.command.GoodsCommand;
import hkShoppungMall.mapper.GoodsMapper;


@Service
public class GoodsAutoNum {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(GoodsCommand goodsCommand ) {
		String autoNum = goodsMapper.goodsAutoNum();
		goodsCommand.setGoodsNum(autoNum);
		//model.addAttribute("goodsCommand", goodsCommand);
	}
	
}
