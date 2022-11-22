package controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.UserDAO;
import model.DTO.AuthInfo;
import model.DTO.MemberDTO;

public class UserDetailController {
	public void execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo dto = (AuthInfo)session.getAttribute("dto");
		String memberId = dto.getUserId();
		UserDAO dao = new UserDAO();
		MemberDTO dto1 = dao.selectOne(memberId);
		request.setAttribute("memVO", dto1);
	}
}
