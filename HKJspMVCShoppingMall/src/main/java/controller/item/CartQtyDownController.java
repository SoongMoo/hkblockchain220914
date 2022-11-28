package controller.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ItemDAO;
import model.DAO.UserDAO;
import model.DTO.AuthInfo;
import model.DTO.MemberDTO;

public class CartQtyDownController {
	public void execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
		String MemberId = authInfo.getUserId();
		UserDAO userDao = new UserDAO();
		MemberDTO memDTO = userDao.selectOne(MemberId);
		String goodsNum = request.getParameter("goodsNum");
		ItemDAO dao = new ItemDAO();
		dao.itemQtyDown(memDTO.getMemberNum(),goodsNum);
	}
}
