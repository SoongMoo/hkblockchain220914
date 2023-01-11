package hkShoppungMall;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataBaseInfo {
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource, 
			ApplicationContext applicationContext)
			throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		//sessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
		sessionFactory.setMapperLocations(
				applicationContext.getResources("classpath:mappers/**/*Mapper.xml"));
		sessionFactory.setTypeAliasesPackage("hkShoppungMall.domain");
		
		return sessionFactory.getObject();
	}
	// 마이바티스를 class파일과 연동을 할 때 필요, interface를 사용하는 경우엔 필요없음
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) 
			throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
