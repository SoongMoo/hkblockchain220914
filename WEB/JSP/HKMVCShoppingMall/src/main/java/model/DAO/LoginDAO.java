package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DTO.AuthInfo;
import model.DTO.MemberDTO;

public class LoginDAO {
	String jdbcURL;
	String jdbcDriver;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	public LoginDAO() {
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
	public AuthInfo selectOne(String userId) {
		AuthInfo dto = null;
		con = getConnection();
		sql = " select member_id user_id, member_pw user_pw, member_name user_name"
			+ " from members"
			+ " where member_id = ?"
			+ " union"
			+ " select EMPLOYEE_NUM , EMPLOYEE_pw, employee_name"
			+ " from  employees "
			+ " where EMPLOYEE_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new AuthInfo();
				dto.setUserId(rs.getString("user_id"));
				dto.setUserPw(rs.getString("user_pw"));
				dto.setUserName(rs.getString("user_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
}
