package hkShoppungMall.domain;

import lombok.Data;

@Data
public class AuthInfo {
	String userId;
	String grade;
	String userPw;
	String phone;
	String memberOk;
	String userEmail;
}
