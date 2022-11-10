package controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardFrontController extends HttpServlet       
			implements javax.servlet.Servlet{
	@Override
	protected void doGet(HttpServletRequest request, // 매개변수 
			HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		System.out.println(requestURI); // console
		System.out.println(contextPath);
		System.out.println(request.getRequestURL());
		/// http://localhost:8080/MVCProject1/boardList.board --url
		//                       <--------------------------> uri
		//                       <---------->                contextPath
		//  requestURI = "/MVCProject1/boardList.board"
		//  contextPath = "/MVCProject1" 
		System.out.println(contextPath.length());
		//  command = requestURI.substring(12)
		//  command = requestURI.substring(contextPath.length())
		//  command = "/boardList.board"
		if(command.equals("/boardList.board")) {
			BoradListController action = new BoradListController();
			action.execute(request);
			RequestDispatcher dispatcher =     
	                    request.getRequestDispatcher("/board/boardList.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardWrite.board")) {
			RequestDispatcher dispatcher =     
	                 request.getRequestDispatcher("/board/boardForm.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardRegist.board")) {
			// 같은 경로에서 이동을 하는 경우에는 "/" 안 붙여줘도 된다.
			BoardWriteContoller action = new BoardWriteContoller();
			action.execute(request);
			response.sendRedirect("boardList.board");
		}else if(command.equals("/boardDetail.board")) {
			BoardDetailController action = new BoardDetailController();
			action.execute(request);
			RequestDispatcher dispatcher =     
	                 request.getRequestDispatcher("/board/boardInfo.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardUpdate.board")) {
			BoardDetailController action = new BoardDetailController();
			action.execute(request);
			RequestDispatcher dispatcher =     
	                 request.getRequestDispatcher("/board/boardModify.jsp");
			dispatcher.forward(request, response);
		}else if(command.equals("/boardModify.board")) {
			BoardModifyController action = new BoardModifyController();
			action.execute(request);
			response.sendRedirect("boardDetail.board?num="+request.getParameter("boardNum"));
		}else if(command.equals("/boardDel.board")) {
			BoardDelController action = new BoardDelController();
			action.execute(request);
			response.sendRedirect("boardList.board");
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
