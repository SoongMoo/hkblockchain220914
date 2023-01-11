package hkShoppungMall.service.corner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.WishDTO;
import hkShoppungMall.mapper.MemberShipMapper;
import hkShoppungMall.repository.CornerRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsWishCheckService {
	@Autowired
	CornerRepository cornerRepository;
	@Autowired
	MemberShipMapper memberShipMapper;
	public void execute(String goodsNum, HttpSession session, 
			Model model) {
		String userId = ((AuthInfo)session.getAttribute("authInfo")).getUserId();
		WishDTO dto = new WishDTO();
		dto.setGoodsNum(goodsNum);
		dto.setMemberNum(memberShipMapper.selectMember(userId).getMemberNum());
		model.addAttribute("wish", cornerRepository.wishCount(dto));
	}
}