package controller.empuser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.EmployeeDAO;
import model.DTO.AuthInfo;
import model.DTO.EmployeeDTO;

public class EmpDetailController {
	public void execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
		String employeeNum = authInfo.getUserId();
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO dto = dao.selectOne(employeeNum);
		request.setAttribute("dto", dto);
	}
}
