package controller.delivery;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemPurchaseDAO;
import model.DTO.DeliveryDTO;

public class DeliveryUpdateController {
	public void execute(HttpServletRequest request) {
		String deliveryNum = request.getParameter("deliveryNum");
		String purchaseNum = request.getParameter("purchaseNum");
		String deliveryState = request.getParameter("deliveryState");
		DeliveryDTO dto = new DeliveryDTO();
		dto.setDeliveryNum(Long.parseLong(deliveryNum));
		dto.setPurchaseNum(Long.parseLong(purchaseNum));
		dto.setDeliveryState(deliveryState);
		
		MemPurchaseDAO dao = new MemPurchaseDAO();
		dao.deliveryUpdate(dto);
	}
	
}
