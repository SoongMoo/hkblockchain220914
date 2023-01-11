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
public class GoodsCartAddService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	CornerRepository cornerRepository;
	public String execute(String goodsNum,Integer goodsQty, HttpSession session) {
		/*
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		MemberDTO memDTO = memberShipMapper.selectMember(authInfo.getUserId());
		*/
		CartDTO cart = new CartDTO();
		cart.setGoodsNum(goodsNum);
		cart.setCartQty(Long.valueOf(goodsQty));
		cart.setMemberNum(memberShipMapper.selectMember(
						  ((AuthInfo)session.getAttribute("authInfo"))
						  .getUserId())
							.getMemberNum());
		return cornerRepository.cartAdd(cart).toString();
	}
}
