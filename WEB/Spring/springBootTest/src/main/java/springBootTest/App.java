package springBootTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// 다양한 설정을 자동으로 수행되고 기존의 스프링 애플리케이션에 필요했던 설정 파일이 필요없게 된다.
@EnableAutoConfiguration
public class App {
	// HTTP 요청을 받아들이는 메서드임을 나타냄.
	@RequestMapping("/")
	String home() {
		return "hello World";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 스프링부트 애플리케이션을 실행하는 데 필요한 처리를 main()메서드 안에 작성
		// @EnableAutoConfiguration 애너테이션이 붙은 클래스를 
		//SpringApplication.run()메서드의 첫번째인자가 지정한다.
		 SpringApplication.run(App.class, args);
	}

}
