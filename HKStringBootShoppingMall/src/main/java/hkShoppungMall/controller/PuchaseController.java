package hkShoppungMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hkShoppungMall.command.PurchaseCommand;
import hkShoppungMall.service.puchase.GoodsBuyService;
import hkShoppungMall.service.puchase.GoodsOrderService;
import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("puchase")
public class PuchaseController {
	@Autowired
	GoodsBuyService goodsBuyService;
	@RequestMapping(value="goodsBuy", method=RequestMethod.POST)
	public String goodsBuy(
			@RequestParam(value="prodCk") String [] prodCk,
			HttpSession session, Model model) {
		goodsBuyService.execute(prodCk, session, model);
		return "thymeleaf/puchase/goodsOrder";
	}
	@Autowired
	GoodsOrderService goodsOrderService;
	@RequestMapping(value="goodsOrder" ,  method=RequestMethod.POST)
	public String goodsOrder(PurchaseCommand purchaseCommand,
			HttpSession session
			) {
		goodsOrderService.execute(purchaseCommand, session);
		return "thymeleaf/puchase/payment";
	}
	
}
