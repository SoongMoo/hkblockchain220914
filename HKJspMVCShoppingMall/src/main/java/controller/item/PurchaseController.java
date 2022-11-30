package controller.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ItemDAO;
import model.DAO.UserDAO;
import model.DTO.AuthInfo;
import model.DTO.MemberDTO;
import model.DTO.PurchaseDTO;
import model.DTO.PurchaseListDTO;

public class PurchaseController {
	public void execute(HttpServletRequest request) {
		
		String goodsTotalPrice = request.getParameter("goodsTotalPrice");
		String receiveName = request.getParameter("receiveName");
		String receiveAddr = request.getParameter("receiveAddr");
		String receivePhone = request.getParameter("receivePhone");
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
		UserDAO userDAO = new UserDAO();
		MemberDTO memDTO = userDAO.selectOne(authInfo.getUserId());
		String memberNum = memDTO.getMemberNum();
		
		ItemDAO itemDAO = new 	ItemDAO();
		int purchaseNum = itemDAO.purchaseNum();
		
		PurchaseDTO dto = new PurchaseDTO();
		dto.setPuchaseNum(purchaseNum);
		dto.setLocation(receiveAddr);
		dto.setMemberNum(memberNum);
		dto.setReceiveName(receiveName);
		dto.setReceivePhone(receivePhone);
		dto.setTotalPrice(Integer.parseInt(goodsTotalPrice));
		
		itemDAO.purchaseInsert(dto);
		
		String goodsNums = request.getParameter("goodsNums");//gd100005-gd100024-
		String nums[] = goodsNums.split("-");
		for(String goodsNum : nums) {
			System.out.println(goodsNum);
			PurchaseListDTO dto1 = new PurchaseListDTO();
			dto1.setPurchaseNum(purchaseNum);
			dto1.setGoodsNum(goodsNum);
			int i = itemDAO.purchaseListInsert(dto1,memberNum );
			if(i >= 1) {
				itemDAO.cartItemDelete(goodsNum,memberNum);
			}
		}
				
		String paymentMethod = request.getParameter("paymentMethod");
		request.setAttribute("paymentMethod", paymentMethod);
		
	}
}
