package controller.empuser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpUserFrontcontroller extends HttpServlet 
	implements Servlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/empMyPage.naver")) {
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher("empMyPage.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empInfo.naver")) {
			EmpDetailController action =
					new EmpDetailController();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("empMyPage/empDetail.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empUpdate.naver")) {
			EmpDetailController action =
					new EmpDetailController();
			action.execute(request);
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher("empMyPage/empUptForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empModify.naver")) {
			EmpModifyController action =
					new EmpModifyController();
			action.execute(request);
			response.sendRedirect("empInfo.naver");
		}else if(command.equals("/empPassword.naver")) {
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("empMyPage/empPwCon.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/empPwCon.naver")) {
			EmpPasswordConController action =
					new EmpPasswordConController();
			String ck = action.execute(request);
			if(ck != null) {
				RequestDispatcher dispatcher = 
					request.getRequestDispatcher("empMyPage/empNewPw.jsp");
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("empMyPage/empPwCon.jsp");
				dispatcher.forward(request, response);
			}
		}else if(command.equals("/empPasswordPro.naver")) {
			EmpPasswordController action =
					new EmpPasswordController();
			action.execute(request);
			response.sendRedirect("empInfo.naver");
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
