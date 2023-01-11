package hkShoppungMall.service.corner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.WishDTO;
import hkShoppungMall.mapper.MemberShipMapper;
import hkShoppungMall.repository.CornerRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsWishService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	CornerRepository cornerRepository;
	public String execute(String goodsNum, HttpSession session) {
		String userId = ((AuthInfo)session.getAttribute("authInfo")).getUserId();
		WishDTO dto = new WishDTO();
		dto.setGoodsNum(goodsNum);
		dto.setMemberNum(memberShipMapper.selectMember(userId).getMemberNum());
		cornerRepository.wishAdd(dto);
		return cornerRepository.wishCount(dto);
	}
}
