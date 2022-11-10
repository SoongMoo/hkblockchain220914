package controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.BoardDTO;
import model.DAO.BoardDAO;

public class BoradListController {
	public void execute(HttpServletRequest request) {
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.selectAll();
		request.setAttribute("lists", list);
	}
}
