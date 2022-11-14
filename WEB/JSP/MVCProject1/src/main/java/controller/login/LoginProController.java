package controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AuthInfo;
import model.DAO.LoginDAO;

public class LoginProController {
	public void execute(HttpServletRequest request,
			HttpServletResponse response) 
					throws IOException, ServletException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		LoginDAO dao = new LoginDAO();
		AuthInfo authInfo =  dao.loginCk(userId);
		if(authInfo != null) {
		/// 사용자 있는 경우
			if(!authInfo.getUserPw().equals(userPw)) {
				// userId는 존재하고 비밀번호가 틀렸을 때
				request.setAttribute("userId", userId);
				request.setAttribute("errPw", "비밀번호가 틀렸습니다.");
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
			}else {
				// userId와 userPw가 일치 할때만 session,에 저장
				HttpSession session = request.getSession();
				session.setAttribute("authInfo", authInfo);
				
				response.sendRedirect(
						request.getContextPath() +"/");
			}
		}else {
		/// 사용자가 없는 경우 : userId가 존재하지 않는다.
			request.setAttribute("errId", "userID가 존재하지 않습니다.");
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}
}