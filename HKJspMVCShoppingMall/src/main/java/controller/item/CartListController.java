package controller.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ItemDAO;
import model.DAO.UserDAO;
import model.DTO.AuthInfo;
import model.DTO.CartListDTO;
import model.DTO.MemberDTO;

public class CartListController {
	public void execute(HttpServletRequest request) {
		
		System.out.println("siusbguvwesgv");
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
		UserDAO dao = new UserDAO();
		MemberDTO mem = dao.selectOne(authInfo.getUserId());
		ItemDAO itemDao = new ItemDAO();
		List<CartListDTO> list = itemDao.cartList(mem.getMemberNum());
		request.setAttribute("list", list);
	}
}
