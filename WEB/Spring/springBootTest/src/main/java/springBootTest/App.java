package springBootTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// �پ��� ������ �ڵ����� ����ǰ� ������ ������ ���ø����̼ǿ� �ʿ��ߴ� ���� ������ �ʿ���� �ȴ�.
@EnableAutoConfiguration
public class App {
	// HTTP ��û�� �޾Ƶ��̴� �޼������� ��Ÿ��.
	@RequestMapping("/")
	String home() {
		return "hello World";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ��������Ʈ ���ø����̼��� �����ϴ� �� �ʿ��� ó���� main()�޼��� �ȿ� �ۼ�
		// @EnableAutoConfiguration �ֳ����̼��� ���� Ŭ������ 
		//SpringApplication.run()�޼����� ù��°���ڰ� �����Ѵ�.
		 SpringApplication.run(App.class, args);
	}

}
