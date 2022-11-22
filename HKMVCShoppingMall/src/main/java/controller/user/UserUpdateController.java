package controller.user;

import javax.servlet.http.HttpServletRequest;

import model.DAO.MemberDAO;
import model.DAO.UserDAO;
import model.DTO.MemberDTO;

public class UserUpdateController {
	public void execute(HttpServletRequest request) {
		String memberId = request.getParameter("memberId");
		String memberPhone = request.getParameter("memberPhone");
		String memberAddr = request.getParameter("memberAddr");
		String memberEmail = request.getParameter("memberEmail");
		
		MemberDTO dto = new MemberDTO();
		dto.setMemberAddr(memberAddr);
		dto.setMemberEmail(memberEmail);
		dto.setMemberId(memberId);
		dto.setMemberPhone(memberPhone);
		
		UserDAO dao = new UserDAO();
		dao.memberUpdate(dto);
	}
}
