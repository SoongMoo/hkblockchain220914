package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.EmployeeDTO;

public class EmployeeDAO {
	String jdbcURL;
	String jdbcDriver;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	public EmployeeDAO() {
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	}
	public Connection getConnection() {
		Connection conn= null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcURL,"hk1234","oracle");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public String empAutoNum() {
		String employeeNum=null;
		con = getConnection();
		sql = "select emp_seq.nextval from dual";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			employeeNum = "emp"+rs.getString("nextval");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeNum;
	}
	public String empPwCk(String employeeNum,String employeePw ) {
		String ck = null;
		con = getConnection();
		sql = " select 1 from employees "
			+ " where employee_num = ? "
			+ " and employee_pw = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employeeNum);
			pstmt.setString(2, employeePw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ck = rs.getString("1");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ck;
	}
	public void empPassword(String employeePw,
			String employeeNum ) {
		con = getConnection();
		sql = " update employees "
			+ " set employee_pw = ? "
			+ " where employee_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employeePw);
			pstmt.setString(2, employeeNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void employeeDelete(String num) {
		con = getConnection();
		sql =" delete from employees "
			+ " where EMPLOYEE_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삭제되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void empUpdate(EmployeeDTO dto) {
		con = getConnection();
		sql = " update employees"
			+ " set EMPLOYEE_ADDR = ?,"
			+ "     EMPLOYEE_PHONE =?"
			+ " where EMPLOYEE_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmployeeAddr());
			pstmt.setString(2, dto.getEmployeePhone());
			pstmt.setString(3, dto.getEmployeeNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void employeeUpdate(EmployeeDTO dto) {
		con = getConnection();
		sql = " update employees"
			+ " set EMPLOYEE_NAME = ?, EMPLOYEE_ADDR = ?,"
			+ "     EMPLOYEE_PHONE =?, EMPLOYEE_HIRE_DATE=?"
			+ " where EMPLOYEE_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmployeeName());
			pstmt.setString(2, dto.getEmployeeAddr());
			pstmt.setString(3, dto.getEmployeePhone());
			pstmt.setDate(4, 
				new java.sql.Date(dto.getEmployeeHireDate().getTime()));
			pstmt.setString(5, dto.getEmployeeNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public EmployeeDTO selectOne(String employeeNum) {
		EmployeeDTO dto = null;
		con = getConnection();
		sql = "select EMPLOYEE_NUM,EMPLOYEE_PW,employee_phone, EMPLOYEE_NAME,"
			+ "       EMPLOYEE_ADDR,EMPLOYEE_HIRE_DATE"
			+ " from employees"
			+ " where EMPLOYEE_NUM = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, employeeNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new EmployeeDTO();
				dto.setEmployeeAddr(rs.getString("EMPLOYEE_ADDR"));
				dto.setEmployeeHireDate(rs.getDate(6));
				dto.setEmployeeName(rs.getString("EMPLOYEE_NAME"));
				dto.setEmployeeNum(rs.getString(1));
				dto.setEmployeePhone(rs.getString(3));
				dto.setEmployeePw(rs.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	
	public List<EmployeeDTO> selectAll(){
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		con = getConnection();
		sql= "select EMPLOYEE_NUM,EMPLOYEE_PW,employee_phone, EMPLOYEE_NAME,"
		  + "       EMPLOYEE_ADDR,EMPLOYEE_HIRE_DATE"
		  + " from employees";
		try {
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmployeeDTO dto = new EmployeeDTO();
				dto.setEmployeeAddr(rs.getString("EMPLOYEE_ADDR"));
				dto.setEmployeeHireDate(rs.getDate(6));
				dto.setEmployeeName(rs.getString("EMPLOYEE_NAME"));
				dto.setEmployeeNum(rs.getString(1));
				dto.setEmployeePhone(rs.getString(3));
				dto.setEmployeePw(rs.getString(2));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void employeeInsert(EmployeeDTO dto) {
		con = getConnection();
		sql = "insert into employees(EMPLOYEE_NUM,EMPLOYEE_PW,EMPLOYEE_NAME,"
			+ "                      EMPLOYEE_ADDR,EMPLOYEE_PHONE, EMPLOYEE_HIRE_DATE)"
			+ "values(?,?,?,?,?,?)";
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, dto.getEmployeeNum());
			pstmt.setString(2, dto.getEmployeePw());
			pstmt.setString(3, dto.getEmployeeName());
			pstmt.setString(4, dto.getEmployeeAddr());
			pstmt.setString(5, dto.getEmployeePhone());
			pstmt.setDate(6, new java.sql.Date(dto.getEmployeeHireDate().getTime()));
			int i = pstmt.executeUpdate();
			System.out.println(i + "개행이 삽입되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
