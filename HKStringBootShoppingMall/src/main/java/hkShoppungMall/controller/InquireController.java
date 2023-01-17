package hkShoppungMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hkShoppungMall.service.inquire.InquireListService;

@Controller
@RequestMapping("inquire")
public class InquireController {
	@Autowired
	InquireListService inquireListService;
	@RequestMapping(value="inquireList")
	public String inquireList(
			@RequestParam(value = "goodsNum") String goodsNum,
			Model model) {
		inquireListService.execute(goodsNum, model);
		return "thymeleaf/inquire/inquireList";
	}
	@RequestMapping("inquireWrite")
	public String inquireWrite(
			@ModelAttribute(value = "goodsNum") String goodsNum) {
		return "thymeleaf/inquire/inquireWrite";
	}
}
