package hkShoppungMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hkShoppungMall.command.MemberCommand;
import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.service.memberShip.MemberInfoService;
import hkShoppungMall.service.memberShip.MemberPasswordService;
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
	@RequestMapping("memberPass")
	public String memberPass() {
		return "thymeleaf/membership/memberPass";
	}
	@Autowired
	PasswordEncoder passwordEncoder;
	@RequestMapping(value="memberPasswordPro" , method=RequestMethod.POST)
	public String memberPasswordPro(
			@RequestParam(value="memPw") String pw, Model model,HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(!passwordEncoder.matches(pw, authInfo.getUserPw())) {
			model.addAttribute("err_pw", "비밀번호가 틀립니다.");
			return "thymeleaf/membership/memberPass";
		}
		return "thymeleaf/membership/memberPassCon";
	}
	@Autowired
	MemberPasswordService memberPasswordService;
	@RequestMapping(value="memberPassModify", method=RequestMethod.POST)
	public String memberPassModify(
			@RequestParam(value="oldPw") String oldPw,
			@RequestParam(value="memberPw") String memberPw,
			@RequestParam(value="memberPwCon") String memberPwCon,
			Model model,HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(!passwordEncoder.matches(oldPw, authInfo.getUserPw())) {
			model.addAttribute("err_pw", "비밀번호가 틀립니다.");
			return "thymeleaf/membership/memberPassCon";
		}	
		if(!memberPw.equals(memberPwCon)) {
			model.addAttribute("err_pw_con", "비밀번호와 비밀번호 확인이 다릅니다.");
			return "thymeleaf/membership/memberPassCon";
		}
		memberPasswordService.execute(memberPw, session);
		return "redirect:memberDetail";
	}
}
