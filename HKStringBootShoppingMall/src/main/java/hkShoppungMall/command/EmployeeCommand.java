package hkShoppungMall.command;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EmployeeCommand {
	@Size(min = 4, max = 12,message = "아이디는 4자에서 12자사이로 입력하여 주세요!")
	String empId;
	@NotEmpty(message = "비밀번호를 입력해주세요!")
	@Size(min = 3, max = 12)
	String empPw;
	@NotBlank(message = "비밀번호확인을 입력해주세요!")
	@Size(min = 3, max = 12)
	String empPwCon;
	@NotEmpty(message = "이름을 입력해주세요!")
	String empName;
	@NotEmpty(message = "주소를 입력해주세요!")
	String empAddr;
	@NotEmpty(message = "전화번호를 입력해주세요!")
	String empPhone;
	@NotBlank(message = "이메일을 입력해주세요!")
	String empEmail;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	Date [] schoolYear;
	String [] school;
	
	public boolean isEmpPwEqualsEmpPwCon() {
		return empPw.equals(empPwCon);
	}
}
