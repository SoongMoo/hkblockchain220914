package controller.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ItemDAO;
import model.DAO.UserDAO;
import model.DTO.AuthInfo;
import model.DTO.MemberDTO;

public class GoodsWishItemController {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
		
		UserDAO userDAO = new UserDAO();
		MemberDTO dto = userDAO.selectOne(authInfo.getUserId());
		ItemDAO dao = new ItemDAO();
		dao.wishItem(goodsNum, dto.getMemberNum());
	}
}
