package hkShoppungMall.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hkShoppungMall.domain.DeliveryDTO;
@Repository
public class DeliveryRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "hkShoppungMall.repository.DeliveryRepository";
	String statement;
	public Integer deliveryInsert(DeliveryDTO dto) {
		statement = namespace + ".deliveryInsert";
		return sqlSession.insert(statement, dto) ;
	}
	public Integer deliveryDelete(String purchaseNum) {
		statement = namespace + ".deliveryDelete";
		return sqlSession.delete(statement, purchaseNum) ;
	}
	public Integer deliveryUpdate(String purchaseNum) {
		statement = namespace + ".deliveryUpdate";
		return sqlSession.update(statement, purchaseNum) ;
	}
	
}
