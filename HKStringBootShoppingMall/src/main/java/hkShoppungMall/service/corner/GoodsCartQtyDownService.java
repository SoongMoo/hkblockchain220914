package hkShoppungMall.service.corner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.CartDTO;
import hkShoppungMall.domain.MemberDTO;
import hkShoppungMall.mapper.MemberShipMapper;
import hkShoppungMall.repository.CornerRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsCartQtyDownService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	CornerRepository cornerRepository;
	public void execute(String goodsNum, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		MemberDTO memberDTO =  memberShipMapper.selectMember(authInfo.getUserId());
		CartDTO  dto = new CartDTO();
		dto.setGoodsNum(goodsNum);
		dto.setMemberNum(memberDTO.getMemberNum());
		cornerRepository.goodsCartQtyDown(dto);
		
		
	}
}
