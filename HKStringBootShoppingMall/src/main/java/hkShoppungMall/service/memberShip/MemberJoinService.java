package hkShoppungMall.service.memberShip;



import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.command.MemberCommand;
import hkShoppungMall.domain.MemberDTO;
import hkShoppungMall.mapper.MemberShipMapper;
import hkShoppungMall.service.EmailSendService;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
@Service
public class MemberJoinService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	PasswordEncoder  passwordEncoder;
	@Autowired
	EmailSendService memberEmail;
	@Autowired
	JavaMailSender mailSender;
	public void execute(MemberCommand memberCommand, Model model) {
		MemberDTO dto = new MemberDTO();
		dto.setMemberBirth(memberCommand.getMemberBirth());
		dto.setGender(memberCommand.getGender());
		dto.setMemberAddr(memberCommand.getMemberAddr());
		dto.setMemberEmail(memberCommand.getMemberEmail());
		dto.setMemberId(memberCommand.getMemberId());
		dto.setMemberName(memberCommand.getMemberName());
		dto.setMemberPhone(memberCommand.getMemberPhone());
		dto.setMemberPw(passwordEncoder.encode(memberCommand.getMemberPw()));
		memberShipMapper.memberInsert(dto);
		model.addAttribute("memberName", dto.getMemberName());
		
		// 메일 보내기
		String content = "<html><body>"
				+ "안녕하세요. 숭무 쇼핑몰입니다. <BR />"
				+ dto.getMemberName() + "님 가입을 환영합니다.<br />"
				+ "<a href='http://localhost:8080/register/memberMail?reciver="
				+ dto.getMemberEmail()+"'> 가입을 완료하시려면 여기를 눌러주세요. </a>"
				+ "</body></html>";
		String subject = "가입환영인사";
		memberEmail.mailSend(content, subject, "administrator@gmail.com", 
				dto.getMemberEmail());
		
		// SMS
		String api_key = "NCSW6VCZXODXGPOX";
		String api_secret = "UZMGJ9ADCK2LCTIEWQRITSVRXW3J0B3T";
		Message coolsms = new Message(api_key, api_secret);
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("from", "01071461970");
		params.put("to", dto.getMemberPhone());
		content = "안녕하세요. 숭무쇼핑몰입니다.\n "
				+ dto.getMemberName()
				+ "님 가입을 환영합니다.\n"
				+ "이메일로 본인인증을 부탁드립니다.";
		params.put("text",content);
		params.put("app_version", "JAVA SDK v2.2");
		if(content.length() > 80) {
			params.put("type", "LMS");
		}else {
			params.put("type", "SMS");
		}
		try {
			JSONObject obj = (JSONObject) coolsms.send(params);
		} catch (CoolsmsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}






