package hkShoppungMall.service.goodsIpgo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.command.GoodsIpgoCommand;
import hkShoppungMall.mapper.GoodsIpgoMapper;
@Service
public class GoodsIpgoDeleteService {
	@Autowired
	GoodsIpgoMapper goodsIpgoMapper;
	public void execute(GoodsIpgoCommand goodsIpgoCommand) {
		goodsIpgoMapper.goodsIpgoDelete(goodsIpgoCommand);
	}
}
