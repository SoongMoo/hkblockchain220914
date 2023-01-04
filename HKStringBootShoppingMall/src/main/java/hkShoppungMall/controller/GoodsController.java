package hkShoppungMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hkShoppungMall.command.GoodsCommand;
import hkShoppungMall.service.goods.GoodsAutoNum;
import hkShoppungMall.service.goods.GoodsDeleteService;
import hkShoppungMall.service.goods.GoodsDetailService;
import hkShoppungMall.service.goods.GoodsListService;
import hkShoppungMall.service.goods.GoodsModifyService;
import hkShoppungMall.service.goods.GoodsWriteService;
import jakarta.servlet.http.HttpSession;



@RequestMapping("goods")
@Controller
public class GoodsController {
	@Autowired
	GoodsAutoNum goodsAutoNum;
	@Autowired
	GoodsWriteService goodsWriteService;
	@Autowired
	GoodsListService goodsListService;
	@RequestMapping("goodsList")
	public String goodsList(
			@RequestParam(value = "goodsWord", required = false ) String goodsWord,
			Model model) {
		goodsListService.execute(model, goodsWord);
		return "thymeleaf/goods/goodsList";
	}
	@RequestMapping(value="goodsRegist", method = RequestMethod.GET)
	public String goodsRegist(GoodsCommand goodsCommand) {
		goodsAutoNum.execute(goodsCommand);
		return "thymeleaf/goods/goodsForm";
	}
	@RequestMapping(value = "goodsRegist" , method = RequestMethod.POST)
	public String goodsRegist(@Validated GoodsCommand goodsCommand,
			BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsForm";
		}
		goodsWriteService.execute(goodsCommand, session);
		return "redirect:goodsList";
	}
	@Autowired
	GoodsDetailService goodsDetailService;
	@RequestMapping("goodsDetail/{goodsNum}")
	public String goodsDetail(
			@PathVariable(value = "goodsNum") String goodsNum,
			Model model) {
		model.addAttribute("newLineChar", '\n'); 
		goodsDetailService.execute(model, goodsNum);
		return "thymeleaf/goods/goodsDetail";
	}
	@RequestMapping(value = "goodsModify", method = RequestMethod.GET)
	public String goodsModify(
			@RequestParam(value = "goodsNum") String goodsNum,
			Model model) {
		goodsDetailService.execute(model, goodsNum);
		return "thymeleaf/goods/goodsUpdate";
	}
	@Autowired
	GoodsModifyService goodsModifyService;
	@RequestMapping(value = "goodsModify", method = RequestMethod.POST)
	public String goodsModify(@Validated  GoodsCommand goodsCommand, 
			BindingResult result, HttpSession session) {
		goodsModifyService.execute( goodsCommand, session);
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsUpdate";
		}
		return "redirect:goodsDetail/"+goodsCommand.getGoodsNum();
	}
	@Autowired
	GoodsDeleteService goodsDeleteService;
	@RequestMapping("goodsDelete/{goodsNum}")
	public String goodsDelete(
			@PathVariable(value = "goodsNum")String goodsNum
			) {
		goodsDeleteService.execute(goodsNum);
		return "redirect:../goodsList";		
	}
}





