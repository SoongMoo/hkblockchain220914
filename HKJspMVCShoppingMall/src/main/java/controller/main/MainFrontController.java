package controller.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.goods.GoodsListController;
import model.DTO.AuthInfo;

public class MainFrontController extends HttpServlet 
	implements Servlet{
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		if(command.equals("/main.main")) {
			GoodsListController action =
					new GoodsListController();
			action.execute(request);
			
			// 사용자가 가지고 있는 쿠키를 가지고 옴.
			Cookie [] cookies = request.getCookies();
			if(cookies != null && cookies.length > 0 ) {
				for(Cookie cookie : cookies) {
					System.out.println(cookie.getName());
					if(cookie.getName().equals("store")) {
						System.out.println(cookie.getValue());
						request.setAttribute("storeId", cookie.getValue());
					}
					if(cookie.getName().equals("autoLogin")) {
						HttpSession session = request.getSession();
						AuthInfo authInfo = new AuthInfo();
						authInfo.setUserId(cookie.getValue());
						session.setAttribute("dto", authInfo);
					}
				}
			}
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("main.jsp");
			dispatcher.forward(request, response);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
