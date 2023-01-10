package hkShoppungMall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("help")
public class HelpController {
	@RequestMapping(value="findId", method = RequestMethod.GET)
	public String findId() {
		return "thymeleaf/help/findId";
	}
}
