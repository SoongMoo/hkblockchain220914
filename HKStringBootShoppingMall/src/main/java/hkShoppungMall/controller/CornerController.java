package hkShoppungMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hkShoppungMall.service.goods.GoodsDetailService;

@Controller
@RequestMapping("corner")
public class CornerController {
	@Autowired
	GoodsDetailService goodsDetailService;
	@RequestMapping("prodInfo")
	public String prodInfo(
			@RequestParam(value = "goodsNum") String goodsNum,
			Model model) {
		goodsDetailService.execute(model, goodsNum);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/corner/prodInfo";
	}
}
