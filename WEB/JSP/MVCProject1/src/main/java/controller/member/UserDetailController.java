package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.AuthInfo;
import model.MemberDTO;
import model.DAO.MemberDAO;

public class UserDetailController {
	public void execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo =  (AuthInfo) session.getAttribute("authInfo");
		String userId = authInfo.getUserId();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.selectId(userId);
		request.setAttribute("dto", dto);	
	}
}
