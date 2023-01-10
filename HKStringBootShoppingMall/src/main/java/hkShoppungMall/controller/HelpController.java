package hkShoppungMall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hkShoppungMall.command.FindIdCommand;
import hkShoppungMall.command.FindPasswordCommand;
import hkShoppungMall.service.help.FindIdService;
import hkShoppungMall.service.help.FindPwService;

@Controller
@RequestMapping("help")
public class HelpController {
	@RequestMapping(value="findId", method = RequestMethod.GET)
	public String findId(
			@ModelAttribute("findIdCommand")FindIdCommand findIdCommand ) {

		return "thymeleaf/help/findId";
	}
	@Autowired
	FindIdService findIdService;
	@RequestMapping(value="findId", method = RequestMethod.POST)
	public String findId(@Validated FindIdCommand findIdCommand,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "thymeleaf/help/findId";
		}
		String path = findIdService.execute(findIdCommand, result, model);
		return path;
	}
	@RequestMapping(value="findPassword", method = RequestMethod.GET )
	public String findPassword(FindPasswordCommand findPasswordCommand) {
		return "thymeleaf/help/findPw";
	}
	@Autowired
	FindPwService findPwService;
	@RequestMapping(value="findPassword", method = RequestMethod.POST )
	public String findPassword(@Validated FindPasswordCommand findPasswordCommand,
			BindingResult result) {
		if(result.hasErrors()) {
			return "thymeleaf/help/findPw";
		}
		String path = findPwService.execute(findPasswordCommand, result);
		return path;
	}
}
