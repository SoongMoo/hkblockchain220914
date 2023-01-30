package hkShoppungMall.service.nft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.mapper.MemberShipMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class AutionUploadService {
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(HttpSession session, Model model) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String accountAddress = 
				(memberShipMapper.selectMember(authInfo.getUserId())).getAccountAddress();
		model.addAttribute("accountAddress", accountAddress);		
	}
}
