package hkShoppungMall.mapper;

import org.springframework.stereotype.Repository;

import hkShoppungMall.command.FindPasswordCommand;
import hkShoppungMall.domain.AuthInfo;
import hkShoppungMall.domain.PasswordChangeDTO;

@Repository("hkShoppungMall.mapper.FindMapper")
public interface FindMapper {
	public AuthInfo findId(String email);
	public String findPw(FindPasswordCommand findPasswordCommand);
	public Integer changPw(PasswordChangeDTO dto);
}
