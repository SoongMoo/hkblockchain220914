package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.InquireDTO;

public class InquireDAO {
	String jdbcURL;
	String jdbcDriver;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	public InquireDAO() {
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
	public List<InquireDTO> selectList(String goodsNum){
		List<InquireDTO> list = new ArrayList<InquireDTO>();
		con = getConnection();
		sql = "select INQUIRE_NUM,MEMBER_NUM"
			+ "            ,GOODS_NUM,INQUIRE_SUBJECT,INQUIRE_CONTENT"
			+ "            ,EMPLOYEE_NUM,ANSWER_REPLY,ANSWER_DATE "
			+ " from INQUIRE "
			+ " where GOODS_NUM = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				InquireDTO dto = new InquireDTO();
				dto.setAnswerDate(rs.getDate(8));
				dto.setAnswerReply(rs.getString("ANSWER_REPLY"));
				dto.setEmployeeNum(rs.getString("EMPLOYEE_NUM"));
				dto.setGoodsNum(rs.getString("GOODS_NUM"));
				dto.setInquireContent(rs.getString("INQUIRE_CONTENT"));
				dto.setInquireNum(rs.getLong("INQUIRE_NUM"));
				dto.setInquireSubject(rs.getString("INQUIRE_SUBJECT"));
				dto.setMemberNum(rs.getString("MEMBER_NUM"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public void inquireInsert(InquireDTO dto) {
		con = getConnection();
		sql = "insert into inquire(INQUIRE_NUM,MEMBER_NUM"
			+ "            ,GOODS_NUM,INQUIRE_SUBJECT,INQUIRE_CONTENT"
			+ "            ,EMPLOYEE_NUM,ANSWER_REPLY,ANSWER_DATE )"
			+ "values(emp_seq.nextval, ?, ?,?,?, null, null, null)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemberNum());
			pstmt.setString(2, dto.getGoodsNum());
			pstmt.setString(3, dto.getInquireSubject());
			pstmt.setString(4, dto.getInquireContent());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삽입되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
