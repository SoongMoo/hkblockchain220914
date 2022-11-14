package controller.member;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.MemberDTO;
import model.DAO.MemberDAO;

public class MemberJoinController {
	public void execute(HttpServletRequest request) {
		String memName = request.getParameter("memName");
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		String memPhone1 = request.getParameter("memPhone1");
		String memPhone2 = request.getParameter("memPhone2");
		String memAddr = request.getParameter("memAddr");
		String memEmail = request.getParameter("memEmail");
		String memGender = request.getParameter("memGender");
		String memBirth = request.getParameter("memBirth");
		switch(memGender) {
		case "1" : case "3": case "5":  
		case "7": case "9": memGender = "M"; break;
		case "2" : case "4": case "6":  
		case "8": case "0" :memGender = "F"; break;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date birthDay = null;
		try {
			birthDay = sdf.parse(memBirth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		MemberDTO dto = new MemberDTO();
		dto.setMemBirth(birthDay);
		dto.setMemGender(memGender);
		dto.setMemAddr(memAddr);
		dto.setMemEmail(memEmail);
		dto.setMemId(memId);
		dto.setMemName(memName);
		dto.setMemPhone1(memPhone1);
		dto.setMemPhone2(memPhone2);
		dto.setMemPw(memPw);
		MemberDAO dao = new MemberDAO();
		dao.memberJoin(dto);
		request.setAttribute("userName", memName);
		
	}
}
