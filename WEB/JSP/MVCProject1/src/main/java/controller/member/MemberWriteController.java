package controller.member;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.MemberDTO;
import model.DAO.MemberDAO;

public class MemberWriteController {
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
		
		String memRegiDate = request.getParameter("memRegiDate");
		String memBirth = request.getParameter("memBirth");
		String birth[] =  memBirth.split("T");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		
		Date regiDate = null;
		Date birthDay = null; 
		try {
			regiDate = sdf.parse(memRegiDate);
			birthDay = sdf.parse(birth[0]);
		} catch (ParseException e) {
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
		dao.memberInsert(dto);
	}
}
