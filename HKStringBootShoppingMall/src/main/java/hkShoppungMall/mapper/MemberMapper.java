package hkShoppungMall.mapper;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.MemberDTO;

@Repository(value="hkShoppungMall.mapper.MemberMapper")
public interface MemberMapper {
	public String memberNumGenerate();
	public Integer memberInsert(MemberDTO dto);
	public AuthInfo memberEmail(String memberEmail); 
	public String memberIdCheck(String memberId);
	public List<MemberDTO> selectAll(String memberWord);
	public MemberDTO selectOne(String memberNum);
	public Integer memberUpdate(MemberDTO dto);
	public Integer memberDelete(String memberNum);
	public Integer membersDelete(String memDels []);
	public Integer membersRemove(HashMap<String, Object> condition);
}
