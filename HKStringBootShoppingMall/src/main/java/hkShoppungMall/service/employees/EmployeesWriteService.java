package hkShoppungMall.service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hkShoppungMall.command.EmployeeCommand;
import hkShoppungMall.domain.EmployeeDTO;
import hkShoppungMall.mapper.EmployeeMapper;

@Service
public class EmployeesWriteService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(EmployeeCommand employeeCommand) {		
		String empPw = passwordEncoder.encode(employeeCommand.getEmpPw()) ;
		System.out.println(empPw);
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpAddr(employeeCommand.getEmpAddr());
		dto.setEmpId(employeeCommand.getEmpId());
		dto.setEmpName(employeeCommand.getEmpName());
		dto.setEmpPhone(employeeCommand.getEmpPhone());
		dto.setEmpPw(empPw);
		dto.setEmpEmail(employeeCommand.getEmpEmail());
		employeeMapper.employeeInsert(dto);
	}
}
