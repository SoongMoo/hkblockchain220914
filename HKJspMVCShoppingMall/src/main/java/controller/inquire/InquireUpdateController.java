package controller.inquire;

import javax.servlet.http.HttpServletRequest;

import model.DAO.InquireDAO;

public class InquireUpdateController {
	public void execute(HttpServletRequest request) {
		String inquireNum = request.getParameter("inquireNum");
		String inquireSubject= request.getParameter("inquireSubject");
		String inquireContent= request.getParameter("inquireContent");
		
		InquireDAO dao = new InquireDAO();
		dao.inquireUpdate(inquireNum,inquireSubject,inquireContent);
	}
}
