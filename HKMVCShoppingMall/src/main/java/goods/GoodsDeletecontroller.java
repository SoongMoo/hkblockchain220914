package controller.goods;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;
import model.DTO.GoodsDTO;

public class GoodsDeletecontroller {
	public void execute(HttpServletRequest request) {
		String goodsNum = request.getParameter("goodsNum");
		GoodsDAO dao = new GoodsDAO();
		GoodsDTO dto = dao.selectOne(goodsNum);
		String goodsImages[] = dto.getGoodsImage().split("`");
		if(goodsImages.length >= 1) {
			String realPath = 
					request.getServletContext()
						   .getRealPath("goods/images");
			File file=null;
			for(String fileName : goodsImages) {
				file = new File(realPath +"/"+fileName);
				if(file.exists())file.delete();
			}
		}
		dao.goodsDelete(goodsNum);
	}
}
