package hkShoppungMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hkShoppungMall.service.member.MemberIdcheckService;

@RestController
public class CheckRestController {
	@Autowired
	MemberIdcheckService memberIdcheckService;
	@RequestMapping("member/memberIdCheck")
	public String memberIdCheck(
			//String memberId= request.getParameter("memberId")
			@RequestParam(value="memberId") String memberId) {
		String checkId = memberIdcheckService.execute(memberId);
		String message=null;
		if (checkId == null) {
			message="사용가능한 아이디입니다.";
		}else {
			message="사용중인 아이디입니다.";
		}
		return message;
	}
}
