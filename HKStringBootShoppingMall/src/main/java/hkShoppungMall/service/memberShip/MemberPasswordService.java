package hkShoppungMall.service.memberShip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.MemberDTO;
import hkShoppungMall.mapper.MemberShipMapper;
import jakarta.servlet.http.HttpSession;
@Service
public class MemberPasswordService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(String memberPw, HttpSession session ) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String newPw = passwordEncoder.encode(memberPw);
		MemberDTO dto = new MemberDTO();
		dto.setMemberId(authInfo.getUserId());
		dto.setMemberPw(newPw);		
		memberShipMapper.updatePassword(dto);
		authInfo.setUserPw(newPw);
		//session.setAttribute("authInfo", authInfo);
	}
}
