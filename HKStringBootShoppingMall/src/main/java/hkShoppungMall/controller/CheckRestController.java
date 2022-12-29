package hkShoppungMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.service.EmailCheckService;
import hkShoppungMall.service.IdcheckService;
import hkShoppungMall.service.MemebrEmailService;
import hkShoppungMall.service.member.MemberDeleteService;

@RestController
public class CheckRestController {
	@Autowired
	IdcheckService idcheckService;
	@Autowired
	EmailCheckService emailCheckService;
	@Autowired
	MemberDeleteService memberDeleteService;
	@RequestMapping("member/memberDelete1")
	public String memberDelete1(
			@RequestParam(value = "memberNum")String memberNum
			) {
		Integer i = memberDeleteService.execute(memberNum);
		return i.toString();
	}
	@RequestMapping("member/memEmailCk")
	public String memEmailCk(
			@RequestParam(value = "memberEmail")String memberEmail,
			@RequestParam(value = "memberId")String  memberId) {
		AuthInfo authIndo = emailCheckService.execute(memberEmail);
		if(authIndo == null) {
			return "사용 가능 이메일입니다.";
		}else {
			if(authIndo.getUserId().equals(memberId)) {
				return "사용 가능 이메일입니다.";
			}else {
				return "사용중인 이메일입니다.";
			}
		}
	}
	@RequestMapping("member/memberIdCheck")
	public String memberIdCheck(
			//String memberId= request.getParameter("memberId")
			@RequestParam(value="memberId") String memberId) {
		String checkId = idcheckService.execute(memberId);
		String message=null;
		if (checkId == null) {
			message="사용가능한 아이디입니다.";
		}else {
			message="사용중인 아이디입니다.";
		}
		return message;
	}
	@RequestMapping("employee/employeeIdCheck")
	public String employeeIdCheck(
			//String memberId= request.getParameter("memberId")
			@RequestParam(value="memberId") String memberId) {
		String checkId = idcheckService.execute(memberId);
		String message=null;
		if (checkId == null) {
			message="사용가능한 아이디입니다.";
		}else {
			message="사용중인 아이디입니다.";
		}
		return message;
	}
	@Autowired
	MemebrEmailService memebrEmailService;
	@RequestMapping(value = "/register/memberMail")
	public String memberMail(
			@RequestParam(value = "reciver")String memberEmail) {
		int i = memebrEmailService.execute(memberEmail);
		if(i == 1)
			return "인증이 완료되었습니다.";
		else 
			return "이미 인증이 되었습니다.";
	}
}
