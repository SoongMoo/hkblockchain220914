package controller.board;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.BoardDTO;

public class BoardWriteContoller {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {}

		///                  request.getParameter("input의 name을 적어준다.")
		String boardWriter = request.getParameter("boardWriter");
		String boardSubject = request.getParameter("boardSubject");
		String boardContent = request.getParameter("boardContent");
		                // 웹브라우저를 사용하는 사용자의 ip주
		String writerIP = request.getRemoteAddr();
		BoardDTO dto = new BoardDTO();
		dto.setBoardWriter(boardWriter);
		dto.setBoardSubject(boardSubject);
		dto.setBoardContent(boardContent);
		dto.setWriterIp(writerIP);
		
			
	}
}
