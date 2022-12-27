package hkShoppungMall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.mapper.MemberMapper;

@Service
public class EmailCheckService {
	@Autowired
	MemberMapper memberMapper; 
	public AuthInfo execute(String userEmail) {
		AuthInfo authInfo = 
				memberMapper.memberEmail(userEmail);
		return authInfo;
	}
}
