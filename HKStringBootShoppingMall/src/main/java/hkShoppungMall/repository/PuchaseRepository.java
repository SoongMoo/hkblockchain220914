package hkShoppungMall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hkShoppungMall.domain.CartDTO;
import hkShoppungMall.domain.CartGoodsDTO;
import hkShoppungMall.domain.PurchaseDTO;
import hkShoppungMall.domain.PurchaseListDTO;

@Repository
public class PuchaseRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "hkShoppungMall.repository.PuchaseRepository";
	String statement;
	public List<CartGoodsDTO> goodsOrder(CartDTO cart){
		statement = namespace + ".goodsOrder";
		return sqlSession.selectList(statement, cart) ;
	}
	public Integer selectNum() {
		statement = namespace + ".selectNum";
		return sqlSession.selectOne(statement) ;
	}
	public Integer purchaseInsert(PurchaseDTO dto) {
		statement = namespace + ".purchaseInsert";
		return sqlSession.insert(statement, dto) ;
	}
	public Integer purchaseListInsert(PurchaseListDTO purchaseListDTO) {
		statement = namespace + ".purchaseListInsert";
		return sqlSession.insert(statement, purchaseListDTO) ;
	}
}
