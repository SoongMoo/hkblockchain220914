package hkShoppungMall.mapper;

import org.springframework.stereotype.Repository;

import hkShoppungMall.command.LoginCommand;
import hkShoppungMall.domain.AuthInfo;

@Repository(value = "hkShoppungMall.mapper.LoginMapper")
public interface LoginMapper {
	//   result type      id     parameter type
	public AuthInfo loginSelect(String userId );
}
