package hkShoppungMall.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import hkShoppungMall.domain.EmployeeDTO;

@Repository(value="hkShoppungMall.mapper.EmployeeMapper")
public interface EmployeeMapper {
	public Integer employeeInsert(EmployeeDTO dto);
	//페이징
	public Integer count();
	public List<EmployeeDTO> selectAll();
	//끝
	public EmployeeDTO selectOne(String empId);
	public Integer employeeUpdate(EmployeeDTO dto);
	public Integer employeeDelete(String empId);
	public Integer empDeletes(List<String> cs);
	/// employeesMyPage서비스
	public Integer employeePwChange(EmployeeDTO dto);
}
