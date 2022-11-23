package controller.goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.GoodsDTO;

public class GoodsWriteController {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		String goodsName = request.getParameter("goodsName");
		String goodsPrice = request.getParameter("goodsPrice");
		String goodscontent = request.getParameter("goodscontent");
		String company = request.getParameter("company");
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
		String employeeNum = authInfo.getUserId();
		GoodsDTO dto = new GoodsDTO();
		dto.setCompany(company);
		dto.setEmployeeNum(employeeNum);
		dto.setGoodsContent(goodscontent);
		dto.setGoodsName(goodsName);
		dto.setGoodsNum(goodsNum);
		//문자열을 숫자로 변경
		dto.setGoodsPrice(Integer.parseInt(goodsPrice));
		GoodsDAO dao = new GoodsDAO();
		dao.goodsInsert(dto);
	}
}
