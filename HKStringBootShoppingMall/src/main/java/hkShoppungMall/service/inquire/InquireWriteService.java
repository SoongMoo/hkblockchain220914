package hkShoppungMall.service.inquire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.InquireDTO;
import hkShoppungMall.mapper.MemberShipMapper;
import hkShoppungMall.repository.InquireRepository;
import jakarta.servlet.http.HttpSession;
@Service
public class InquireWriteService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	InquireRepository inquireRepository;
	public void execute(Integer inquireNum, String goodsNum, String inquireKind, String inquireSubject, String inquireContent,
			String email1, String email2, HttpSession session ) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String memberNum =(memberShipMapper.selectMember(authInfo.getUserId()).getMemberNum());
		InquireDTO dto = new InquireDTO();
		dto.setInquireNum(inquireNum);
		dto.setGoodsNum(goodsNum);
		dto.setInquireContent(inquireContent);
		dto.setInquireKind(inquireKind);
		dto.setInquireSubject(inquireSubject);
		dto.setMemberNum(memberNum);
		dto.setAnswerEmail(email1 +"@"+email2);
		dto.setMemberId(authInfo.getUserId());
		inquireRepository.inquireWrite(dto);
	}
}
