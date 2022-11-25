package controller.goods;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;

public class GoodsAutoNumController {
	public void execute(HttpServletRequest request) {
		GoodsDAO dao = new GoodsDAO();
		String goodsNum = dao.goodsAutoNum();
		request.setAttribute("goodsNum", goodsNum);
	}
}
