package controller.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ItemDAO;
import model.DAO.UserDAO;
import model.DTO.AuthInfo;
import model.DTO.MemberDTO;

public class CartItemsDeleteController {
	public void execute(HttpServletRequest request) {
		String goodsNums[] = request.getParameter("goodsNums").split("-"); 
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
		UserDAO userDAO = new UserDAO();
		MemberDTO memDTO = userDAO.selectOne(authInfo.getUserId());
		ItemDAO dao = new ItemDAO();
		for(String goodsNum : goodsNums) {
			dao.itemDelete(memDTO.getMemberNum(), goodsNum);
		}
	}
}
