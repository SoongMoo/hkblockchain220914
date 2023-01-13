package hkShoppungMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hkShoppungMall.command.PurchaseCommand;
import hkShoppungMall.service.puchase.DoPaymentService;
import hkShoppungMall.service.puchase.GoodsBuyService;
import hkShoppungMall.service.puchase.GoodsOrderService;
import hkShoppungMall.service.puchase.OrderProcessListService;
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
			HttpSession session,Model model
			) {
		String purchaseNum = goodsOrderService.execute(purchaseCommand, session);
		return "redirect:paymentOk?purchaseNum="+purchaseNum+"&totalPrice="
				+purchaseCommand.getTotalPrice();
	}
	@Autowired
	OrderProcessListService orderProcessListService;
	@RequestMapping("orderList")
	public String orderList(Model model, HttpSession session) {
		orderProcessListService.execute(model, session);
		return "thymeleaf/puchase/orderList";
	}
	@RequestMapping("paymentOk")
	public String paymentOk(
			@ModelAttribute(value="purchaseNum") String purchaseNum,
			@ModelAttribute(value = "totalPrice") String totalPrice) {
		return "thymeleaf/puchase/payment";
	}
	@Autowired
	DoPaymentService doPaymentService;
	@RequestMapping(value = "doPayment" , method = RequestMethod.POST)
	public String doPayment(
			@RequestParam(value ="purchaseNum") String purchaseNum,
			@RequestParam(value ="totalPrice") String totalPrice,
			@RequestParam(value ="cardNumber") String cardNumber,
			Model model	,HttpSession session		
			) {
		doPaymentService.execute(purchaseNum, totalPrice,cardNumber
				,model,session );
		return "thymeleaf/puchase/buyfinished";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
