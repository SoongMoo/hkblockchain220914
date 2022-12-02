package controller.review;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReviewFrontController  extends HttpServlet 
implements Servlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/revireRegist.review")) {
			request.setAttribute("goodsNum", 
					request.getParameter("goodsNum"));
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("review/reviewForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/reviewWrite.review")) {
			ReviewWriteController action = 
					new ReviewWriteController();
			action.execute(request);
			response.sendRedirect("purchaseList.item");
		}else if(command.equals("/goodsReviewUpdate.review")) {
			ReviewDetailController action =	new ReviewDetailController();
			action.execute(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("review/reviewModify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsReviewModify.review")) {
			GoodsReviewUpdateController action =
					new GoodsReviewUpdateController();
			action.execute(request);
			response.sendRedirect("purchaseList.item");
		}else if(command.equals("/goodsReviewDelete.review")) {
			GoodsReviewDeleteController action =
					new GoodsReviewDeleteController();
			action.execute(request);
			response.sendRedirect("purchaseList.item");
		}else if(command.equals("/reviewList.review")) {
			ReviewListController action = 
					new ReviewListController();
			action.execute(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("review/revieList.jsp");
			dispatcher.forward(request, response);
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
