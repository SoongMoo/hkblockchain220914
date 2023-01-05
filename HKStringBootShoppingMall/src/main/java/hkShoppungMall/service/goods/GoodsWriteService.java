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
		// 11
		MultipartFile mf = goodsCommand.getGoodsMain(); // 012345678901
		String originalFile = mf.getOriginalFilename(); // test.png.png
		// .png
		String extension = originalFile.substring(originalFile.lastIndexOf("."));
		// UUID는 unique한 값을 가지고 올 때 주로 사용하는 API이다.
		String storeName = UUID.randomUUID().toString().replace("-", "");
		String storeFileName = storeName + extension; // 4921hdifbsa.png

		File file = new File(filePath + "/" + storeFileName);
		try {
			mf.transferTo(file); // 파일저장
		} catch (Exception e) {
			e.printStackTrace();
		}
		dto.setGoodsMain(storeFileName); // 새로운 파일명
		dto.setGoodsMainOrg(originalFile); // 원래 파일명
		if (!goodsCommand.getGoodsImages()[0].getOriginalFilename().isEmpty()) {
			// MultipartFile mf1 = goodsCommand.getGoodsImages()[0]
			// MultipartFile mf1 = goodsCommand.getGoodsImages()[1]
			// MultipartFile mf1 = goodsCommand.getGoodsImages()[2]
			String originalTotal = "";
			String storeTotal = "";
			// 이숭무.png.png-이숭무1.png.png-이숭무2.png.png
			for (MultipartFile mf1 : goodsCommand.getGoodsImages()) {
				//// 파일명 만들기 ////
				// 이숭무.png.png
				originalFile = mf1.getOriginalFilename();
				// .png // 확장자 가지고 오기
				extension = originalFile.substring(originalFile.lastIndexOf("."));
				// u84902hfh2984902dsghjf
				storeName = UUID.randomUUID().toString().replace("-", "");
				// u84902hfh2984902dsghjf.png
				storeFileName = storeName + extension;
				/// 파일명 만들기 ////
				file = new File(filePath + "/" + storeFileName);
				try {
					mf1.transferTo(file);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				originalTotal += originalFile + "-";
				storeTotal += storeFileName + "-";
			}
			dto.setGoodsImages(storeTotal);
			dto.setGoodsOriginal(originalTotal);
		}

		int i = goodsMapper.goodsInsert(dto);
		System.out.println(i + "개가 삽입되었습니다.");

	}
}
