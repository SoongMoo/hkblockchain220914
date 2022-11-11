package model.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.EmployeeDTO;

public class EmployeeDAO{
	final String COLUMNS = "EMP_NUM,EMP_NAME,EMP_ID, EMP_PW,"
			+ "EMP_HIRE_DATE, EMP_EMAIL,EMP_SALARY,EMP_PHONE"; 
	
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
		Connection conn = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcURL,"hk1234","oracle");
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public String selectEmpNum(String empId) {
		String empNum = null;
		con = getConnection();
		String sql = "select emp_num from employee where emp_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				empNum= rs.getString(1);
			}
		}catch(Exception e) {e.printStackTrace();}
		finally{close();};
		return empNum;
	}
	public void empDelete(String num) {
		con = getConnection();
		String sql = " delete from employee where emp_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			int i = pstmt.executeUpdate();
			System.out.println(i +" 개 행이(가) 삭제되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
		
	}
	public EmployeeDTO selectOne(String num) {
		EmployeeDTO dto = new EmployeeDTO();
		con = getConnection();
		String sql = "select " + COLUMNS + " from employee "
				+ " where emp_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setEmpNum(rs.getInt("emp_num"));
				dto.setEmpName(rs.getString("emp_name"));
				dto.setEmpId(rs.getString(3));
				dto.setEmpPhone(rs.getString("EMP_PHONE"));
				dto.setEmpEmail(rs.getString("emp_email"));
				dto.setEmpHireDate(
						new java.util.Date(
								rs.getDate("emp_hire_date").getTime()));
				dto.setEmpPw(rs.getString("emp_pw"));
				dto.setEmpSalary(rs.getInt("emp_salary"));
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
		return dto;
	}
	
	public List<EmployeeDTO> selectAll(){
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		con = getConnection();
		String sql = " select " + COLUMNS + " FROM employee "
				+ " order by EMP_NUM desc ";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();		
			while(rs.next()) { // rs가 레코드 하나
				// rs에 있는 컬럼 값을 dto의 멤버 필드에 저장
				EmployeeDTO dto = new EmployeeDTO();
				dto.setEmpEmail(rs.getString("EMP_EMAIL"));
				// sql.date ==> util.date
				dto.setEmpHireDate(
						new java.util.Date(
								rs.getDate("EMP_HIRE_DATE").getTime()));
				
				dto.setEmpId(rs.getString("emp_id"));
				dto.setEmpName(rs.getString("emp_name"));
				dto.setEmpNum(rs.getInt("emp_num"));
				dto.setEmpPhone(rs.getString("emp_phone"));
				dto.setEmpPw(rs.getString("emp_pw"));
				dto.setEmpSalary(rs.getInt("emp_salary"));
				list.add(dto); //dto는 레코드(행) 하나이다.
			}
		}catch(Exception e) {e.printStackTrace();
		}finally { close();	}
		
		return list;
	}
	public void employeeInsert(EmployeeDTO dto) {
		con = getConnection();
		String sql = "insert into employee("+ COLUMNS +")"
				+ " values(?,?,?,?,?,?,?,?)"; //DTO
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getEmpNum());
			pstmt.setString(2, dto.getEmpName());
			pstmt.setString(3, dto.getEmpId());
			pstmt.setString(4, dto.getEmpPw());
			/// util.Date를 sql.Date변환
			pstmt.setDate(5, new Date(dto.getEmpHireDate().getTime()));
			
			pstmt.setString(6, dto.getEmpEmail());
			pstmt.setInt(7, dto.getEmpSalary());
			pstmt.setString(8, dto.getEmpPhone());
			int i = pstmt.executeUpdate();
			System.out.println(i + " 개 행이(가) 삽입되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
	}
	
	public void close() {
		if(rs != null) try{rs.close();}catch(Exception e) {}
		if(pstmt != null) try{pstmt.close();}catch(Exception e) {}
		if(con != null) try{con.close();}catch(Exception e) {}
	}
}