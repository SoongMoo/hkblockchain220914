package controller.review;

import javax.servlet.http.HttpServletRequest;

import model.DAO.ReviewDAO;
import model.DTO.ReviewDetailDTO;

public class ReviewDetailController {
	public void execute(HttpServletRequest request) {
		String reviewNum = request.getParameter("reviewNum");
		ReviewDAO dao = new ReviewDAO();
		ReviewDetailDTO dto = dao.reviewDetail(reviewNum);
		request.setAttribute("dto1", dto);
		////                  키     값
	}
}






