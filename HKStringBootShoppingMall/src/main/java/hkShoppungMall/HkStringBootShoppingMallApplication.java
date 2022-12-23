package hkShoppungMall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class HkStringBootShoppingMallApplication {
	public static void main(String[] args) {
		SpringApplication.run(HkStringBootShoppingMallApplication.class, args);
	}
	@RequestMapping("/")
	public String index() {
		return "thymeleaf/index";
	}
	@Bean
	// 암호화 모듈
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
