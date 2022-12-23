package hkShoppungMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hkShoppungMall.command.MemberCommand;
import hkShoppungMall.service.member.MemberNumberService;
import hkShoppungMall.service.member.MemberRegistService;

@Controller
@RequestMapping("member")
public class MemberConteroller {
	@Autowired
	MemberNumberService memberNumberService;
	@Autowired
	MemberRegistService memberRegistService;
	@RequestMapping("memberList")
	public String memberList() {
		return "thymeleaf/member/memberList";
	}
	@RequestMapping(value="memberRegist", method = RequestMethod.GET)
	public String memberRegist(Model model) {
		memberNumberService.execute(model);
		return "thymeleaf/member/memberForm";
	}
	@RequestMapping(value="memberRegist", method = RequestMethod.POST)
	public String memberWrite(MemberCommand memberCommand) {
		memberRegistService.execute(memberCommand);
		return "redirect:memberList";
	}
}
