package hkShoppungMall.service.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import hkShoppungMall.command.LoginCommand;
import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.mapper.LoginMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Service
public class LoginService {
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public String execute(LoginCommand loginCommand,
			BindingResult result, HttpSession session, HttpServletResponse response) {
		String path = "thymeleaf/index";
		AuthInfo authInfo = loginMapper.loginSelect(loginCommand.getUserId());
		if(authInfo != null) {
			if(authInfo.getMemberOk() == null) {
				result.rejectValue("userId", "loginCommand.userId", 
						"이메일을 확인해주세요.");
				return path;
			}
			// 암호화된 비밀번호를 본문과 비교
			// passwordEncoder.matches("본문", "암호문")
			if(!passwordEncoder.matches(loginCommand.getUserPw(),
					authInfo.getUserPw())) {
				result.rejectValue("userPw", "loginCommand.userPw", 
						"비밀번호가 틀렸습니다.");
				return path;
			}else {
				System.out.println("session");
				session.setAttribute("authInfo", authInfo);
				if(loginCommand.getIdStore() != null && loginCommand.getIdStore() ) {
					Cookie cookie = new Cookie("idStore", authInfo.getUserId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie); // 사용자의 웹브라우저에 전달
				}else {
					Cookie cookie = new Cookie("idStore", "");
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
				if(loginCommand.getAutoLogin() != null && loginCommand.getAutoLogin() ) {
					Cookie cookie = new Cookie("autoLogin", authInfo.getUserId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie); // 사용자의 웹브라우저에 전달
				}
				
				path =  "redirect:/";
				return path;
			}
		}else {
			result.rejectValue("userId","loginCommand.userId",
					"아이디가 존재하지 않습니다.");
			return path;
		}
		
	}
}
