package hkShoppungMall.service.memberShip;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.MemberDTO;
import hkShoppungMall.mapper.MemberShipMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class MemberInfoService {
	MemberShipMapper memberShipMapper;
	public void execute(Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String memId = authInfo.getUserId();
		System.out.println(memId);
		MemberDTO dto = memberShipMapper.selectMember(memId);
		model.addAttribute("memberCommand", dto);
	}
}
