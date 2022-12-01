package controller.delivery;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemPurchaseDAO;
import model.DTO.DeliveryDTO;

public class DeliveryModifyController {
	public void execute(HttpServletRequest request) {
		String purchaseNum = request.getParameter("purchaseNum");
		MemPurchaseDAO dao = new MemPurchaseDAO();
		DeliveryDTO dto = dao.selectOne(purchaseNum);
		request.setAttribute("dto", dto);
	}
}
