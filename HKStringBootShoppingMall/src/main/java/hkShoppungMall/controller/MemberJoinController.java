package hkShoppungMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import hkShoppungMall.command.MemberCommand;
import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.service.EmailCheckService;
import hkShoppungMall.service.IdcheckService;
import hkShoppungMall.service.memberShip.MemberJoinService;

@Controller
@RequestMapping("register")
public class MemberJoinController {
	@ModelAttribute
	MemberCommand getMemberCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping(value = "agree", method = RequestMethod.GET)
	public String agree() {
		return "thymeleaf/memberShip/agree";
	}
	// http://localhost:8080/register/regist로 직잡 적아서 들어오는 것을 방지ㅏ
	@RequestMapping(value = "regist" , method = RequestMethod.GET)
	public String agree1() {
		return "thymeleaf/memberShip/agree";
	}
	@RequestMapping(value = "regist" , method = RequestMethod.POST)
	public String regist(
			@RequestParam(value = "agree", defaultValue = "false" ) Boolean agree) {
		if(agree == false) {
			return "thymeleaf/membership/agree";
		}
		return "thymeleaf/memberShip/memberJoinForm";
	}
	@RequestMapping(value = "memberJoinAction", method = RequestMethod.GET )
	public String memberJoinAction() {
		return "redirect:/register/agree";
	}
	@Autowired
	IdcheckService idcheckService;
	@Autowired
	EmailCheckService emailCheckService ;
	@Autowired
	MemberJoinService  memberJoinService ;
	
	@RequestMapping(value = "memberJoinAction", method = RequestMethod.POST )
	public String memberJoinAction1(
			@Validated MemberCommand memberCommand, BindingResult result,Model model) {
		if (result.hasErrors()) {
			return "thymeleaf/memberShip/memberJoinForm";
		}
		if(!memberCommand.isMemberPwEqualsMemberPwCon()) {
			result.rejectValue("memberPw", "memberCommand.memberPw", 
					"비밀번호 확인이 다릅니다.");
			return "thymeleaf/memberShip/memberJoinForm";
		}
		String i = idcheckService.execute(memberCommand.getMemberId());
		if(i != null) {
			result.rejectValue("memberId", "memberCommand.memberId", 
					"중복 아이디입니다.");
			return "thymeleaf/memberShip/memberJoinForm";
		}
		AuthInfo authInfo = emailCheckService.execute(memberCommand.getMemberEmail());
		if(authInfo != null) {
			result.rejectValue("memberEmail", "memberCommand.memberEmail", 
					"중복 Email입니다.");
			return "thymeleaf/memberShip/memberJoinForm";
		}
		memberJoinService.execute(memberCommand,model);
		return "thymeleaf/memberShip/welcome";
	}
}





