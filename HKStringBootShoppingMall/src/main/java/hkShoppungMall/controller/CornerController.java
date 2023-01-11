package hkShoppungMall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("corner")
public class CornerController {
	@RequestMapping("prodInfo")
	public String prodInfo(
			@RequestParam(value = "goodsNum") String goodsNum,
			Model model) {
		return "thymeleaf/corner/prodInfo";
	}
}
