package hkShoppungMall.service.goodsIpgo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hkShoppungMall.mapper.GoodsIpgoMapper;

@Service
public class GoodsIpgoDelsService {
	@Autowired
	GoodsIpgoMapper goodsIpgoMapper;
	public void execute(String[] deletes) {
		List<String[]> condition  = new ArrayList<String[]>();
		for(String num : deletes) {// "goods10005`2023-01-10`11111"
			// n : [0][1][2][3][][][][]
			String [] n = num.split("`"); // n[0] = goods10005, n[1]=2023-01-10, n[2]=11111
			condition.add(n);
		}
		goodsIpgoMapper.goodsIpgoDels(condition);
	}
}
