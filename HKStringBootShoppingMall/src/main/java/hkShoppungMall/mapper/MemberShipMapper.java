package hkShoppungMall.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import hkShoppungMall.domain.MemberDTO;

@Component
@Repository(value = "hkShoppungMall.mapper.MemberShipMapper")
public interface MemberShipMapper {
	public Integer memberInsert(MemberDTO dto);
}