package controller.empuser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.EmployeeDAO;
import model.DTO.AuthInfo;


public class EmpPasswordConController {
	public String execute(HttpServletRequest request) {
		String employeePw = request.getParameter("employeePw");
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
		String employeeNum = authInfo.getUserId();
		EmployeeDAO dao = new EmployeeDAO();
		String ck = dao.empPwCk(employeeNum, employeePw);
		return ck;
 	}
}
