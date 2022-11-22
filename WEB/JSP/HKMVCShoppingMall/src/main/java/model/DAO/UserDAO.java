package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DTO.MemberDTO;

public class UserDAO {
	String jdbcDriver;
	String jdbcURL;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	public  UserDAO() {
		jdbcDriver="oracle.jdbc.driver.OracleDriver";
		jdbcURL="jdbc:oracle:thin:@localhost:1521:xe";
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
	public void userInsert(MemberDTO dto) {
		System.out.println("bngdikjbgiuv");
		con = getConnection();
		sql = " insert into members(MEMBER_NUM,MEMBER_ID,MEMBER_PW,MEMBER_NAME,"
			+ "                    MEMBER_PHONE1,MEMBER_ADDR, MEMBER_GENDER,"
			+ "                    MEMBER_BIRTH,MEMBER_EMAIL) "
			+ " values(( select nvl(max(MEMBER_NUM),0) + 1 from members "
			+ "        ),?,?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberId());
			pstmt.setString(2, dto.getMemberPw());
			pstmt.setString(3, dto.getMemberName());
			pstmt.setString(4, dto.getMemberPhone());
			pstmt.setString(5, dto.getMemberAddr());
			pstmt.setString(6, dto.getMemberGender());
			pstmt.setDate(7,new java.sql.Date(dto.getMemberBirth().getTime()));
			pstmt.setString(8, dto.getMemberEmail());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
}






