package hkShoppungMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hkShoppungMall.service.review.ReviewDeleteService;
import hkShoppungMall.service.review.ReviewListService;
import hkShoppungMall.service.review.ReviewUpdateService;
import hkShoppungMall.service.review.ReviewWriteService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("review")
public class ReviewController {
	@RequestMapping("goodsReview")
	public String goodsReview(
			@ModelAttribute(value="goodsNum")String goodsNum,
			@ModelAttribute(value="purchaseNum")String purchaseNum) {
		return "thymeleaf/review/goodsReview";
	}
	@Autowired
	ReviewWriteService reviewWriteService;
	@RequestMapping(value = "reviewWrite", method = RequestMethod.POST)
	public String reviewWrite(
			@RequestParam(value="goodsNum") String goodsNum,
			@RequestParam(value="reviewContent") String reviewContent,
			@RequestParam(value="purchaseNum") String purchaseNum,
			HttpSession session) {
		reviewWriteService.execute(goodsNum,reviewContent,purchaseNum,session );
		return "redirect:/puchase/orderList";
	}
	@Autowired
	ReviewDeleteService reviewDeleteService ;
	@RequestMapping("goodsReviewDelete")
	public String goodsReviewDelete(
			@RequestParam(value="reviewNum") String reviewNum) {
		reviewDeleteService.execute(reviewNum);
		return "redirect:/puchase/orderList";
	}
	
	@Autowired
	ReviewUpdateService reviewUpdateService;
	@RequestMapping(value="goodsReviewUpdate", method =RequestMethod.GET)
	public String goodsReviewUpdate(
			@RequestParam(value="reviewNum") String reviewNum,
			Model model) {
		reviewUpdateService.execute(reviewNum, model);
		return "thymeleaf/review/goodsReviewUpdate";
	}
	@RequestMapping(value="goodsReviewUpdate", method =RequestMethod.POST)
	public String goodsReviewUpdate(
			@RequestParam(value="reviewNum") Long reviewNum,
			@RequestParam(value="reviewContent") String reviewContent
			) {
		reviewUpdateService.execute(reviewNum, reviewContent);
		return "redirect:/puchase/orderList";
	}
	
	@Autowired
	ReviewListService reviewListService;
	@RequestMapping(value="reviewList",method=RequestMethod.POST)
	public String reviewList(
			@RequestParam(value="goodsNum") String goodsNum,
			Model model
			) {
		reviewListService.execute(goodsNum, model);
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/review/reviewList";
	}
	
	
	
	
	
}
