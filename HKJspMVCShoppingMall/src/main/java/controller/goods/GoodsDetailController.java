package controller.goods;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;
import model.DTO.GoodsDTO;

public class GoodsDetailController {
	public void execute(HttpServletRequest request) {
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dto = dao.selectOne(request.getParameter("goodsNum"));
		request.setAttribute("dto", dto);
	}
}
