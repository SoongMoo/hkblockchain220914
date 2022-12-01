package controller.item;

import javax.servlet.http.HttpServletRequest;

import model.DAO.ItemDAO;

public class ItemTotalPriceConteroller {
	public void execute(HttpServletRequest request) {
		String purchaseNum = 
				request.getParameter("purchaseNum");
		ItemDAO itemDAO = new ItemDAO();
		int totalPrice = itemDAO.totalPrice(purchaseNum);
		request.setAttribute("purchaseNum", purchaseNum);
		request.setAttribute("totalPrice", totalPrice);
	}
}
