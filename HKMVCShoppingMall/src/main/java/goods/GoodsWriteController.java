package controller.goods;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.GoodsDTO;

public class GoodsWriteController {
	public void execute(HttpServletRequest request) throws IOException {
		int fileSize = 1024 * 1024 * 100 ;
		String realPath = request.getServletContext()
								 .getRealPath("goods/images");
		// MultipartRequest객체를 생성시킬 때 파일저장이 됨
		MultipartRequest multi = 
				new MultipartRequest(request, realPath,fileSize,"utf-8",
						new DefaultFileRenamePolicy());
		
		String goodsNum = multi.getParameter("goodsNum");
		String goodsName = multi.getParameter("goodsName");
		String goodsPrice = multi.getParameter("goodsPrice");
		String goodscontent = multi.getParameter("goodscontent");
		String company = multi.getParameter("company");
		
		String img1 = multi.getFilesystemName("img1");
		String img2 = multi.getFilesystemName("img2");
		String img3 = multi.getFilesystemName("img3");
		
		String goodsImage= img1 + "`" + img2 + "`" + img3;
		
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
		String employeeNum = authInfo.getUserId();
		GoodsDTO dto = new GoodsDTO();
		dto.setCompany(company);
		dto.setEmployeeNum(employeeNum);
		dto.setGoodsContent(goodscontent);
		dto.setGoodsName(goodsName);
		dto.setGoodsNum(goodsNum);
		dto.setGoodsImage(goodsImage);
		//문자열을 숫자로 변경
		dto.setGoodsPrice(Integer.parseInt(goodsPrice));
		GoodsDAO dao = new GoodsDAO();
		dao.goodsInsert(dto);
	}
}
