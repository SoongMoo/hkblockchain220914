package controller.delivery;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemPurchaseDAO;
import model.DTO.BuyListDTO;

public class MemPurchaseListController {
	public void execute(HttpServletRequest request) {
		MemPurchaseDAO dao = new MemPurchaseDAO();
		List<BuyListDTO> list = dao.buySelect();
		request.setAttribute("list", list);
	}
}
