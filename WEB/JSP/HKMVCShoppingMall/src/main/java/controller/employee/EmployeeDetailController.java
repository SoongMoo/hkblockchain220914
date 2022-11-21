package controller.employee;

import javax.servlet.http.HttpServletRequest;

import model.DAO.EmployeeDAO;
import model.DTO.EmployeeDTO;

public class EmployeeDetailController {
	public void execute(HttpServletRequest request) {
		String employeeNum = request.getParameter("num");
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO dto = dao.selectOne(employeeNum);
		request.setAttribute("dto", dto);
	}
}
