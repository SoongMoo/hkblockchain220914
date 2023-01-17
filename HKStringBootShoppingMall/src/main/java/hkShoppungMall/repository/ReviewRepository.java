package hkShoppungMall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hkShoppungMall.domain.GoodsReviewDTO;
import hkShoppungMall.domain.ReviewDTO;

@Repository
public class ReviewRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "hkShoppungMall.repository.ReviewRepository";
	String statement;
	
	public Integer reviewWrite(ReviewDTO dto) {
		statement = namespace + ".reviewWrite";
		return sqlSession.insert(statement, dto) ;
	}
	public Integer reviewDelete(String reviewNum) {
		statement = namespace + ".reviewDelete";
		return sqlSession.delete(statement, reviewNum) ;
	}
	public GoodsReviewDTO reviewGoodsSelect(String reviewNum) {
		statement = namespace + ".reviewGoodsSelect";
		return sqlSession.selectOne(statement, reviewNum) ;
	}
	public Integer reviewUpdate(ReviewDTO dto) {
		statement = namespace + ".reviewUpdate";
		return sqlSession.update(statement, dto) ;
	}
	public List<ReviewDTO> goodsReviewList(String goodsNum) {
		statement = namespace + ".goodsReviewList";
		return sqlSession.selectList(statement, goodsNum) ;
	}
}
