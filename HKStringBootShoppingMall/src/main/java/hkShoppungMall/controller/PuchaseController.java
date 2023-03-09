package hkShoppungMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hkShoppungMall.command.PurchaseCommand;
import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.MemberDTO;
import hkShoppungMall.mapper.MemberShipMapper;
import hkShoppungMall.service.corner.GoodsCartAddService;
import hkShoppungMall.service.iniPay.IniPayReqService;
import hkShoppungMall.service.iniPay.IniPayReturnService;
import hkShoppungMall.service.puchase.DoPaymentService;
import hkShoppungMall.service.puchase.GoodsBuyService;
import hkShoppungMall.service.puchase.GoodsOrderService;
import hkShoppungMall.service.puchase.OrderProcessListService;
import hkShoppungMall.service.puchase.PaymentDelService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("puchase")
public class PuchaseController {
	
	@Autowired
	GoodsBuyService goodsBuyService;
	@RequestMapping(value="goodsBuy")
	public String goodsBuy(
			@RequestParam(value="prodCk") String [] prodCk,
			HttpSession session, Model model) {
		goodsBuyService.execute(prodCk, session, model);
		return "thymeleaf/puchase/goodsOrder";
	}
	
	@Autowired
	GoodsCartAddService goodsCartAddService;
	@RequestMapping("buyItem")
	public String buyItem(@RequestParam(value = "goodsNum")String goodsNum,
				@RequestParam(value = "purchaseQty")Integer purchaseQty,
				HttpSession session
			) {
		goodsCartAddService.execute(goodsNum, purchaseQty, session);
		return "redirect:goodsBuy?prodCk="+goodsNum;
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
	@Autowired
	IniPayReqService iniPayService;
	@RequestMapping("paymentOk")
	public String paymentOk(
			@RequestParam(value="purchaseNum") String purchaseNum,
			@RequestParam(value = "totalPrice") String totalPrice,
			Model model, HttpSession session) {
		try {
			iniPayService.execute(purchaseNum,totalPrice,model, session);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "thymeleaf/puchase/payment";
	}
	@Autowired
	IniPayReturnService iniPayReturnService;

	@RequestMapping("INIstdpay_pc_return")
	public String INIstdpay_pc_return(HttpServletRequest request,HttpSession session,Model model) {

		iniPayReturnService.execute(request,session,model);
		return "thymeleaf/puchase/buyfinished";
		//return "thymeleaf/puchase/INIstdpay_pc_return";
	}
	@RequestMapping("close")
	public String close() {
		return "thymeleaf/puchase/close";
	}
	/*
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
	*/
	@Autowired
	PaymentDelService paymentDelService;
	@RequestMapping("paymentCancel")
	public String paymentCancel(@RequestParam(value = "purchaseNum")String purchaseNum) {
		paymentDelService.execute(purchaseNum);
		return "redirect:orderList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
