package hkShoppungMall.command;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberCommand {
	String memberNum;
	String memberId;
	String memberPw;
	String memberPwCon;
	String memberName;
	String memberAddr;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	LocalDateTime memberRegist;
	String gender;
	String memberPhone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date memberBirth;
	String memberEmail;	
}
