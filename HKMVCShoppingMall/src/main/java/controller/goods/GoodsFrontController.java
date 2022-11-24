package controller.goods;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoodsFrontController extends HttpServlet 
	implements Servlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		// 전체리스트 2 
		if(command.equals("/goodsList.goods")) {
			GoodsListController action =
					new GoodsListController();
			action.execute(request);
			RequestDispatcher dispatcher =
				request.getRequestDispatcher("goods/goodsList.jsp");
			dispatcher.forward(request, response);
		}//  상품 등록 1
		else if(command.equals("/goodsWrite.goods")) {
			RequestDispatcher dispatcher =
				request.getRequestDispatcher("goods/goodsForm.jsp");
			dispatcher.forward(request, response);			
		}else if(command.equals("/goodsRegist.goods")) {
			GoodsWriteController action = 
					new GoodsWriteController();
			action.execute(request);
			response.sendRedirect("goodsList.goods");
		}else if(command.equals("/goodsDetail.goods")) {
			GoodsDetailController action =
					new GoodsDetailController();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("goods/goodsInfo.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsUpdate.goods")) {
			GoodsDetailController action =
					new GoodsDetailController();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("goods/goodsModify.jsp");
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
