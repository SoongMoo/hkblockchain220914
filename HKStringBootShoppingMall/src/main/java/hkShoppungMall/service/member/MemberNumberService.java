package hkShoppungMall.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.mapper.MemberMapper;

@Service
public class MemberNumberService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(Model model) {
		String num = memberMapper.memberNumGenerate();
		model.addAttribute("memberNum",num);
	}
}
