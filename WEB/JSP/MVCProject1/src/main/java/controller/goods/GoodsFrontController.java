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
			RequestDispatcher dispatcher = request.getRequestDispatcher("goods/goodsList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsWrite.goods")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("goods/goodsForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsRegist.goods")) {
			GoodsRegistController action = new GoodsRegistController();
			action.execute(request);
			response.sendRedirect("goodsList.goods");
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}


}
