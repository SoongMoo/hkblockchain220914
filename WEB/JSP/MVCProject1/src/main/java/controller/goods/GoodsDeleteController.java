package controller.goods;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;

public class GoodsDeleteController {
	public void execute(HttpServletRequest request) {
		String num = request.getParameter("num");
		GoodsDAO dao = new GoodsDAO();
		dao.goodsDelete(num);
	}
}
