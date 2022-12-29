package hkShoppungMall.service.memberShip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.command.MemberCommand;
import hkShoppungMall.domain.MemberDTO;
import hkShoppungMall.mapper.MemberShipMapper;
@Service
public class MemberJoinService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	PasswordEncoder  passwordEncoder;

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
	}
}






