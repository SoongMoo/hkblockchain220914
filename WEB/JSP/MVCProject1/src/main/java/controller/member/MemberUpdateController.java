package controller.member;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.MemberDTO;
import model.DAO.MemberDAO;

public class MemberUpdateController {
	public void execute(HttpServletRequest request) {
		String memNum = request.getParameter("memNum");
		String memName = request.getParameter("memName");
		String memGender = request.getParameter("memGender");
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		String memPhone1 = request.getParameter("memPhone1");
		String memPhone2 = request.getParameter("memPhone2");
		String memAddr = request.getParameter("memAddr");
		String memEmail = request.getParameter("memEmail");
		
		String memBirth = request.getParameter("memBirth");
		String birth[] =  memBirth.split("T");
		String memRegiDate = request.getParameter("memRegiDate");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date birthDay = null;
		Date regiDate = null;
		try {
			birthDay = sdf.parse(birth[0]);
			regiDate= sdf.parse(memRegiDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MemberDTO dto = new MemberDTO();
		dto.setMemAddr(memAddr);
		dto.setMemBirth(birthDay);
		dto.setMemEmail(memEmail);
		dto.setMemGender(memGender);
		dto.setMemId(memId);
		dto.setMemName(memName);
		dto.setMemNum(memNum);
		dto.setMemPhone1(memPhone1);
		dto.setMemPhone2(memPhone2);
		dto.setMemPw(memPw);
		dto.setMemRegiDate(regiDate);
		
		MemberDAO dao = new MemberDAO();
		dao.memberUpdate(dto);
	}
}
