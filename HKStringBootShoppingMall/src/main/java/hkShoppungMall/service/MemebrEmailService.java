package hkShoppungMall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.mapper.MemberMapper;

@Service
public class MemebrEmailService {
	@Autowired
	MemberMapper memberMapper;
	public int execute(String memberEmail) {
		System.out.println(memberEmail);
		int i = memberMapper.joinOkUpdate(memberEmail);
		return i;
	}
}
