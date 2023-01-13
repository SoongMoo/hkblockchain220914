package hkShoppungMall.service.puchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.CartDTO;
import hkShoppungMall.domain.CartGoodsDTO;
import hkShoppungMall.domain.MemberDTO;
import hkShoppungMall.mapper.MemberShipMapper;
import hkShoppungMall.repository.PuchaseRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsBuyService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	PuchaseRepository puchaseRepository;
	public void execute(String [] prodCk,HttpSession session, Model model) {
		AuthInfo authInfo =
				(AuthInfo)session.getAttribute("authInfo");
		MemberDTO memberDTO = memberShipMapper.selectMember(authInfo.getUserId());
		CartDTO cart = new CartDTO();
		cart.setGoodsNums(prodCk);
		cart.setMemberNum(memberDTO.getMemberNum());
		List<CartGoodsDTO> cartList = puchaseRepository.goodsOrder(cart);
		Long goodsTotalPrice = 0L;
		for(CartGoodsDTO cartGoodsDTO : cartList ) {
			goodsTotalPrice += cartGoodsDTO.getTotalPrice();
		}
		Long goodsTotalDelivery = 0L;
		for(CartGoodsDTO cartGoodsDTO : cartList ) {
			goodsTotalDelivery += cartGoodsDTO.getGoodsDTO().getDeliveryCost();
		}
		String goodsNums = "";
		for( String goodsNum :  prodCk) {
			goodsNums += goodsNum + "`";
		}
		model.addAttribute("cartList", cartList);
		model.addAttribute("goodsTotalPrice", goodsTotalPrice);
		model.addAttribute("goodsTotalDelivery", goodsTotalDelivery);
		model.addAttribute("goodsNums", goodsNums);
	}
}
