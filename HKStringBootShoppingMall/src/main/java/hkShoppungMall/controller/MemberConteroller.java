package hkShoppungMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hkShoppungMall.command.MemberCommand;
import hkShoppungMall.service.member.EmailCheckService;
import hkShoppungMall.service.member.MemberListService;
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
	@RequestMapping("memberList")
	public String memberList(Model model) {
		memberListService.execute(model);
		return "thymeleaf/member/memberList";
	}
	@RequestMapping(value="memberRegist", method = RequestMethod.GET)
	public String memberRegist(MemberCommand memberCommand) {
		memberNumberService.execute( memberCommand);
		return "thymeleaf/member/memberForm";
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
		String email = emailCheckService.execute(memberCommand);
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
