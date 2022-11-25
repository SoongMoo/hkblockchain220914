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
	public int memberDelete(String memberId,String memberPw) {
		int i = 0;
		con = getConnection();
		sql = " delete from members "
			+ " where member_id = ? and member_pw = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			i = pstmt.executeUpdate();
			System.out.println(i + "개가 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public void memberUpdate(MemberDTO dto) {
		con = getConnection();
		sql = " update members"
			+ " set MEMBER_PHONE1=?, "
			+ "    MEMBER_ADDR = ? ,  "
			+ "    MEMBER_EMAIL =? "
			+ " where MEMBER_id = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberPhone());
			pstmt.setString(2, dto.getMemberAddr());
			pstmt.setString(3, dto.getMemberEmail());
			pstmt.setString(4, dto.getMemberId());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public MemberDTO selectOne(String memberId) {
		MemberDTO dto = null;
		con = getConnection();
		sql = " select MEMBER_NUM,MEMBER_ID,MEMBER_PW,MEMBER_NAME,MEMBER_PHONE1,"
			+ "     MEMBER_ADDR, MEMBER_GENDER, MEMBER_BIRTH,MEMBER_EMAIL"
			+ " from members "
			+ " where member_id = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
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
	public void userInsert(MemberDTO dto) {
		System.out.println("bngdikjbgiuv");
		con = getConnection();
		sql = " insert into members(MEMBER_NUM,MEMBER_ID,MEMBER_PW,MEMBER_NAME,"
			+ "                    MEMBER_PHONE1,MEMBER_ADDR, MEMBER_GENDER,"
			+ "                    MEMBER_BIRTH,MEMBER_EMAIL) "
			+ " values( concat('mem', mem_seq.nextval ) ,?,?,?,?,?,?,?,?)";
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






