package controller.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DAO.ItemDAO;
import model.DAO.UserDAO;
import model.DTO.AuthInfo;
import model.DTO.GoodsDTO;
import model.DTO.MemberDTO;

public class DetailViewController {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dto = dao.selectOne(goodsNum);
		request.setAttribute("goodsDTO", dto);
		
		HttpSession  session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
		if(authInfo != null) {
			UserDAO userDAO = new UserDAO();
			MemberDTO memDTO = userDAO.selectOne(authInfo.getUserId());
			
			ItemDAO itemDAO = new ItemDAO();
			String isTrue = itemDAO.wishSelect(goodsNum,memDTO.getMemberNum());
			request. setAttribute("isTrue", isTrue);
		}		
	}
}
