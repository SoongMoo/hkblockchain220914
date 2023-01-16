package hkShoppungMall.service.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.domain.DeliveryDTO;
import hkShoppungMall.repository.DeliveryRepository;
import hkShoppungMall.repository.PuchaseRepository;

@Service
public class DeliveryActionService {
	@Autowired
	DeliveryRepository deliveryRepository ;
	@Autowired
	PuchaseRepository puchaseRepository;
	public void execute(String purchaseNum, String deliveryCompany, String deliveryNumber) {
		DeliveryDTO dto = new DeliveryDTO();
		dto.setDeliveryCompany(deliveryCompany);
		dto.setDeliveryNumber(deliveryNumber);
		dto.setPurchaseNum(purchaseNum);
		int i = deliveryRepository.deliveryInsert(dto);
		if(i >= 0) {
			puchaseRepository.deliveryStatus(purchaseNum);
		}
		
	}
}
