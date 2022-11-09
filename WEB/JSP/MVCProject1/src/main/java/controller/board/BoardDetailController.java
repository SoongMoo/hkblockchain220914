package controller.board;

import javax.servlet.http.HttpServletRequest;

import model.BoardDTO;
import model.DAO.BoardDAO;

public class BoardDetailController {
	public void execute(HttpServletRequest request) {
		String num = request.getParameter("num");
		BoardDAO dao = new BoardDAO();
		dao.visitCount(num);
		BoardDTO dto = dao.selectOne(num);
		request.setAttribute("dto", dto);
	}
}