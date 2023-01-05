package hkShoppungMall.service.goods;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import hkShoppungMall.command.FileInfo;
import hkShoppungMall.command.GoodsCommand;
import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.EmployeeDTO;
import hkShoppungMall.domain.GoodsDTO;
import hkShoppungMall.mapper.EmployeeMapper;
import hkShoppungMall.mapper.GoodsMapper;
import jakarta.servlet.http.HttpSession;

@Service
public class GoodsModifyService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(GoodsCommand goodsCommand,HttpSession session, BindingResult result, Model model) {
		GoodsDTO dto = new GoodsDTO();
		dto.setDeliveryCost(goodsCommand.getDeliveryCost());
		dto.setGoodsContent(goodsCommand.getGoodsContent());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		EmployeeDTO employeeDTO = employeeMapper.selectOne(authInfo.getUserId());
		dto.setEmpUptNum(employeeDTO.getEmpNum());
		
		List<FileInfo> list = (List<FileInfo>)session.getAttribute("fileList");
		// 삭제할 파일이 있는 경우 먼저 데이터베이스로 부터 파일 정보를 가지고와야 한다. 
		GoodsDTO lib = goodsMapper.goodsSelectOne(goodsCommand.getGoodsNum());
		
		String fileDir = "/view/goods/upload";
		String filePath=session.getServletContext().getRealPath(fileDir);
		
		if(!goodsCommand.getGoodsMain().getOriginalFilename().isEmpty()) {
			MultipartFile mf = goodsCommand.getGoodsMain();
			String originalFile = mf.getOriginalFilename();
			String extension = originalFile.substring(originalFile.lastIndexOf("."));
			String storeName = UUID.randomUUID().toString().replace("-", "");
			String storeFileName=storeName + extension;
			File file = new File(filePath + "/" + storeFileName);
			try {
				mf.transferTo(file); // 파일을 저장
			}catch(Exception e) {e.printStackTrace();}
			dto.setGoodsMainOrg(originalFile);
			dto.setGoodsMain(storeFileName);
		}else {// 파일 삭제를 했으나 파일이 upload되지 않은 경우 
			for(FileInfo fi : list ) {
				if(lib.getGoodsMainOrg().equals(fi.getOrgFile())) {
					model.addAttribute("goodsCommand", lib);
					result.rejectValue("goodsMain", "goodsCommand.goodsMain", "대문이미지를 선택해주세요.");
					return;
				}
			}
		}
		
		//goodsMapper.goodsUpdate(dto);
		

		
	}
}
