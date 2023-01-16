package hkShoppungMall.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.repository.DeliveryRepository;

@Service
public class DeliveryOKService {
	@Autowired
	DeliveryRepository deliveryRepository;
	public void execute(String purchaseNum) {
		deliveryRepository.deliveryUpdate(purchaseNum);
	}
}
