package hkShoppungMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void execute(GoodsCommand goodsCommand,HttpSession session) {
		GoodsDTO dto = new GoodsDTO();
		dto.setDeliveryCost(goodsCommand.getDeliveryCost());
		dto.setGoodsContent(goodsCommand.getGoodsContent());
		dto.setGoodsName(goodsCommand.getGoodsName());
		dto.setGoodsPrice(goodsCommand.getGoodsPrice());
		dto.setGoodsNum(goodsCommand.getGoodsNum());
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		EmployeeDTO employeeDTO = employeeMapper.selectOne(authInfo.getUserId());
		dto.setEmpUptNum(employeeDTO.getEmpNum());
		goodsMapper.goodsUpdate(dto);
	}
}
