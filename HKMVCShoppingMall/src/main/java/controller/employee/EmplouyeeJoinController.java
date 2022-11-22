package controller.employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.DAO.EmployeeDAO;
import model.DTO.EmployeeDTO;

public class EmplouyeeJoinController {
	public void execute(HttpServletRequest request) {
		String employeeNum = request.getParameter("employeeNum");
		String employeeName = request.getParameter("employeeName");
		String employeePw = request.getParameter("employeePw");
		String employeeAddr = request.getParameter("employeeAddr");
		String employeePhone = request.getParameter("employeePhone");
		String employeeHireDate = request.getParameter("employeeHireDate");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date date = null;
		try {
			date = sdf.parse(employeeHireDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployeeAddr(employeeAddr);
		dto.setEmployeeName(employeeName);
		dto.setEmployeeNum(employeeNum);
		dto.setEmployeePhone(employeePhone);
		dto.setEmployeePw(employeePw);
		dto.setEmployeeHireDate(date);
		
		EmployeeDAO dao= new EmployeeDAO();
		dao.employeeInsert(dto);
	}
}
