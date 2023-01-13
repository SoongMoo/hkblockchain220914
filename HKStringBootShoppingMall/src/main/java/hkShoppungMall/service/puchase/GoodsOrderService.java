package hkShoppungMall.service.puchase;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.command.PurchaseCommand;
import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.CartDTO;
import hkShoppungMall.domain.MemberDTO;
import hkShoppungMall.domain.PurchaseDTO;
import hkShoppungMall.domain.PurchaseListDTO;
import hkShoppungMall.mapper.MemberShipMapper;
import hkShoppungMall.repository.CornerRepository;
import hkShoppungMall.repository.PuchaseRepository;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsOrderService {
	@Autowired
	MemberShipMapper memberShipMapper;
	@Autowired
	PuchaseRepository puchaseRepository;
	@Autowired
	CornerRepository cornerRepository;
	public void execute(PurchaseCommand purchaseCommand, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		MemberDTO memberDTO = memberShipMapper.selectMember(authInfo.getUserId());
		Integer num = puchaseRepository.selectNum();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String purchaseNum = df.format(new Date()) + num;
		
		PurchaseDTO dto = new PurchaseDTO();
		dto.setMemberNum(memberDTO.getMemberNum());
		dto.setMessage(purchaseCommand.getMessage());
		dto.setDeliveryAddr(purchaseCommand.getPurchaseAddr());
		dto.setDeliveryPhone(purchaseCommand.getPurchasePhone());
		dto.setPurchaseStatus("결제대기중");
		dto.setRecieveName(purchaseCommand.getRecieveName());
		dto.setTotalPrice(purchaseCommand.getTotalPrice());
		dto.setPurchaseNum(purchaseNum);
		
		int i = puchaseRepository.purchaseInsert(dto);
		
		if(i == 1 ) {
			for(String goodsNum : purchaseCommand.getGoodsNums().split("`")) {
				PurchaseListDTO purchaseListDTO = new PurchaseListDTO();
				purchaseListDTO.setPurchaseNum(purchaseNum);
				purchaseListDTO.setGoodsNum(goodsNum);
				purchaseListDTO.setMemberNum(memberDTO.getMemberNum());
				puchaseRepository.purchaseListInsert(purchaseListDTO);
			}
			CartDTO cartDTO = new CartDTO();
			cartDTO.setGoodsNums(purchaseCommand.getGoodsNums().split("`"));
			cartDTO.setMemberNum(memberDTO.getMemberNum());
			cornerRepository.goodsCartDels(cartDTO);
		}
			
		
	}
}
