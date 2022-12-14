package controller.inquire;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.goods.GoodsDetailController;
import model.DAO.InquireDAO;

public class InquireFrontController  extends HttpServlet 
implements Servlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/inquireList.inq")) {
			InquireListController action =
					new InquireListController();
			action.execute(request);
			
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("inquire/inquireList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/inquireWrite.inq")) {
			GoodsDetailController action = 
					new GoodsDetailController();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("inquire/inquireWrite.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/inquireWritePro.inq")) {
			InquireWriteProController action =
					new InquireWriteProController();
			action.execute(request);
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String str=  "<script language='javascript'>" 
					  +  " opener.parent.inquire();"
			          +  " window.self.close();"
			          +  "</script>";
			 out.print(str);
			 out.close();
		}else if(command.equals("/inquireUpdate.inq")) {
			InquireDetailController action = 
					new InquireDetailController();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("inquire/inquireUpdate.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/inquireModify.inq")) {
			InquireUpdateController action =
					new InquireUpdateController();
			action.execute(request);
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			String str=  "<script language='javascript'>" 
					  +  " opener.parent.inquire();"
			          +  " window.self.close();"
			          +  "</script>";
			 out.print(str);
			 out.close();
		}else if(command.equals("/inquireDelete.inq")) {
			String inquireNum = request.getParameter("inquireNum");
			InquireDAO dao = new InquireDAO();
			dao.inquireDelete(inquireNum);
		}else if(command.equals("/inquire.inq")) {
			InquireListEmp action = new InquireListEmp();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("inquire/inquireListEmp.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/inquireUpdateEmp.inq")) {
			InquireDetailController action = 
					new InquireDetailController();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("inquire/inquireUpdateEmp.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/inquireRepleUpdate.inq")) {
			InquireRepleUpdateController action =
					new InquireRepleUpdateController();
			action.execute(request);
			response.sendRedirect(
					"inquireUpdateEmp.inq?inquireNum="
					+request.getParameter("inquireNum"));
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
