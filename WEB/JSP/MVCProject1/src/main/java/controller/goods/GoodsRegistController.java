package controller.goods;

import javax.servlet.http.HttpServletRequest;

public class GoodsRegistController {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		String goodsName = request.getParameter("goodsName");
		String goodsPrice = request.getParameter("goodsPrice");
		String goodsContent = request.getParameter("goodsContent");
		String goodsQty = request.getParameter("goodsQty");
		String goodsCompany = request.getParameter("goodsCompany");
		
	}
}
