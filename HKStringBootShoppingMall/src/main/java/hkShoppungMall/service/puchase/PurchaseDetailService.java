package hkShoppungMall.service.puchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.PurchaseDetailDTO;
import hkShoppungMall.repository.PuchaseRepository;

@Service
public class PurchaseDetailService {
	@Autowired
	PuchaseRepository puchaseRepository;
	public void execute(String purchaseNum , Model model) {
		List<PurchaseDetailDTO> list = puchaseRepository.purchaseDetail(purchaseNum);
		model.addAttribute("list", list);
	}
}
