package hkShoppungMall.service.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.mapper.MemberMapper;

@Service
public class MemberDelsService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(String memDels []) {
		// 배열 사용
		// memberMapper.membersDelete(memDels);
		
		List<String> cs = new ArrayList<String>();
		for(String num : memDels ) {
			cs.add(num);
		}
		//        키       값
		HashMap<String, Object> condition =
				new HashMap<String, Object>();
		condition.put("memberNums", cs);
		memberMapper.membersRemove(condition);
		
	}
}
