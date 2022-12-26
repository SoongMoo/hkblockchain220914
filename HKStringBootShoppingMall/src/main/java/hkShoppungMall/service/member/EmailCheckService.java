package hkShoppungMall.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.command.MemberCommand;
import hkShoppungMall.mapper.MemberMapper;

@Service
public class EmailCheckService {
	@Autowired
	MemberMapper memberMapper; 
	public String execute(MemberCommand memberCommand) {
		String email = 
				memberMapper.memberEmail(
						memberCommand.getMemberEmail());
		return email;
	}
}
