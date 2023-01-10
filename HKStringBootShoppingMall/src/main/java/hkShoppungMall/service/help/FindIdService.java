package hkShoppungMall.service.help;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import hkShoppungMall.command.FindIdCommand;
import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.mapper.FindMapper;

@Service
public class FindIdService {
	@Autowired
	FindMapper findMapper;
	public String execute(FindIdCommand findIdCommand,
			BindingResult result, Model model) {
		AuthInfo authInfo =  findMapper.findId(findIdCommand.getMemberEmail());
		if(authInfo == null) {
			result.rejectValue("memberEmail", "wrong");
			//result.rejectValue("memberEmail", "findIdCommand.memberEmail", "이메일이 틀렸습니다.");
			return "thymeleaf/help/findId";
		}else {
			if(!authInfo.getPhone().equals(findIdCommand.getMemberPhone())) {
				result.rejectValue("memberPhone", "bad");
				return "thymeleaf/help/findId";
			}
		}
		model.addAttribute("userId", authInfo.getUserId());
		return "thymeleaf/help/findIdOk";
	}
}
