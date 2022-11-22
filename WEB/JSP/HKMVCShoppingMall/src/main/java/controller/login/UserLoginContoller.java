package controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.LoginDAO;
import model.DTO.AuthInfo;

public class UserLoginContoller {
	public void execte(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		LoginDAO dao = new LoginDAO();
		AuthInfo dto = dao.selectOne(userId);
		HttpSession session = request.getSession();
		session.setAttribute("dto", dto);
	}
}
