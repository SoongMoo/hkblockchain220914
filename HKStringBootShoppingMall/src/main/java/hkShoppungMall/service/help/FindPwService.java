package hkShoppungMall.service.help;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import hkShoppungMall.command.FindPasswordCommand;
import hkShoppungMall.domain.PasswordChangeDTO;
import hkShoppungMall.mapper.FindMapper;
import hkShoppungMall.service.EmailSendService;
import hkShoppungMall.service.SMSSendService;

@Service
public class FindPwService {
	@Autowired
	FindMapper findMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	EmailSendService emailSendService;
	@Autowired
	SMSSendService smsSendService;
	public String  execute(FindPasswordCommand findPasswordCommand,BindingResult result) {
		String str = findMapper.findPw(findPasswordCommand);
		if(str == null) {
			result.rejectValue("userId", "notFind");
			return "thymeleaf/help/findPw";
		}else {
			String tampPw = UUID.randomUUID().toString().substring(0,8);
			String newPw = passwordEncoder.encode(tampPw);
			PasswordChangeDTO dto = new PasswordChangeDTO();
			dto.setUserId(findPasswordCommand.getUserId());
			dto.setUserPw(newPw);
			if(str.equals("mem")) {
				dto.setTableName("member");
				dto.setUserIdColumn("member_id");
				dto.setUserPwColumn("member_pw");
			}else if(str.equals("emp")) {
				dto.setTableName("employees");
				dto.setUserIdColumn("emp_id");
				dto.setUserPwColumn("emp_pw");
			}
			findMapper.changPw(dto);
			String content = "<html><body>"
							+ "안녕하세요 숭무쇼핑몰입니다. <br />'"
							+ findPasswordCommand.getUserId() + "'님의 "
							+ "임시 비밀번호는  <strong><b>["+ tampPw + "]</b></strong> 입니다. <br />"
							+ "반드시 로그인 후 비밀번호를 변경해 주세요. "
							+ "</body></html>";
			String subject = "임시비밀번호";
			emailSendService.mailSend(content, subject, "administrator@gmail.com"
					, findPasswordCommand.getUserEmail());
			content = "안녕하세요 숭무쇼핑몰입니다. "+findPasswordCommand.getUserId() + "'님의 "
					+ "임시 비밀번호가 등록된 이메일로 전송되었습니다. ";
			smsSendService.send("010-7146-1970",findPasswordCommand.getUserPhone() , content);;
		}
		return "thymeleaf/help/findPwOk";
	}
}