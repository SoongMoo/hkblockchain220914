package controller.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFrontController extends HttpServlet 
	implements Servlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		System.out.println("sb gfvkjsbdgkjvsadg");
		if(command.equals("/login.login")) {
			UserLoginContoller action = new UserLoginContoller();
			action.execte(request);
			response.sendRedirect(request.getContextPath()+"/");
		}else if(command.equals("/logout.login")) {
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect(request.getContextPath()+"/");
		}else if(command.equals("/loginCk.login")) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/login1.login")) {
			UserLoginContoller action = new UserLoginContoller();
			action.execte(request);
			PrintWriter out = response.getWriter();
			response.setContentType("text/html; charset=utf-8");
			String str =  "<script language='javascript'>"
					   +  "     opener.document.location.reload();"
			           +  " 	window.self.close();"
			           +  "</script>";
			out.print(str);
			out.close();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException {
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
}
