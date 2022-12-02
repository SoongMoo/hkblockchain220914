package controller.item;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DTO.PurchaseDTO;

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
		}else if(command.equals("/cartItemsDel.item")) {
			CartItemsDeleteController action = 
					new CartItemsDeleteController();
			action.execute(request);
			response.sendRedirect("cartList.item");
		}else if(command.equals("/itemBuy.item")) {
			GoodsItemController action =
					new GoodsItemController();
			action.execute(request);
			
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("item/goodsOrder.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/goodsOrder.item")) {
			PurchaseController action =
					new PurchaseController();
			PurchaseDTO dto = action.execute(request);
			response.sendRedirect("paymentOk.item?"
					+ "purchaseNum=" + dto.getPuchaseNum());
		}else if(command.equals("/purchaseList.item")) {
			PurchaseListController action =
					new PurchaseListController();
			action.execute(request);
			
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("item/purchaseList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/paymentOk.item")) {
			ItemTotalPriceConteroller action =
					new ItemTotalPriceConteroller();
			action.execute(request);
			
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("item/payment.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/doPayment.item")) {
			PaymentController action =
					new PaymentController();
			action.execute(request);
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("item/buyfinished.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/paymentDelete.item")) {
			PaymentDeleteController action =
					new PaymentDeleteController();
			action.execute(request);
			response.sendRedirect("purchaseList.item");
		}else if(command.equals("/wishItem.item")) {
			GoodsWishItemController action =
					new GoodsWishItemController();
			action.execute(request);
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
