package hkShoppungMall.service.goodsIpgo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.GoodsIpgoDTO;
import hkShoppungMall.domain.GoodsIpgoGoodsDTO;
import hkShoppungMall.mapper.GoodsIpgoMapper;

@Service
public class GoodsIpgoDetailService {
	@Autowired
	GoodsIpgoMapper goodsIpgoMapper;
	public void execute(String goodsNum, Date ipgoDate, Model model) {
		GoodsIpgoDTO goodsIpgoDTO = new GoodsIpgoDTO();
		goodsIpgoDTO.setGoodsNum(goodsNum);
		goodsIpgoDTO.setIpgoDate(ipgoDate);
		GoodsIpgoGoodsDTO dto = goodsIpgoMapper.ipgoDetail(goodsIpgoDTO);
		model.addAttribute("goodsIpgoGoodsCommand", dto);
	}
}
