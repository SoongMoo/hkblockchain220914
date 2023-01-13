package hkShoppungMall.service.puchase;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.MemberDTO;
import hkShoppungMall.domain.PaymentDTO;
import hkShoppungMall.mapper.MemberShipMapper;
import hkShoppungMall.repository.PuchaseRepository;
import hkShoppungMall.service.EmailSendService;
import hkShoppungMall.service.SMSSendService;
import jakarta.servlet.http.HttpSession;

@Service
public class DoPaymentService {
	@Autowired
	PuchaseRepository puchaseRepository;

	@Autowired
	EmailSendService memberEmail;
	@Autowired
	SMSSendService smsSendService;

	@Autowired
	MemberShipMapper memberShipMapper;

	public void execute(String purchaseNum, String totalPrice, String cardNumber, Model model, HttpSession session) {
		PaymentDTO paymentDTO = new PaymentDTO();
		paymentDTO.setCardNumber(cardNumber);
		paymentDTO.setPaymentKind("카드");
		paymentDTO.setPaymentPrice(totalPrice);
		paymentDTO.setPurchaseNum(purchaseNum);
		String confirmNumber = UUID.randomUUID().toString().substring(0, 10);
		paymentDTO.setConfirmNumber(confirmNumber);
		puchaseRepository.payment(paymentDTO);
		puchaseRepository.purchaseStatus(purchaseNum);
		model.addAttribute("price", totalPrice);

		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		MemberDTO dto = memberShipMapper.selectMember(authInfo.getUserId());
		// 메일 보내기
		String content = "<html><body>" + "안녕하세요. 숭무 쇼핑몰입니다. <BR />" + dto.getMemberName() + "님 가입을 환영합니다.<br />"
				+ "<a href='http://localhost:8080/register/memberMail?reciver=" + dto.getMemberEmail()
				+ "'> 가입을 완료하시려면 여기를 눌러주세요. </a>" + "</body></html>";
		String subject = "가입환영인사";
		memberEmail.mailSend(content, subject, "administrator@gmail.com", dto.getMemberEmail());
		// SMS
		content = "안녕하세요. 숭무쇼핑몰입니다.\n" + dto.getMemberName() + "님 가입을 환영합니다.\n" + "이메일로 본인인증을 부탁드립니다.";
		smsSendService.send("01071461970", dto.getMemberPhone(), content);
	}
}
