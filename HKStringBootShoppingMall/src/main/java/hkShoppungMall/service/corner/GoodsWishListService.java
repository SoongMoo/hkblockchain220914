package hkShoppungMall.service.corner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.GoodsDTO;
import hkShoppungMall.domain.MemberDTO;
import hkShoppungMall.mapper.MemberShipMapper;
import hkShoppungMall.repository.CornerRepository;
import jakarta.servlet.http.HttpSession;
@Service
public class GoodsWishListService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	CornerRepository cornerRepository;
	public void execute(HttpSession session, Model model) {
		AuthInfo authInfo  = (AuthInfo)session.getAttribute("authInfo");
		MemberDTO memDTO = memberShipMapper.selectMember(authInfo.getUserId());
		List<GoodsDTO> list = cornerRepository.goodsList(memDTO.getMemberNum());
		model.addAttribute("list", list);
	}
}
