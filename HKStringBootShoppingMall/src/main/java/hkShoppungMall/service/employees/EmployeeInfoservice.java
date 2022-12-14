package hkShoppungMall.service.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hkShoppungMall.domain.EmployeeDTO;
import hkShoppungMall.mapper.EmployeeMapper;

@Component
@Service
public class EmployeeInfoservice {
	@Autowired
	EmployeeMapper employeeMapper;
	public void execute(String empNum, Model model) {
		EmployeeDTO dto = employeeMapper.selectOne(empNum);
		model.addAttribute("employeeCommand", dto);
	}
}
