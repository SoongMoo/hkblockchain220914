package hkShoppungMall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hkShoppungMall.domain.CartDTO;
import hkShoppungMall.domain.CartGoodsDTO;
import hkShoppungMall.domain.WishDTO;

@Repository
public class CornerRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "hkShoppungMall.repository.CornerRepository";
	String statement;
	public Integer wishAdd(WishDTO dto) {
		statement = namespace + ".wishAdd";
		return sqlSession.insert(statement, dto) ;
	}
	public String wishCount(WishDTO dto) {
		statement = namespace + ".wishCount";
		return sqlSession.selectOne(statement, dto) ;
	}
	public Integer cartAdd(CartDTO cart) {
		statement = namespace + ".cartAdd";
		return sqlSession.insert(statement, cart) ;
	}
	public List<CartGoodsDTO> cartList(String memberNum) {
		statement = namespace + ".cartList";
		return sqlSession.selectList(statement, memberNum) ;
	}
	public Integer goodsCartQtyDown(CartDTO cart) {
		statement = namespace + ".goodsCartQtyDown";
		return sqlSession.update(statement, cart) ;
	}
}
