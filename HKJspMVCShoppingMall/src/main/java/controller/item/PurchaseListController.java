package controller.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.ItemDAO;
import model.DAO.UserDAO;
import model.DTO.AuthInfo;
import model.DTO.MemberDTO;
import model.DTO.PurchaseInfoDTO;

public class PurchaseListController {
	public void execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
		UserDAO userDao = new UserDAO();
		MemberDTO nmemDTO = userDao.selectOne(authInfo.getUserId());
		
		ItemDAO dao = new ItemDAO();
		List<PurchaseInfoDTO> list = dao.purchaseItemSelect(nmemDTO.getMemberNum());
		request.setAttribute("list", list);
	}
}
