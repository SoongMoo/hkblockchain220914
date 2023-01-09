package hkShoppungMall.service.goodsIpgo;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.command.GoodsIpgoCommand;
import hkShoppungMall.domain.GoodsIpgoDTO;
import hkShoppungMall.mapper.GoodsIpgoMapper;

@Service
public class GoodsIpgoService {
	@Autowired
	GoodsIpgoMapper goodsIpgoMapper;
	public void execute(GoodsIpgoCommand goodsIpgoCommand) {
		GoodsIpgoDTO dto = new GoodsIpgoDTO();
		dto.setGoodsNum(goodsIpgoCommand.getGoodsNum());
		dto.setIpgoDate(goodsIpgoCommand.getIpgoDate());
		dto.setIpgoQty(goodsIpgoCommand.getIpgoQty());
		dto.setMadeDate(
				Timestamp.valueOf(goodsIpgoCommand.getMadeDate()));
		Integer i = goodsIpgoMapper.ipgoInsert(dto);
		System.out.println(i + "개행이(가) 삽입되었습니다.");
	}
}
