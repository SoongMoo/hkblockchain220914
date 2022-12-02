package controller.inquire;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.InquireDAO;
import model.DAO.UserDAO;
import model.DTO.AuthInfo;
import model.DTO.InquireDTO;
import model.DTO.MemberDTO;

public class InquireWriteProController {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		String inquireSubject = request.getParameter("inquireSubject");
		String inquireContent = request.getParameter("inquireContent");
		
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
		UserDAO userDAO = new UserDAO();
		MemberDTO memDTO = userDAO.selectOne(authInfo.getUserId());
		
		InquireDTO dto =  new InquireDTO();		
		dto.setGoodsNum(goodsNum);
		dto.setInquireContent(inquireContent);
		dto.setInquireSubject(inquireSubject);
		dto.setMemberNum(memDTO.getMemberNum());
		InquireDAO dao = new InquireDAO();
		dao.inquireInsert(dto);
		
	}
}
