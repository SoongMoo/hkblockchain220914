package hkShoppungMall.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hkShoppungMall.domain.InquireDTO;

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
	
}
