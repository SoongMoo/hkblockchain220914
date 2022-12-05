package controller.inquire;

import javax.servlet.http.HttpServletRequest;

import model.DAO.InquireDAO;
import model.DTO.InquireDTO;

public class InquireDetailController {
	public void execute(HttpServletRequest request) {
		String inquireNum = request.getParameter("inquireNum");
		InquireDAO dao = new InquireDAO();
		InquireDTO dto = dao.selectOne(inquireNum);
		request.setAttribute("dto", dto);
	}
}
