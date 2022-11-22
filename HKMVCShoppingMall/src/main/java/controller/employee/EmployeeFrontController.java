package controller.employee;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeFrontController extends HttpServlet 
	implements Servlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/employeeList.emp")) {
			/// 전체보기
			EmployeeListController action = 
					new EmployeeListController();
			action.execute(request);
			
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("employee/employeeList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/employeeJoin.emp")) {
			// insert
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("employee/employeeForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/employeeJoinOk.emp")) {
			//insert
			EmplouyeeJoinController action =
					new EmplouyeeJoinController();
			action.execute(request);
			response.sendRedirect("employeeList.emp");
		}else if(command.equals("/employeeDetail.emp")) {
			// 상세보기
			EmployeeDetailController action =
					new EmployeeDetailController();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("employee/employeeDetail.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/employeeUpdate.emp")) {
			// update
			EmployeeDetailController action =
					new EmployeeDetailController();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("employee/employeeModify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/employeeModify.emp")) {
			//update
			EmployeeModifyController action = new EmployeeModifyController();
			action.execute(request);
			response.sendRedirect("employeeDetail.emp?num="+request.getParameter("employeeNum"));
		}else if(command.equals("/employeedelete.emp")) {
			// delete
			EmployeeDeleteController action = new EmployeeDeleteController();
			action.execute(request);
			response.sendRedirect("employeeList.emp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI= request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/employeeModify.emp")) {
			EmployeeModifyController action = new EmployeeModifyController();
			action.execute(request);
			response.sendRedirect("employeeDetail.emp?num="+request.getParameter("employeeNum"));
		}
	}
}
