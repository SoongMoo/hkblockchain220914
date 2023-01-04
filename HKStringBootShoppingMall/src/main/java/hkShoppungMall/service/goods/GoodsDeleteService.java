package hkShoppungMall.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.mapper.GoodsMapper;

@Service
public class GoodsDeleteService {
	@Autowired
	GoodsMapper goodsMapper;
	public void execute(String goodsNum) {
		Integer i = goodsMapper.goodsDelete(goodsNum);
		System.out.println(i + "개가 삭제되었습니다.");
	}
}
