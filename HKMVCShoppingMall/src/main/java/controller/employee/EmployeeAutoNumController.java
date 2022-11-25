package controller.employee;

import javax.servlet.http.HttpServletRequest;

import model.DAO.EmployeeDAO;

public class EmployeeAutoNumController {
	public void execute(HttpServletRequest request) {
		EmployeeDAO dao = new EmployeeDAO();
		String employeeNum = dao.empAutoNum();
		request.setAttribute("employeeNum", employeeNum);
	}
}
