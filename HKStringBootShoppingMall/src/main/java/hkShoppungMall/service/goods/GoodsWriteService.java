package hkShoppungMall.service.goods;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hkShoppungMall.command.GoodsCommand;
import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.EmployeeDTO;
import hkShoppungMall.domain.GoodsDTO;
import hkShoppungMall.mapper.EmployeeMapper;
import hkShoppungMall.mapper.GoodsMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsWriteService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	GoodsMapper goodsMapper;

	public void execute(GoodsCommand goodsCommand, HttpSession session) {
		GoodsDTO dto = new GoodsDTO();
		dto.setDeliveryCost(goodsCommand.getDeliveryCost());
		dto.setGoodsContent(goodsCommand.getGoodsContent());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());

		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String userId = authInfo.getUserId();
		EmployeeDTO employeesDTO = employeeMapper.selectOne(userId);
		dto.setEmpNum(employeesDTO.getEmpNum());

		/////////////////////////// 파일 추가 //////////////////////////////
		/// 파일 저장 경로 지정
		String fileDir = "/view/goods/upload";
		String filePath = session.getServletContext().getRealPath(fileDir);

		/// 파일이 업로드되었는 지 확인
		if (!goodsCommand.getGoodsMain().getOriginalFilename().isEmpty()) {
			// 11
			MultipartFile mf = goodsCommand.getGoodsMain(); // 012345678901
			String originalFile = mf.getOriginalFilename(); // test.png.png
			// .png
			String extension = originalFile.substring(originalFile.lastIndexOf("."));

			String storeName = UUID.randomUUID().toString().replace("-", "");
			String storeFileName = storeName + extension; // 4921hdifbsa.png

			File file = new File(filePath + "/" + storeFileName);
			try {
				mf.transferTo(file); // 파일저장
			} catch (Exception e) {
				e.printStackTrace();
			}
			dto.setGoodsMain(storeFileName);
			dto.setGoodsMainOrg(originalFile);
		}
		
		int i = goodsMapper.goodsInsert(dto);
		System.out.println(i + "개가 삽입되었습니다.");

	}
}
