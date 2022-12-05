package controller.inquire;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.EmployeeDAO;
import model.DAO.InquireDAO;
import model.DAO.UserDAO;
import model.DTO.AuthInfo;
import model.DTO.EmployeeDTO;

public class InquireRepleUpdateController {
	public void execute(HttpServletRequest request) {
		String inquireNum = request.getParameter("inquireNum");
		String answerReply = request.getParameter("answerReply");
		
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");

		
		InquireDAO dao= new InquireDAO();
		dao.inquireReplyUpdate(inquireNum,  answerReply,authInfo.getUserId() );
	}
}
