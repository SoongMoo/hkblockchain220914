package hkShoppungMall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hkShoppungMall.command.LoginCommand;
import hkShoppungMall.service.login.LoginService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	LoginService loginService;
	@RequestMapping(value = "/login/loginPro", method = RequestMethod.GET)
	public String home() {
		return "redirect:/";
	}
	@RequestMapping(value = "/login/loginPro", method = RequestMethod.POST)
	public String loginPro(@Validated LoginCommand loginCommand,
			BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "thymeleaf/index";
		}
		String path = loginService.execute(loginCommand, result, session);
		return path; 
	}
	@RequestMapping(value = "/login/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}
