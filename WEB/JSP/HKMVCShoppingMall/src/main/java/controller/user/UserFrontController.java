package controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.member.MemberWriteController;

public class UserFrontController extends HttpServlet 
	implements Servlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = 
				requestURI.substring(contextPath.length());
		if(command.equals("/userAgree.nhn")) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("user/userAgree.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/userWrite.nhn")) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("user/userForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/userRegist.nhn")) {
			/// insert 
			UserWriteController action = 
					new UserWriteController();
			action.execute(request);
			response.sendRedirect(request.getContextPath()+"/");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	
}
