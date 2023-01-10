package hkShoppungMall.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import hkShoppungMall.command.FileInfo;
import hkShoppungMall.command.GoodsCommand;
import hkShoppungMall.domain.GoodsDTO;
import hkShoppungMall.service.goods.FileDelService;
import hkShoppungMall.service.goods.GoodsAutoNum;
import hkShoppungMall.service.goods.GoodsDeleteService;
import hkShoppungMall.service.goods.GoodsDetailService;
import hkShoppungMall.service.goods.GoodsListService;
import hkShoppungMall.service.goods.GoodsModifyService;
import hkShoppungMall.service.goods.GoodsWriteService;
import jakarta.servlet.http.HttpServletRequest;
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
			@RequestParam(value="page" , required = false, defaultValue = "1") int page,
			Model model) {
		goodsListService.execute(model, goodsWord, page);
		return "thymeleaf/goods/goodsList";
	}
	@RequestMapping(value = "goodsList3")
	public String goodsList3() {
		return "redirect:goodsList2";
	}
	@RequestMapping(value="goodsList2")
	public @ResponseBody ModelAndView goodsList2(
			@RequestParam(value = "goodsWord", required = false ) String goodsWord,
			@RequestParam(value="page" , required = false, defaultValue = "1") int page,
			Model model) {	
		ModelAndView mav = new ModelAndView();
		mav.setViewName("jsonView");
		//mav.setViewName("goods/goodsList"); // jsp파일
		goodsListService.execute(model, goodsWord, page);
		return mav;
	}
	@RequestMapping(value="goodsRegist", method = RequestMethod.GET)
	public String goodsRegist(GoodsCommand goodsCommand) {
		goodsAutoNum.execute(goodsCommand);
		return "thymeleaf/goods/goodsForm";
		//return "thymeleaf/goods/goodsForm2";
		//return "thymeleaf/goods/goodsForm3";
		//return "thymeleaf/goods/goodsForm4";
	}
	@RequestMapping(value = "goodsRegist" , method = RequestMethod.POST)
	public String goodsRegist(@Validated GoodsCommand goodsCommand,
			BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "thymeleaf/goods/goodsForm";
		}
		if(goodsCommand.getGoodsMain().getOriginalFilename().isEmpty()) {
			result.rejectValue("goodsMain", "goodsCommand.goodsMain", "대문이미지를 선택하여주세요.");
			return "thymeleaf/goods/goodsForm";
		}
		goodsWriteService.execute(goodsCommand, session);
		return "redirect:goodsList";
	}
	@RequestMapping(value = "goodsRegist1", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> goodsRegist(
			MultipartHttpServletRequest request,HttpSession session){
		GoodsCommand goodsCommand = new GoodsCommand();
		goodsCommand.setDeliveryCost(Integer.parseInt(request.getParameter("deliveryCost")));
		goodsCommand.setGoodsContent(request.getParameter("goodsContent"));
		goodsCommand.setGoodsName(request.getParameter("goodsName"));
		goodsCommand.setGoodsNum(request.getParameter("goodsNum"));
		goodsCommand.setGoodsPrice(Integer.parseInt(request.getParameter("goodsPrice")));
		
		MultipartFile goodsMain = request.getFile("goodsMain");
		goodsCommand.setGoodsMain(goodsMain);
		
		// html로 부터 가져온 데이터는 리스트로 받는다. 
		List<MultipartFile> goodsImages = request.getFiles("goodsImages");
		Integer size = goodsImages.size(); // 리스트 사이즈 만큼 배열의 크기를 만들기 위해서 
		// 리스트를 배열로 변환
		MultipartFile [] mf = new MultipartFile[size]; // 리스크 크기 만큼 배열 생성
		for(int i = 0; i < size ; i++) {
			mf[i] = goodsImages.get(i);
		}
		goodsCommand.setGoodsImages(mf);
		goodsWriteService.execute(goodsCommand, session);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("SUCCESS", true);		
		return result;
	}
	@RequestMapping(value = "goodsRegist2" , method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> goodsRegist( GoodsCommand goodsCommand, HttpSession session) {
		goodsWriteService.execute(goodsCommand, session);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("SUCCESS", true);		
		return result;
	}
	@RequestMapping(value = "goodsRegist3" , method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> goodsRegist(
			@RequestBody Map<String, Object> param
			){
		Map<String, Object> head = (Map<String, Object>)param.get("head");
		Map<String, Object> body = (Map<String, Object>)param.get("body");
		System.out.println(head.get("screen_id"));		
		System.out.println(body.get("goodsNum"));
		System.out.println(body.get("goodsName"));
		System.out.println(body.get("goodsPrice"));
		System.out.println(body.get("goodsContent"));
		System.out.println(body.get("deliveryCost"));
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("SUCCESS", true);		
		result.put("result_code", 200);
		return result;
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
			@RequestParam(value = "goodsNum") String goodsNum, HttpSession session,
			Model model) {
		session.removeAttribute("fileList");
		goodsDetailService.execute(model, goodsNum);
		return "thymeleaf/goods/goodsUpdate";
	}
	@Autowired
	GoodsModifyService goodsModifyService;
	@RequestMapping(value = "goodsModify", method = RequestMethod.POST)
	public String goodsModify(@Validated  GoodsCommand goodsCommand, 
			BindingResult result, HttpSession session, Model model) {
		goodsModifyService.execute( goodsCommand, session, result, model);
		if(result.hasErrors()) {
			GoodsDTO dto = goodsDetailService.execute(model, goodsCommand.getGoodsNum());
			model.addAttribute("goodsCommand", dto);
			model.addAttribute("error", "필수항목을 모두 입력해 주세요.");
			session.removeAttribute("fileList");
			return "thymeleaf/goods/goodsUpdate";
		}
		return "redirect:goodsDetail/"+goodsCommand.getGoodsNum();
	}
	@Autowired
	GoodsDeleteService goodsDeleteService;
	@RequestMapping("goodsDelete/{goodsNum}")
	public String goodsDelete(
			@PathVariable(value = "goodsNum")String goodsNum
			, HttpServletRequest request) {
		goodsDeleteService.execute(goodsNum, request);
		return "redirect:../goodsList";		
	}
	@Autowired
	FileDelService fileDelService;
	@RequestMapping(value = "fileDel")
	public String fileDel(FileInfo fileInfo, HttpSession session, Model model) {
		fileDelService.execute(fileInfo, session, model);
		return "thymeleaf/goods/delPage";
	}
}






