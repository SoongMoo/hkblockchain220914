package controller.empuser;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DAO.EmployeeDAO;
import model.DTO.AuthInfo;
import model.DTO.EmployeeDTO;

public class EmpModifyController {
	public void execute(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("dto");
		String employeeNum = authInfo.getUserId();
		String employeePhone= request.getParameter("employeePhone");
		String employeeAddr= request.getParameter("employeeAddr");
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployeeAddr(employeeAddr);
		dto.setEmployeePhone(employeePhone);
		dto.setEmployeeNum(employeeNum);
		
		EmployeeDAO dao = new EmployeeDAO();
		dao.empUpdate(dto);	
	}
}
