package controller.member;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;



public class MemberDeleteController {
	public void execute(HttpServletRequest request) {
		 String memberNum = request.getParameter("memberNum");
		 MemberDAO dao = new MemberDAO();
		 dao.memberDelete(memberNum);
	}
}
