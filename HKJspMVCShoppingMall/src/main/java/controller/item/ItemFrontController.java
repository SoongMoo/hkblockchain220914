package controller.item;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ItemFrontController extends HttpServlet 
	implements Servlet{
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/detailView.item")) {
			DetailViewController action =
					new DetailViewController();
			action.execute(request);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("item/detailView.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/cart.item")) {
			CartInsertController action =
					new CartInsertController();
			action.execute(request);
		}else if(command.equals("/cartList.item")) {
			CartListController action = 
					new CartListController();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("item/cartList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/cartQtyDown.item")) {
			CartQtyDownController action =
					new CartQtyDownController();
			action.execute(request);
			response.sendRedirect("cartList.item");
		}else if(command.equals("/cartItemDel.item")) {
			CartItemDeleteController action =
					new CartItemDeleteController();
			action.execute(request);
			response.sendRedirect("cartList.item");
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
