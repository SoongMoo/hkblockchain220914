package controller.inquire;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.DAO.InquireDAO;
import model.DTO.InquireDTO;

public class InquireListEmp {
	public void execute(HttpServletRequest request) {
		InquireDAO dao = new InquireDAO();
		List<InquireDTO> list = dao.inquireSelectAll(); 
		request.setAttribute("list", list);
	}
}
