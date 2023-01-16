package hkShoppungMall.service.puchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.repository.PuchaseRepository;

@Service
public class PaymentDelService {
	@Autowired
	PuchaseRepository puchaseRepository;
	public void execute(String purchaseNum) {
		int i = puchaseRepository.paymentDelete(purchaseNum);
		if(i >= 1) {
			puchaseRepository.purchaseStatusBack(purchaseNum);
		}
	}
}
