package hkShoppungMall.service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import hkShoppungMall.command.EmployeeCommand;
import hkShoppungMall.domain.EmployeeDTO;
import hkShoppungMall.mapper.EmployeeMapper;
@Component
@Service
public class EmployeeUpdateService {
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public String execute(EmployeeCommand employeeCommand,BindingResult result) {
		EmployeeDTO dto = employeeMapper.selectOne(employeeCommand.getEmpId());
		if(passwordEncoder.matches(employeeCommand.getEmpPw(), 
				dto.getEmpPw())) {
			dto.setEmpAddr(employeeCommand.getEmpAddr());
			dto.setEmpId(employeeCommand.getEmpId());
			dto.setEmpName(employeeCommand.getEmpName());
			dto.setEmpPhone(employeeCommand.getEmpPhone());
			dto.setEmpEmail(employeeCommand.getEmpEmail());
			employeeMapper.employeeUpdate(dto);
			return "redirect:empInfo?num="+employeeCommand.getEmpId();
		}else {
			//result.addError(new FieldError("employeeCommand", "empPw", "비밀번호가 틀렸어요"));
			result.rejectValue("empPw", "employeeCommand.empPw", "비밀번호가 틀렸어요");
			return "thymeleaf/employee/empUpdate";
		}
	}
}
