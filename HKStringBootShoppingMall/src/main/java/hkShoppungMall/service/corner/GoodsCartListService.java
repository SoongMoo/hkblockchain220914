package hkShoppungMall.service.corner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.CartGoodsDTO;
import hkShoppungMall.domain.MemberDTO;
import hkShoppungMall.mapper.MemberShipMapper;
import hkShoppungMall.repository.CornerRepository;
import jakarta.servlet.http.HttpSession;
@Service
public class GoodsCartListService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	CornerRepository cornerRepository;
	public String execute( Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		if(authInfo.getGrade().equals("emp")) {
			return "redirect:/";
		}
		MemberDTO dto = memberShipMapper.selectMember(authInfo.getUserId());
		List<CartGoodsDTO> list = cornerRepository.cartList(dto.getMemberNum());
		model.addAttribute("list", list);
		return "thymeleaf/corner/cartList";
	}
}