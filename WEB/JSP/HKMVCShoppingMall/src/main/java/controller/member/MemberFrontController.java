package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberFrontController extends HttpServlet 
		implements Servlet{
	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/memberList.mem")) {
			// 전체보기
			MemberListController action =
					new MemberListController();
			action.execute(request);
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher("member/memberList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberWrite.mem")) {
			/// insert 
			RequestDispatcher dispatcher =
				request.getRequestDispatcher("member/memberForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberRegist.mem")) {
			/// insert 
			MemberWriteController action = 
					new MemberWriteController();
			action.execute(request);
			response.sendRedirect("memberList.mem");
		}else if(command.equals("/memberDetail.mem")) {
			//상세보기
			MemberDetailController action = 
					new MemberDetailController();
			action.execute(request);
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher("member/memberInfo.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberUpdate.mem")) {
			// update
			MemberDetailController action = 
					new MemberDetailController();
			action.execute(request);
			RequestDispatcher dispatcher =
				request.getRequestDispatcher("member/memberModify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/memberModify.mem")) {
			// update
			MemberUpdateController action =
					new MemberUpdateController();
			action.execute(request);
			response.sendRedirect("memberDetail.mem?memberNum="
					+ request.getParameter("memberNum"));
		}else if(command.equals("/memberdelete.mem")) {
			// 삭제
			MemberDeleteController action = 
					new MemberDeleteController();
			action.execute(request);
			response.sendRedirect("memberList.mem");
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
