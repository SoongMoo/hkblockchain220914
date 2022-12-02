package controller.review;

import javax.servlet.http.HttpServletRequest;

import model.DAO.ReviewDAO;
import model.DTO.ReviewDTO;

public class GoodsReviewUpdateController {
	public void execute(HttpServletRequest request) {
		String reviewNum = request.getParameter("reviewNum");
		String reviewSubject = request.getParameter("reviewSubject");
		String reviewContent = request.getParameter("reviewContent");
		ReviewDTO dto = new ReviewDTO();
		dto.setReviewNum(Integer.parseInt(reviewNum));
		dto.setReviewSubject(reviewSubject);
		dto.setReviewContent(reviewContent);
		ReviewDAO dao = new ReviewDAO();
		dao.reviewUpdate(dto);
	}
}
