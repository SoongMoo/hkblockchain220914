package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.AuthInfo;

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
	public AuthInfo loginCk(String userId) {
		AuthInfo authInfo = null;
		con = getConnection();
		sql = "select mem_Id user_id, mem_Email user_email,"
				+ "       mem_pw user_pw, 'mem' grade"
				+ " from member "
				+ " where mem_id = ? "
				+ " union "
				+ " select emp_id, emp_email, emp_pw , 'emp'"
				+ " from employee "
				+ " where emp_id = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				authInfo = new AuthInfo();
				authInfo.setGrade(rs.getString("grade"));
				authInfo.setUserEmail(rs.getString("user_email"));
				authInfo.setUserId(rs.getString("user_id"));
				authInfo.setUserPw(rs.getString("user_pw"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authInfo;
	}
}
