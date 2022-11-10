package controller.goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodsFrontController extends HttpServlet implements Servlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/goodsList.goods")) {
			GoodsListController action = new GoodsListController();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("goods/goodsList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsWrite.goods")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("goods/goodsForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsRegist.goods")) {
			GoodsRegistController action = new GoodsRegistController();
			action.execute(request);
			response.sendRedirect("goodsList.goods");
		}else if(command.equals("/goodsDetail.goods")) {
			GoodsDetailController action = new GoodsDetailController();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("goods/goodsDetail.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsUpdate.goods")) {
			GoodsDetailController action = new GoodsDetailController();
			action.execute(request);
			RequestDispatcher dispatcher = request.getRequestDispatcher("goods/goodsModify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsModify.goods")) {
			GoodsModifyController action = new GoodsModifyController();
			action.execute(request);
			response.sendRedirect("goodsDetail.goods?num="+request.getParameter("goodsNum"));
		}else if(command.equals("/goodsDelete.goods")) {
			GoodsDeleteController action = new GoodsDeleteController();
			action.execute(request);
			response.sendRedirect("goodsList.goods");
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}


}
