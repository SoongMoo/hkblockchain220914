package hkShoppungMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias(value = "authInfo")
public class AuthInfo {
	String userId;
	String userEmail;
	String userPw;
	String phone;
	String memberOk;
	String grade;
}
