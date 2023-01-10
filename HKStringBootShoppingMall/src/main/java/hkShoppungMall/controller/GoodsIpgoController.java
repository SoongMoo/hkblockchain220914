package hkShoppungMall.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hkShoppungMall.command.GoodsIpgoCommand;
import hkShoppungMall.service.goodsIpgo.GoodsIpgoDeleteService;
import hkShoppungMall.service.goodsIpgo.GoodsIpgoDetailService;
import hkShoppungMall.service.goodsIpgo.GoodsIpgoListService;
import hkShoppungMall.service.goodsIpgo.GoodsIpgoService;
import hkShoppungMall.service.goodsIpgo.GoodsIpgoUpdateService;
import hkShoppungMall.service.goodsIpgo.GoodsItemService;

@Controller
@RequestMapping("goods")
public class GoodsIpgoController {
	@ModelAttribute
	public GoodsIpgoCommand getGoodsIpgoCommand() {
		return new GoodsIpgoCommand();
	}
	@RequestMapping(value="goodsIpgo", method = RequestMethod.GET)
	public String goodsIpgo(GoodsIpgoCommand getGoodsIpgoCommand) {
		getGoodsIpgoCommand.setIpgoDate(new Date());
		return "thymeleaf/goodsIpgo/goodsIpgo";
	}
	
	@Autowired
	GoodsIpgoService goodsIpgoService;
	@RequestMapping(value="ipgoRegist", method = RequestMethod.POST)
	public String ipgoRegist(@Validated GoodsIpgoCommand goodsIpgoCommand,
			BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/goodsIpgo/goodsIpgo";
		}
		goodsIpgoService.execute(goodsIpgoCommand);
		return "redirect:goodsIpgoList";
	}
	@Autowired
	GoodsItemService goodsItemService;
	@RequestMapping(value="goodsItem")
	public String goodsItem(
			@RequestParam(value = "goodsWord" , required = false) String goodsWord,
			@RequestParam(value = "page" , required = false, defaultValue = "1") Integer page 
			,Model model) {
		goodsItemService.execute(goodsWord, page, model);
		return "thymeleaf/goodsIpgo/goodsItem";
	}
	
	@Autowired
	GoodsIpgoListService goodsIpgoListService;
	@RequestMapping("goodsIpgoList")
	public String goodsIpgoList(
			@RequestParam(value = "page",required = false ,defaultValue = "1")Integer page ,
			Model model) {
		goodsIpgoListService.execute(model, page);
		return "thymeleaf/goodsIpgo/goodsIpgoList";
	}
	@Autowired
	GoodsIpgoDetailService goodsIpgoDetailService;
	@RequestMapping("goodsIpgoDetail")
	public String goodsIpgoDetail(
			@RequestParam(value = "goodsNum") String goodsNum,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date ipgoDate,
			Model model
			) {
		goodsIpgoDetailService.execute(goodsNum, ipgoDate, model);
		return "thymeleaf/goodsIpgo/goodsIpgoDetail";
	}
	@RequestMapping(value="goodsIpgoModify" , method = RequestMethod.GET)
	public String goodsIpgoModify(@RequestParam(value = "goodsNum") String goodsNum,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date ipgoDate, 
			Model model) {
		goodsIpgoDetailService.execute(goodsNum,ipgoDate, model);
		return "thymeleaf/goodsIpgo/goodsIpgoUpdate";
	}
	@Autowired
	GoodsIpgoUpdateService goodsIpgoUpdateService;
	@RequestMapping(value ="goodsIpgoModify" , method = RequestMethod.POST)
	public String goodsIpgoModify(GoodsIpgoCommand goodsIpgoCommand) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ipgoDate = sdf.format(goodsIpgoCommand.getIpgoDate());
		goodsIpgoUpdateService.execute(goodsIpgoCommand);
		return "redirect:goodsIpgoDetail?goodsNum="+goodsIpgoCommand.getGoodsNum()
									  +"&ipgoDate="+ipgoDate; // 2023-12-04
	}
	@Autowired
	GoodsIpgoDeleteService goodsIpgoDeleteService;
	@RequestMapping(value = "goodsIpgoDelete" , method = RequestMethod.GET)
	public String goodsIpgoDelete(GoodsIpgoCommand goodsIpgoCommand) {
		goodsIpgoDeleteService.execute(goodsIpgoCommand);
		return "redirect:goodsIpgoList";
	}
}







