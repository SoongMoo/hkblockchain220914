package hkShoppungMall.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.mapper.MemberMapper;

@Service
public class MemberDeleteService {
	@Autowired
	MemberMapper memberMapper;
	public Integer execute(String memberNum) {
		Integer i = memberMapper.memberDelete(memberNum);
		return i;
	}
}