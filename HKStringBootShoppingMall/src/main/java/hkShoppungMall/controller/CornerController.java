package hkShoppungMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hkShoppungMall.service.corner.GoodsCartAddService;
import hkShoppungMall.service.corner.GoodsCartListService;
import hkShoppungMall.service.corner.GoodsCartQtyDownService;
import hkShoppungMall.service.corner.GoodsWishCheckService;
import hkShoppungMall.service.corner.GoodsWishService;
import hkShoppungMall.service.goods.GoodsDetailService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("corner")
public class CornerController {
	@Autowired
	GoodsDetailService goodsDetailService;
	@Autowired
	GoodsWishCheckService goodsWishCheckService;
	@RequestMapping("prodInfo")
	public String prodInfo(
			@RequestParam(value = "goodsNum") String goodsNum,
			Model model, HttpSession session) {
		goodsDetailService.execute(model, goodsNum);
		goodsWishCheckService.execute(goodsNum, session, model);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/corner/prodInfo";
	}
	@Autowired
	GoodsWishService goodsWishService;
	@RequestMapping(value="goodsWishAdd", method = RequestMethod.POST)
	public @ResponseBody String goodsWishAdd(
			@RequestParam(value = "goodsNum") String goodsNum,
			HttpSession session) {
		return goodsWishService.execute(goodsNum, session);
	}
	@Autowired
	GoodsCartAddService goodsCartAddService;
	@RequestMapping(value="goodsCartAdd" , method = RequestMethod.POST)
	public @ResponseBody String goodsCartAdd(
			@RequestParam(value = "goodsNum") String goodsNum,
			@RequestParam(value = "goodsQty") Integer goodsQty,
			HttpSession session){
		return goodsCartAddService.execute(goodsNum, goodsQty, session);
	}
	@Autowired
	GoodsCartListService goodsCartListService;
	@RequestMapping("goodsCartList")
	public String goodsCartList(Model model, HttpSession session) {
		return goodsCartListService.execute(model, session);
	}
	@Autowired
	GoodsCartQtyDownService goodsCartQtyDownService;
	@RequestMapping("goodsCartQtyDown")
	public String goodsCartQtyDown(
			@RequestParam(value = "goodsNum") String goodsNum,
			HttpSession session
			) {
		goodsCartQtyDownService.execute(goodsNum, session);
		return "redirect:goodsCartList";
	}
}










