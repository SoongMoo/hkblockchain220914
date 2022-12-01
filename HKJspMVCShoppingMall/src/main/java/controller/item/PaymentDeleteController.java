package controller.item;

import javax.servlet.http.HttpServletRequest;

import model.DAO.ItemDAO;

public class PaymentDeleteController {
	public void execute(HttpServletRequest request) {
		String purchaseNum = request.getParameter("purchaseNum");
		
		ItemDAO dao = new ItemDAO();
		dao.paymentDelete(purchaseNum);
	}
}
