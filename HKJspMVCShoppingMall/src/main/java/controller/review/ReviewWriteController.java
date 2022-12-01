package controller.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ReviewDAO;
import model.DAO.UserDAO;
import model.DTO.AuthInfo;
import model.DTO.MemberDTO;

public class ReviewWriteController {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		String reviewSubject = request.getParameter("reviewSubject");
		String reviewContent = request.getParameter("reviewContent");
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
		UserDAO userDAO = new UserDAO();
		MemberDTO memDTO = userDAO.selectOne(authInfo.getUserId());
		String memberNum = memDTO.getMemberNum();
		ReviewDAO dao = new ReviewDAO();
		dao.reviewInsert(goodsNum,reviewSubject,reviewContent,memberNum  );
	}
}
