package controller.item;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ItemDAO;
import model.DAO.UserDAO;
import model.DTO.AuthInfo;
import model.DTO.CartListDTO;
import model.DTO.MemberDTO;

public class GoodsItemController {
	public void execute(HttpServletRequest request) {
		String goodsNums[] = request.getParameterValues("prodCk");
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
		UserDAO userDAO = new UserDAO();
		MemberDTO memDTO = userDAO.selectOne(authInfo.getUserId());
		List<CartListDTO> list = new ArrayList<CartListDTO>();
		ItemDAO dao = new ItemDAO();
		String nums ="";
		int goodsTotalPrice = 0;
		for(String goodsNum : goodsNums) {
			CartListDTO dto = dao.selectOne(memDTO.getMemberNum(),goodsNum);
			System.out.println(dto.getTotalPrice());
			goodsTotalPrice += dto.getTotalPrice();
			nums += goodsNum+"-";
			list.add(dto);
		}
		request.setAttribute("list", list);
		request.setAttribute("goodsTotalPrice", goodsTotalPrice);
		request.setAttribute("goodsNums", nums);
		
	}
}
