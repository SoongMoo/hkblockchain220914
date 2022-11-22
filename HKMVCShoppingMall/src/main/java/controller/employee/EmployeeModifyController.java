package controller.employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.DAO.EmployeeDAO;
import model.DTO.EmployeeDTO;

public class EmployeeModifyController {
	public void execute(HttpServletRequest request) {
		String employeeNum = request.getParameter("employeeNum");
		String employeeName= request.getParameter("employeeName");
		String employeePhone= request.getParameter("employeePhone");
		String employeeAddr= request.getParameter("employeeAddr");
		String employeeHireDate= request.getParameter("employeeHireDate");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		
		Date date = null;
		try {
			date = sdf.parse(employeeHireDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployeeAddr(employeeAddr);
		dto.setEmployeeHireDate(date);
		dto.setEmployeeName(employeeName);
		dto.setEmployeeNum(employeeNum);
		dto.setEmployeePhone(employeePhone);
		
		EmployeeDAO dao = new EmployeeDAO();
		dao.employeeUpdate(dto);
	}
}
