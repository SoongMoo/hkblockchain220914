package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/// 자바에서 웹 프로그램을 만들 때 servlet으로 만들다,
// HttpServlet상속을 받으므로 MemberServlet이 HttpServlet이 되었다.
public class MemberServlet extends HttpServlet{
	@Override
	protected void doGet (HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String str = request.getParameter("forward");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		if(str.equals("main")) {  // html코드
			out.print("<!DOCTYPE html>");
			out.print("<html><head>");
			out.print("<meta charset='UTF-8'>");
			out.print("<title>servlet</title>");
			out.print("</head><body>");
			out.print("<a href='search?forward=next'>다음 페이지</a>");
			out.print("</body></html>");
		}else if(str.equals("next")) {
			out.print("<!DOCTYPE html>");
			out.print("<html><head>");
			out.print("<meta charset='UTF-8'>");
			out.print("<title>servlet</title>");
			out.print("</head><body>");
			out.print("다음페이지입니다.");
			out.print("</body></html>");
		}
	}
}
