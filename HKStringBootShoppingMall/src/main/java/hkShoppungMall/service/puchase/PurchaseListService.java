package hkShoppungMall.service.puchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.PaymentPurchaseGoodsDTO;
import hkShoppungMall.repository.PuchaseRepository;

@Service
public class PurchaseListService {
	@Autowired
	PuchaseRepository puchaseRepository;
	public void execute(Model model) {
		
		List<PaymentPurchaseGoodsDTO> list = puchaseRepository.purchaseList(null);
		model.addAttribute("list" , list);
		
	}
}
