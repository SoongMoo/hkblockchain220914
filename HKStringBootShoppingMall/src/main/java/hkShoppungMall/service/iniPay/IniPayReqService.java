package hkShoppungMall.service.iniPay;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.inicis.std.util.SignatureUtil;

import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.MemberDTO;
import hkShoppungMall.mapper.MemberShipMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class IniPayReqService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(String purchaseNum,String totalPrice,Model model, HttpSession session) throws Exception {
		
		String mid					= "INIpayTest";		                    // 상점아이디					
		String signKey			    = "SU5JTElURV9UUklQTEVERVNfS0VZU1RS";	// 웹 결제 signkey
		
		String mKey = SignatureUtil.hash(signKey, "SHA-256");

		String timestamp			= SignatureUtil.getTimestamp();			// util에 의해서 자동생성
		//String orderNumber			= mid+"_"+SignatureUtil.getTimestamp();	// 가맹점 주문번호(가맹점에서 직접 설정)
		//String price				= "1000";								// 상품가격(특수기호 제외, 가맹점에서 직접 설정)


		Map<String, String> signParam = new HashMap<String, String>();

		signParam.put("oid", purchaseNum);
		signParam.put("price", "100");
		signParam.put("timestamp", timestamp);

		String signature = SignatureUtil.makeSignature(signParam);
		
		System.out.println("signature : " + signature);
		
		AuthInfo authInfo  = (AuthInfo)session.getAttribute("authInfo");
		MemberDTO memDTO = memberShipMapper.selectMember(authInfo.getUserId());
		
		
		model.addAttribute("purchaseNum", purchaseNum);
		model.addAttribute("totalPrice", "100");
		model.addAttribute("timestamp", timestamp);
		model.addAttribute("mid", mid);
		model.addAttribute("signature", signature);
		model.addAttribute("mKey", mKey);
		model.addAttribute("memberCommand", memDTO);
	}
}
