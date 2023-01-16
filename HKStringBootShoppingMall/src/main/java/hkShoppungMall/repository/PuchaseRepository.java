package hkShoppungMall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hkShoppungMall.domain.CartDTO;
import hkShoppungMall.domain.CartGoodsDTO;
import hkShoppungMall.domain.PaymentDTO;
import hkShoppungMall.domain.PaymentPurchaseGoodsDTO;
import hkShoppungMall.domain.PurchaseDTO;
import hkShoppungMall.domain.PurchaseDetailDTO;
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
	public List<PaymentPurchaseGoodsDTO> purchaseList(String memberNum){
		statement = namespace + ".purchaseList";
		return sqlSession.selectList(statement, memberNum) ;
	}
	public Integer payment(PaymentDTO paymentDTO) {
		statement = namespace + ".payment";
		return sqlSession.insert(statement, paymentDTO) ;
	}
	public Integer purchaseStatus(String purchaseNum) {
		statement = namespace + ".purchaseStatus";
		return sqlSession.update(statement, purchaseNum) ;
	}
	public Integer paymentDelete(String purchaseNum) {
		statement = namespace + ".paymentDelete";
		return sqlSession.delete(statement, purchaseNum) ;
	}
	public Integer purchaseStatusBack(String purchaseNum) {
		statement = namespace + ".purchaseStatusBack";
		return sqlSession.update(statement, purchaseNum) ;
	}
	public List<PurchaseDetailDTO> purchaseDetail(String purchaseNum) {
		statement = namespace + ".purchaseDetail";
		return sqlSession.selectList(statement, purchaseNum) ;
	}
}
