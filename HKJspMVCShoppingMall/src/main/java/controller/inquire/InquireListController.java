package controller.inquire;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.InquireDAO;
import model.DAO.UserDAO;
import model.DTO.AuthInfo;
import model.DTO.InquireDTO;
import model.DTO.MemberDTO;

public class InquireListController {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		InquireDAO dao = new InquireDAO();
		List<InquireDTO> list = dao.selectList(goodsNum);
		request.setAttribute("list", list);
		request.setAttribute("goodsNum", 
				request.getParameter("goodsNum"));
		
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
		UserDAO userDao = new UserDAO();
		MemberDTO memDTO = userDao.selectOne(authInfo.getUserId());
		request.setAttribute("memberNum", memDTO.getMemberNum());
	}
}
