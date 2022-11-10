package controller.goods;

import javax.servlet.http.HttpServletRequest;

import model.GoodsDTO;
import model.DAO.GoodsDAO;

public class GoodsDetailController {
	public void execute(HttpServletRequest request) {
		String num = request.getParameter("num");
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dto = dao.selectOne(num);
		System.out.println(num);
		request.setAttribute("goods", dto);
	}
}
