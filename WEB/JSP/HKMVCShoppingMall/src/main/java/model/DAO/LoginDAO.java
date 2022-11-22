package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public MemberDTO selectOne(String userId) {
		MemberDTO dto = null;
		con = getConnection();
		sql = " select MEMBER_NUM,MEMBER_ID,MEMBER_PW,MEMBER_NAME,MEMBER_PHONE1,"
			+ "     MEMBER_ADDR, MEMBER_GENDER, MEMBER_BIRTH,MEMBER_EMAIL"
			+ " from members "
			+ " where member_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setMemberAddr(rs.getString("MEMBER_ADDR"));
				dto.setMemberBirth(rs.getDate("MEMBER_BIRTH"));
				dto.setMemberEmail(rs.getString("MEMBER_EMAIL"));
				dto.setMemberGender(rs.getString("MEMBER_GENDER"));
				dto.setMemberId(rs.getString("MEMBER_ID"));
				dto.setMemberName(rs.getString("MEMBER_NAME"));
				dto.setMemberNum(rs.getString("MEMBER_NUM"));
				dto.setMemberPhone(rs.getString("MEMBER_PHONE1"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
}
