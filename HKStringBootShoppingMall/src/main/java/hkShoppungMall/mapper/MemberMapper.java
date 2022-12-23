package hkShoppungMall.mapper;

import org.springframework.stereotype.Repository;

import hkShoppungMall.domain.MemberDTO;

@Repository(value="hkShoppungMall.mapper.MemberMapper")
public interface MemberMapper {
	public String memberNumGenerate();
	public Integer memberInsert(MemberDTO dto);
}
