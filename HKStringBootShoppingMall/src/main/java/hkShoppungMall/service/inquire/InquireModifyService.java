package hkShoppungMall.service.inquire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.InquireDTO;
import hkShoppungMall.mapper.MemberShipMapper;
import hkShoppungMall.repository.InquireRepository;
import jakarta.servlet.http.HttpSession;
@Service
public class InquireModifyService {
	@Autowired
	InquireRepository inquireRepository;
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(String inquireNum, Model model) {
		InquireDTO dto = inquireRepository.inquireSelect(inquireNum);
		model.addAttribute("dto", dto);
	}
	public void execute(String goodsNum, String inquireNum, String inquireKind, String inquireSubject, 
			String inquireContent,String email1, String email2, HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String memberNum =(memberShipMapper.selectMember(authInfo.getUserId()).getMemberNum());
		InquireDTO dto = new InquireDTO();
		dto.setGoodsNum(goodsNum);
		dto.setInquireNum(Integer.parseInt(inquireNum));
		dto.setInquireContent(inquireContent);
		dto.setInquireKind(inquireKind);
		dto.setInquireSubject(inquireSubject);
		dto.setAnswerEmail(email1 +"@"+email2);
		dto.setMemberNum(memberNum);
		dto.setMemberId(authInfo.getUserId());
		inquireRepository.inquireWrite(dto);
	}
}
