package hkShoppungMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import hkShoppungMall.command.MemberCommand;
import hkShoppungMall.service.memberShip.MemberInfoService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("mypage")
public class MemberMypageController {
	@Autowired
	MemberInfoService memberInfoService ;
	
	@ModelAttribute
	public MemberCommand getMemberCommand() {
		return new MemberCommand();
	}
	@RequestMapping("memberDetail")
	public String memInfo(Model model, HttpSession session) {
		memberInfoService.execute(model, session);
		return "thymeleaf/membership/memberInfo";
	}
}
