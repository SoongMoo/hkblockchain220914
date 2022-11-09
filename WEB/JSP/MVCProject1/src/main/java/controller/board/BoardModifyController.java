package controller.board;

import javax.servlet.http.HttpServletRequest;

import model.BoardDTO;
import model.DAO.BoardDAO;

public class BoardModifyController {
	public void execute(HttpServletRequest request) {
		String boardNum = request.getParameter("boardNum");
		String boardWriter = request.getParameter("boardWriter");
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		BoardDTO dto = new BoardDTO();
		dto.setBoardContent(boardContent);
		dto.setBoardNum(Integer.parseInt(boardNum));
		dto.setBoardSubject(boardSubject);
		dto.setBoardWriter(boardWriter);
		BoardDAO dao = new BoardDAO();
		dao.boardUpdate(dto);
	}
}
