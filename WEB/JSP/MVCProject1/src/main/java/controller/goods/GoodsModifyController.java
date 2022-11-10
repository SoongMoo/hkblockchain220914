package controller.goods;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.GoodsDTO;
import model.DAO.GoodsDAO;

public class GoodsModifyController {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {}
		String goodsNum = request.getParameter("goodsNum");
		String goodsName = request.getParameter("goodsName");
		String goodsPrice = request.getParameter("goodsPrice");
		String goodsContent = request.getParameter("goodsContent");
		String goodsQty = request.getParameter("goodsQty");
		String goodsCompany = request.getParameter("goodsCompany");
		
		String goodsDate = request.getParameter("goodsDate");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(goodsDate);  
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		GoodsDTO dto = new GoodsDTO();
		dto.setGoodsCompany(goodsCompany);
		dto.setGoodsContent(goodsContent);
		dto.setGoodsName(goodsName);
		dto.setGoodsNum(Integer.parseInt(goodsNum));
		dto.setGoodsPrice(Integer.parseInt(goodsPrice));
		dto.setGoodsQty(Integer.parseInt(goodsQty));
		dto.setGoodsDate(date);
		
		GoodsDAO dao = new GoodsDAO();
		dao.goodsUpdate(dto);
	}
}
