package hkShoppungMall.domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias(value = "empDTO")
public class EmployeeDTO {
	String empNum;
	String empId;
	String empPw;
	String empName;
	String empAddr;
	String empPhone;
	String empEmail;
}
