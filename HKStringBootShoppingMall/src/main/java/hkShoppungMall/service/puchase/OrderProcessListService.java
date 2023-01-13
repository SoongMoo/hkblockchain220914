package hkShoppungMall.service.puchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.MemberDTO;
import hkShoppungMall.domain.PaymentPurchaseGoodsDTO;
import hkShoppungMall.mapper.MemberShipMapper;
import hkShoppungMall.repository.PuchaseRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class OrderProcessListService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	PuchaseRepository puchaseRepository;
	public void execute(Model model, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		MemberDTO memberDTO = memberShipMapper.selectMember(authInfo.getUserId());
		List<PaymentPurchaseGoodsDTO> list = puchaseRepository.purchaseList(memberDTO.getMemberNum());
		model.addAttribute("list", list);
	}
}
