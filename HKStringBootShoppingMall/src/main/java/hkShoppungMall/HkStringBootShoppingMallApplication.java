package hkShoppungMall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hkShoppungMall.command.LoginCommand;
import hkShoppungMall.service.CookiesService;
import hkShoppungMall.service.goods.GoodsListPageSerivce;
import jakarta.servlet.http.HttpServletRequest;

@SpringBootApplication
@Controller
@MapperScan(value = {"hkShoppungMall"})
public class HkStringBootShoppingMallApplication {
	/*
	@ModelAttribute
	public LoginCommand getLoginCommand() {
		return new LoginCommand();
	}
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(HkStringBootShoppingMallApplication.class, args);
	}
	@Autowired
	CookiesService  cookiesService;
	@Autowired
	GoodsListPageSerivce goodsListPageSerivce;
	@RequestMapping("/")
	public String index(LoginCommand loginCommand,
			/*@ModelAttribute(value="loginCommand") LoginCommand loginCommand,*/
			Model model,HttpServletRequest request) {
		cookiesService.executeMain(request,model);
		goodsListPageSerivce.execute(model);
		//model.addAttribute("loginCommand",new LoginCommand());
		return "thymeleaf/index";
	}

	@Bean
	// 암호화 모듈
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	// PasswordEncoder passwordEncoder 
	//                    = new BCryptPasswordEncoder();
}
