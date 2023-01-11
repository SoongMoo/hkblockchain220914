package hkShoppungMall.controller;


import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hkShoppungMall.command.LoginCommand;
import hkShoppungMall.service.login.LoginService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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
			BindingResult result, HttpSession session, HttpServletResponse response) {
		if(result.hasErrors()) {
			return "thymeleaf/index";
		}
		String path = loginService.execute(loginCommand, result, session, response);
		return path; 
	}
	@RequestMapping(value = "/login/logout")
	public String logout(HttpSession session, HttpServletResponse response){
		Cookie cookie = new Cookie("autoLogin", "");
		cookie.setPath("/");
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping(value="/login/item.login", method = RequestMethod.GET)
	public String item(LoginCommand loginCommand) {
		return "thymeleaf/login";
	}
	@RequestMapping(value="/login/item.login", method = RequestMethod.POST)
	public String item(@Validated LoginCommand loginCommand,
			BindingResult result ,HttpSession session, HttpServletResponse response) {	
		loginService.execute(loginCommand, result, session, response);
		if(result.hasErrors()) {
			return "thymeleaf/login";
		}
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String str =  "<script language='javascript'>" 
				   +  " opener.location.reload();"
				   +  " window.self.close();"
		           +  "</script>";
		out.print(str);
		out.close();
		return null;
	}
	
	
	
	
	
	
}
