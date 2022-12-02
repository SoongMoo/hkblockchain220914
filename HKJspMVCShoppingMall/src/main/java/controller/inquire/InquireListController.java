package controller.inquire;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.InquireDAO;
import model.DTO.InquireDTO;

public class InquireListController {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		InquireDAO dao = new InquireDAO();
		List<InquireDTO> list = dao.selectList(goodsNum);
		request.setAttribute("list", list);
		request.setAttribute("goodsNum", 
				request.getParameter("goodsNum"));
	}
}
