package hkShoppungMall.mapper;

import org.apache.ibatis.annotations.Mapper;

import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.MemberDTO;

@Mapper
public interface MemberShipMapper {
	public Integer memberInsert(MemberDTO dto);
	public MemberDTO selectMember(String memberId);
	public Integer updatePassword(MemberDTO dto);
	public AuthInfo selectMemberNum(String purchaseNum);
}