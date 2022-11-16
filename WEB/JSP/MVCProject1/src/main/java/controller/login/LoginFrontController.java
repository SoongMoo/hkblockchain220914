package controller.login;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFrontController extends HttpServlet 
	implements Servlet{
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = 
				requestURI.substring(contextPath.length());
		if(command.equals("/hklogin.login")) {
			LoginProController action = 
					new LoginProController();
			action.execute(request, response);
		}else if(command.equals("/hklogout.login")) {
			// 쿠키 삭제
			Cookie cookie = new Cookie("autoLogin","");
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect(contextPath + "/");
		}
	}
	@Override
	protected void doPost(HttpServletRequest requset, 
			HttpServletResponse response) throws ServletException, IOException {

	}
}
