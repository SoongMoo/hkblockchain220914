package hkShoppungMall.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.mapper.MemberMapper;

@Service
public class MemberIdcheckService {
	@Autowired
	MemberMapper memberMapper;
	public String execute(String memberId) {
		String memId = memberMapper.memberIdCheck(memberId);
		return memId;
	}
}
