package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.UserDAO;
import model.DTO.AuthInfo;

public class UserDeleteController {
	public int execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
		String memberId =  authInfo.getUserId();
		String memberPw =  request.getParameter("userPw");
		UserDAO dao = new UserDAO();
		int i = dao.memberDelete(memberId,memberPw );
		return i;
	}
}
