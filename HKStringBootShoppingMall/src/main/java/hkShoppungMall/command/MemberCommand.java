package hkShoppungMall.command;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MemberCommand {
	String memberNum;
	@NotBlank(message = "아이디를 입력해 주세요")
	@Size(min = 8 , max = 12)
	String memberId;
	@Pattern(regexp = "^(?=.*?[A-Za-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-+]).{8,}$",
			message = "영문자와 숫자 그리고 특수문자가 포함된 8글자 이상")
	String memberPw;
	@NotBlank(message = "비밀번호확인 입력하여 주세요.")
	String memberPwCon;
	@NotBlank(message = "이름을 입력하여 주세요.")
	String memberName;
	@NotBlank(message = "주소를 입력하여 주세요.")
	String memberAddr;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@NotNull (message = "등록일을 입력하여 주세요.")
	LocalDateTime memberRegist;
	@NotBlank(message = "성별을 선택하여 주세요.")
	String gender;
	@NotBlank(message = "연락처를 입력하여 주세요.")
	String memberPhone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull (message = "생년월일을 입력하여 주세요.")
	Date memberBirth;
	@Email(message = "형식에 맞지 않습니다.")
	@NotBlank(message = "이메일을 입력하여 주세요.")
	String memberEmail;	
	
	String accountAddress;
	
	public boolean isMemberPwEqualsMemberPwCon() {
		return memberPw.equals(memberPwCon);
	}
	
	
	
	
}