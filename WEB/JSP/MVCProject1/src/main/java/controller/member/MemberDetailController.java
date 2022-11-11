package controller.member;

import javax.servlet.http.HttpServletRequest;

import model.MemberDTO;
import model.DAO.MemberDAO;

public class MemberDetailController {
	public void execute(HttpServletRequest request) {
		String num= request.getParameter("num");
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectOne(num);
		request.setAttribute("memberDTO", dto);
	}
}
