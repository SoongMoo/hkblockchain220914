package controller.review;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.ReviewDAO;
import model.DTO.ReviewDTO;

public class ReviewListController {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		ReviewDAO dao = new ReviewDAO();
		List<ReviewDTO> list = dao.selectAll(goodsNum);
		request.setAttribute("list", list);
	}
}