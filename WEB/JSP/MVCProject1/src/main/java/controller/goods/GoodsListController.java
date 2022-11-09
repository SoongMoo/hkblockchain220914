package controller.goods;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.GoodsDTO;
import model.DAO.GoodsDAO;

public class GoodsListController {
	public void execute(HttpServletRequest request) {
		 GoodsDAO dao = new GoodsDAO();
		 List<GoodsDTO> list = dao.selectAll();
		 request.setAttribute("lists", list);
	}
}
