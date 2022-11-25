package controller.goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.GoodsDTO;

public class GoodsUpdateController {
	public void execute(HttpServletRequest request ) {
		String goodsNum = request.getParameter("goodsNum");
		String goodsName = request.getParameter("goodsName");
		String goodsPrice = request.getParameter("goodsPrice");
		String goodscontent = request.getParameter("goodsContent");
		String company = request.getParameter("company");
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
		String employeeUptNum = authInfo.getUserId();
		
		GoodsDTO dto = new GoodsDTO();
		dto.setCompany(company);
		dto.setEmployeeUptNum(employeeUptNum);
		dto.setGoodsContent(goodscontent);
		dto.setGoodsName(goodsName);
		dto.setGoodsNum(goodsNum);
		dto.setGoodsPrice(Integer.parseInt(goodsPrice));
		
		GoodsDAO dao = new GoodsDAO();
		dao.goodsUpdate(dto);		
	}
}
