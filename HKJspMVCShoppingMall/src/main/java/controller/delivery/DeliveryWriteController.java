package controller.delivery;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemPurchaseDAO;

public class DeliveryWriteController {
	public void execute(HttpServletRequest request) {
		String purchaseNum = request.getParameter("purchaseNum");
		String deliveryNum = request.getParameter("deliveryNum");
		
		MemPurchaseDAO dao = new MemPurchaseDAO();
		dao.deliveryInsert(purchaseNum, deliveryNum);
	}
}
