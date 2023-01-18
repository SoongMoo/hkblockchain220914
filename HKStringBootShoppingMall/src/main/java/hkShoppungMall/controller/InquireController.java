package hkShoppungMall.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hkShoppungMall.service.inquire.GoodsInquireDeleteService;
import hkShoppungMall.service.inquire.GoodsInquireDetailService;
import hkShoppungMall.service.inquire.GoodsQuestionService;
import hkShoppungMall.service.inquire.InquireAnswerWriteService;
import hkShoppungMall.service.inquire.InquireListService;
import hkShoppungMall.service.inquire.InquireModifyService;
import hkShoppungMall.service.inquire.InquireWriteService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		model.addAttribute("newLineChar", "\n");
		return "thymeleaf/inquire/inquireList";
	}
	@RequestMapping(value="inquireWrite", method=RequestMethod.GET)
	public String inquireWrite(
			@ModelAttribute(value = "goodsNum") String goodsNum) {
		return "thymeleaf/inquire/inquireWrite";
	}
	@Autowired
	InquireWriteService inquireWriteService;
	@RequestMapping(value="inquireWrite", method=RequestMethod.POST)
	public void inquireWrite(
			@RequestParam(value= "inquireNum" , defaultValue = "0") Integer inquireNum,
			@RequestParam(value = "goodsNum") String goodsNum,
			@RequestParam(value = "inquireKind") String inquireKind,
			@RequestParam(value = "inquireSubject") String inquireSubject,
			@RequestParam(value = "inquireContent") String inquireContent,
			@RequestParam(value = "email1") String email1,
			@RequestParam(value = "email2") String email2,
			HttpServletResponse response, HttpSession session) {
		inquireWriteService.execute(inquireNum, goodsNum,inquireKind,inquireSubject,inquireContent,
				email1, email2, session);
		try {
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			String str=  "<script language='javascript'>" 
					  +  " opener.parent.inquire();"
			          +  " window.self.close();"
			          +  "</script>";
			 out.print(str);
			 out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Autowired
	GoodsInquireDeleteService goodsInquireDeleteService ;
	@RequestMapping("inquireDelete")
	public @ResponseBody String inquireDelete(
			@RequestParam(value="inquireNum") String inquireNum) {
		System.out.println("inquireNum : " +inquireNum);
		return goodsInquireDeleteService.execute(inquireNum).toString();
	}
	@Autowired
	InquireModifyService inquireModifyService;
	@RequestMapping(value="inquireUpdate", method=RequestMethod.GET)
	public String inquireUpdate(
			@RequestParam(value="inquireNum") String inquireNum,Model model) {
		inquireModifyService.execute(inquireNum, model);
		return "thymeleaf/inquire/inquireUpdate";
	}
	@RequestMapping(value="inquireUpdate", method=RequestMethod.POST)
	public void inquireUpdate(@RequestParam(value = "goodsNum") String goodsNum,
			@RequestParam(value = "inquireNum") String inquireNum,
			@RequestParam(value = "inquireKind") String inquireKind,
			@RequestParam(value = "inquireSubject") String inquireSubject,
			@RequestParam(value = "inquireContent") String inquireContent,
			@RequestParam(value = "email1") String email1,
			@RequestParam(value = "email2") String email2,
			HttpServletResponse response,HttpSession session) {
		inquireModifyService.execute(goodsNum,inquireNum, inquireKind,inquireSubject,inquireContent,
				email1, email2,session);
		
		try {
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			String str=  "<script language='javascript'>" 
					  +  " opener.parent.inquire();"
			          +  " window.self.close();"
			          +  "</script>";
			 out.print(str);
			 out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Autowired
	GoodsQuestionService goodsQuestionService;
	@RequestMapping("goodsQuestion")
	public String goodsQuestion(Model model) {
		goodsQuestionService.execute(model);
		return "thymeleaf/inquire/goodsQuestion";
	}
	@Autowired
	GoodsInquireDetailService goodsInquireDetailService;
	@RequestMapping("goodsInquireDetail/{inquireNum}")
	public String goodsInquireDetail(
			@PathVariable(value="inquireNum")String inquireNum,Model model) {
		goodsInquireDetailService.execute(inquireNum, model);
		return "thymeleaf/inquire/goodsInquireDetail";
	}
	@Autowired
	InquireAnswerWriteService inquireAnswerWriteService;
	@RequestMapping(value="answerWrite", method= RequestMethod.POST)
	public String answerWrite(
			@RequestParam(value="inquireNum") Integer inquireNum
			,@RequestParam(value="inquireAnswer") String inquireAnswer
			,@RequestParam(value="answerEmail") String answerEmail
			,@RequestParam(value="inquireSubject") String inquireSubject) {
		inquireAnswerWriteService.execute(
				 inquireNum, inquireAnswer,answerEmail,inquireSubject);
		return "redirect:goodsQuestion";
	}
}
