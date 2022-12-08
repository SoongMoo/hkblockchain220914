package controller.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO.LoginDAO;
import model.DTO.AuthInfo;

public class UserLoginContoller {
	public void execte(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		LoginDAO dao = new LoginDAO();
		AuthInfo dto = dao.selectOne(userId);
		HttpSession session = request.getSession();
		if(dto == null) {
			request.setAttribute("errId","아이디가 존재하지 않습니다.");
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("main.main");
			dispatcher.forward(request, response);
		}else {
			if(dto.getUserPw().equals(userPw)) {
				session.setAttribute("dto", dto);
				String storeId = request.getParameter("storeId");
				String keeplogin = request.getParameter("keeplogin");
				if(storeId != null && storeId.equals("store")) {
					System.out.println("쿠키생성");
					Cookie cookie = new Cookie("storeId",dto.getUserId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}else {
					System.out.println("쿠키삭제");
					Cookie cookie = new Cookie("storeId",dto.getUserId());
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
				if(keeplogin != null && keeplogin.equals("on")) {
					Cookie cookie = new Cookie("autoLogin",dto.getUserId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
					System.out.println(cookie.getName());
				}
				response.sendRedirect(request.getContextPath()+ "/");
			}else {
				request.setAttribute("errPw","비밀번호가 틀렸습니다.");
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("main.main");
				dispatcher.forward(request, response);
			}
		}
	}
}
