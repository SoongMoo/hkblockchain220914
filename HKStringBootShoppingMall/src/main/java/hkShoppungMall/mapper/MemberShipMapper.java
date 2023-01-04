package hkShoppungMall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import hkShoppungMall.domain.MemberDTO;

@Component
@Mapper
public interface MemberShipMapper {
	public Integer memberInsert(MemberDTO dto);
}