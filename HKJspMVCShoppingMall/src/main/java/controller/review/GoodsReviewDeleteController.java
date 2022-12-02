package controller.review;

import javax.servlet.http.HttpServletRequest;

import model.DAO.ReviewDAO;

public class GoodsReviewDeleteController {
	public void execute(HttpServletRequest request) {
		String reviewNum = request.getParameter("reviewNum");
		ReviewDAO dao = new ReviewDAO();
		dao.reviewDelete(reviewNum);
	}
}
