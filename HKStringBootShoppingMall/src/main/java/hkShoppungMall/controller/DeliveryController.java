package hkShoppungMall.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hkShoppungMall.service.delivery.DeliveryActionService;
import hkShoppungMall.service.delivery.DeliveryDeleteService;
import hkShoppungMall.service.delivery.DeliveryOKService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("delivery")
public class DeliveryController {
	@Autowired
	DeliveryActionService deliveryActionService;
	@RequestMapping(value="deliveryAction", method =RequestMethod.POST)
	public void deliveryAction(
			@RequestParam(value="purchaseNum") String purchaseNum,
			@RequestParam(value="deliveryCompany") String deliveryCompany,
			@RequestParam(value="deliveryNumber") String deliveryNumber,
			HttpServletResponse response) {
		deliveryActionService.execute(purchaseNum,deliveryCompany, deliveryNumber);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str =  "<script language='javascript'>" 
				   +  " opener.location.reload();"
				   +  " window.self.close();"
		           +  "</script>";
		out.print(str);
		out.close();
	}
	@Autowired
	DeliveryDeleteService deliveryDeleteService;
	@RequestMapping("deliveryDel")
	public void deliveryDel(@RequestParam(value="purchaseNum") String purchaseNum,
			HttpServletResponse response
			) {
		deliveryDeleteService.execute(purchaseNum);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str =  "<script language='javascript'>" 
				   +  " opener.location.reload();"
				   +  " window.self.close();"
		           +  "</script>";
		out.print(str);
		out.close();
	}
	@Autowired
	DeliveryOKService deliveryOKService;
	@RequestMapping("deliveryOK")
	public String deliveryOK(@RequestParam(value="purchaseNum") String purchaseNum) {
		deliveryOKService.execute(purchaseNum);
		return "redirect:/goods/purchaseList";
	}
}