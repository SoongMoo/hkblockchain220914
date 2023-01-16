package hkShoppungMall.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.repository.DeliveryRepository;
import hkShoppungMall.repository.PuchaseRepository;

@Service
public class DeliveryDeleteService {
	@Autowired
	DeliveryRepository deliveryRepository;
	@Autowired
	PuchaseRepository puchaseRepository;
	public void execute(String purchaseNum) {
		int i = deliveryRepository.deliveryDelete(purchaseNum);
		if(i >= 0)puchaseRepository.purchaseStatus(purchaseNum);
	}
}	
