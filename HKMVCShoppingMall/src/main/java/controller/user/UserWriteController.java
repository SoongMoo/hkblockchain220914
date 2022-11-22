package controller.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.DAO.UserDAO;
import model.DTO.MemberDTO;

public class UserWriteController {
	public void execute(HttpServletRequest request) {
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String memberPhone = request.getParameter("memberPhone");
		String memberAddr = request.getParameter("memberAddr");
		String memberEmail = request.getParameter("memberEmail");
		String memberBirth = request.getParameter("memberBirth");
		String memberGender = request.getParameter("memberGender");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date date = null;
		try {
			date = sdf.parse(memberBirth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MemberDTO dto = new MemberDTO();
		dto.setMemberAddr(memberAddr);
		dto.setMemberBirth(date);
		dto.setMemberEmail(memberEmail);
		dto.setMemberGender(memberGender);
		dto.setMemberId(memberId);
		dto.setMemberName(memberName);
		dto.setMemberPhone(memberPhone);
		dto.setMemberPw(memberPw);
	
		UserDAO dao = new UserDAO();
		dao.userInsert(dto);		
	}
}
