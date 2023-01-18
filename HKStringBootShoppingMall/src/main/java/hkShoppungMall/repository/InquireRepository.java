package hkShoppungMall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hkShoppungMall.domain.GoodsDTO;
import hkShoppungMall.domain.InquireDTO;
import hkShoppungMall.domain.InquireGoodsDTO;

@Repository
public class InquireRepository {
	@Autowired
	SqlSession sqlSession;
	String namespace = "hkShoppungMall.repository.InquireRepository";
	String statement;
	public List<InquireDTO> inquireList(String goodsNum){
		statement = namespace + ".inquireList";
		return sqlSession.selectList(statement, goodsNum) ;
	}
	public Integer inquireWrite(InquireDTO dto){
		statement = namespace + ".inquireWrite";
		return sqlSession.insert(statement, dto) ;
	}
	public Integer inquireDelete(String inquireNum) {
		statement = namespace + ".inquireDelete";
		return sqlSession.delete(statement, inquireNum) ;
	}
	public InquireDTO inquireSelect(String inquireNum) {
		statement = namespace + ".inquireSelect";
		return sqlSession.selectOne(statement, inquireNum) ;
	}
	public InquireGoodsDTO inquireGoodsSelect(String inquireNum) {
		statement = namespace + ".inquireGoodsSelect";
		return sqlSession.selectOne(statement, inquireNum) ;
	}
	public GoodsDTO goods(String goodsNum) {
		statement = namespace + ".goods";
		return sqlSession.selectOne(statement, goodsNum) ;
	}
	public Integer inquireAnswer(InquireDTO dto) {
		statement = namespace + ".inquireAnswer";
		return sqlSession.update(statement, dto) ;
	}
	public Integer inquireUpdate(InquireDTO dto){
		statement = namespace + ".inquireUpdate";
		return sqlSession.update(statement, dto) ;
	}
}
