package hkShoppungMall.service.member;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.command.MemberCommand;
import hkShoppungMall.domain.MemberDTO;
import hkShoppungMall.mapper.MemberMapper;

@Service
public class MemberModifyService {
	@Autowired
	MemberMapper memberMapper;
	public void excute(MemberCommand memberCommand ) {
		MemberDTO dto = new MemberDTO();
		dto.setGender(memberCommand.getGender());
		dto.setMemberAddr(memberCommand.getMemberAddr());
		dto.setMemberBirth(memberCommand.getMemberBirth());
		dto.setMemberEmail(memberCommand.getMemberEmail());
		dto.setMemberName(memberCommand.getMemberName());
		dto.setMemberNum(memberCommand.getMemberNum());
		dto.setMemberPhone(memberCommand.getMemberPhone());
		dto.setMemberRegist(Timestamp.valueOf(memberCommand.getMemberRegist()));
		memberMapper.memberUpdate(dto);
		
	}
}
