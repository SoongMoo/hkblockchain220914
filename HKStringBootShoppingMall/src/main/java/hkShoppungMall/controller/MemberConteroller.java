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

import hkShoppungMall.command.MemberCommand;
import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.service.EmailCheckService;
import hkShoppungMall.service.member.MemberDeleteService;
import hkShoppungMall.service.member.MemberDelsService;
import hkShoppungMall.service.member.MemberDetailService;
import hkShoppungMall.service.member.MemberListService;
import hkShoppungMall.service.member.MemberModifyService;
import hkShoppungMall.service.member.MemberNumberService;
import hkShoppungMall.service.member.MemberRegistService;

@Controller
@RequestMapping("member")
public class MemberConteroller {
	@Autowired
	MemberNumberService memberNumberService;
	@Autowired
	MemberRegistService memberRegistService;
	@Autowired
	EmailCheckService emailCheckService;
	@Autowired
	MemberListService memberListService;
	@Autowired
	MemberDetailService memberDetailService;
	// MemberDetailService memberDetailService = new MemberDetailService();
	@Autowired
	MemberModifyService memberModifyService;
	@Autowired
	MemberDeleteService memberDeleteService;
	@Autowired
	MemberDelsService memberDelsService;
	@RequestMapping("memberDels")
	public String memberDels(
			// String memDels [] = request.getParameterValues("memDels");
			@RequestParam(value = "memDels") String memDels []
			) {
		memberDelsService.execute(memDels);
		return "redirect:memberList";
	}
	@RequestMapping("memberList")
	public String memberList(
			@RequestParam(value = "memberWord" ,required = false ) String memberWord,
			Model model) {
		memberListService.execute(model, memberWord);
		return "thymeleaf/member/memberList";
	}
	@RequestMapping(value="memberRegist", method = RequestMethod.GET)
	public String memberRegist(MemberCommand memberCommand) {
		memberNumberService.execute( memberCommand);
		return "thymeleaf/member/memberForm";
	}
	@RequestMapping(value = "memberDetail/{memberNum}") // pathValiable
	public String memberDetail(
			// String memberNum = request.getParameter("memberNum");
			@PathVariable(value = "memberNum")String memberNum,
			Model model) {
			// HttpServletRequest대신 스프링에서는 Model을 사용
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberDetail";
	}
	@RequestMapping("memberDelete")
	public String memberDelete(
			// String memberNum = request.getParameter("memberNum");
			@RequestParam(value = "memberNum")String memberNum) {
		Integer i = memberDeleteService.execute(memberNum);
		if(i == 0) {
			return "redirect:memberDetail/"+memberNum;
		}else {
			return "redirect:memberList";
		}
	}
	@RequestMapping(value = "memberModify", method = RequestMethod.GET)
	public String memberModify(
			@RequestParam(value = "memberNum")String memberNum,
			Model model) {
		memberDetailService.execute(memberNum, model);
		return "thymeleaf/member/memberUpdate";
	}
	@RequestMapping(value = "memberModify", method = RequestMethod.POST)
	public String memberUpdate(@Validated  MemberCommand memberCommand,
			BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/member/memberUpdate";
		}
		memberModifyService.excute(memberCommand);
		return "redirect:memberDetail/"+memberCommand.getMemberNum();
	}
	@RequestMapping(value="memberRegist", method = RequestMethod.POST)
	public String memberWrite(@Validated MemberCommand memberCommand,
			BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/member/memberForm";
		}
		if(!memberCommand.isMemberPwEqualsMemberPwCon()) {
			result.rejectValue("memberPw", "memberCommand.memberPw",
					"비밀번호와 비밀번호 확인이 다릅니다.");
			return "thymeleaf/member/memberForm";
		}
		// 이메일체크
		AuthInfo email = emailCheckService.execute(memberCommand.getMemberEmail());
		if(email != null) {
			result.rejectValue("memberEmail", 
					"memberCommand.memberEmail",
					"사용중인 이메일입니다.");
			return "thymeleaf/member/memberForm";
		} 
		
		Integer i = memberRegistService.execute(memberCommand);
		if(i != null)
			return "redirect:memberList";
		else return "thymeleaf/member/memberForm";
	}
}