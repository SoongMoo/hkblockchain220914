package controller.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ItemDAO;
import model.DAO.UserDAO;
import model.DTO.AuthInfo;
import model.DTO.CartDTO;
import model.DTO.MemberDTO;

public class CartInsertController {
	public void execute(HttpServletRequest request) {
	      String goodsNum = request.getParameter("goodsNum");
	      String qty = request.getParameter("qty");
	      CartDTO dto = new CartDTO();
	      dto.setCartQty(Integer.parseInt(qty));
	      dto.setGoodsNum(goodsNum);
	      
	      HttpSession session = request.getSession();
	      AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
	      UserDAO userDao = new UserDAO();
	      MemberDTO mem = userDao.selectOne(authInfo.getUserId());
	      dto.setMemberNum(mem.getMemberNum());
	      
	      ItemDAO dao = new ItemDAO();
	      dao.cartInsert(dto);
	}
}
