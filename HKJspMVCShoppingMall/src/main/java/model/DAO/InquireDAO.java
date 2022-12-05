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
	public void inquireReplyUpdate(String inquireNum,String   answerReply,
			String employeeNum) {
		con = getConnection();
		sql = " update INQUIRE "
			+" set ANSWER_REPLY = ? "
			+ "    ,EMPLOYEE_NUM = ? "
			+ "    ,ANSWER_DATE = sysdate "
			+ " where INQUIRE_NUM = ?  ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, answerReply);
			pstmt.setString(2, employeeNum);
			pstmt.setString(3, inquireNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<InquireDTO> inquireSelectAll() {
		List<InquireDTO> list = new ArrayList<InquireDTO>();
		con = getConnection();
		sql = " select INQUIRE_NUM,MEMBER_NUM"
			+ "            ,GOODS_NUM,INQUIRE_SUBJECT,INQUIRE_CONTENT"
			+ "            ,EMPLOYEE_NUM,ANSWER_REPLY,ANSWER_DATE "
			+ " from INQUIRE ";
		try {
			pstmt = con.prepareStatement(sql);
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
	public void inquireDelete(String inquireNum) {
		con = getConnection();
		sql="delete from INQUIRE "
		   + " where inquire_Num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inquireNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 살제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void inquireUpdate(String inquireNum
				,String inquireSubject,String  inquireContent) {
		con = getConnection();
		sql = " update INQUIRE "
			+ " set INQUIRE_SUBJECT = ?"
			+ "    ,INQUIRE_CONTENT = ? "
			+ " where inquire_Num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inquireSubject);
			pstmt.setString(2, inquireContent);
			pstmt.setString(3, inquireNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public InquireDTO selectOne(String inquireNum) {
		InquireDTO dto = null;
		con = getConnection();
		sql = " select INQUIRE_NUM,MEMBER_NUM"
				+ "            ,GOODS_NUM,INQUIRE_SUBJECT,INQUIRE_CONTENT"
				+ "            ,EMPLOYEE_NUM,ANSWER_REPLY,ANSWER_DATE "
				+ " from INQUIRE "
				+ " where INQUIRE_NUM = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, inquireNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new InquireDTO();
				dto.setAnswerDate(rs.getDate(8));
				dto.setAnswerReply(rs.getString("ANSWER_REPLY"));
				dto.setEmployeeNum(rs.getString("EMPLOYEE_NUM"));
				dto.setGoodsNum(rs.getString("GOODS_NUM"));
				dto.setInquireContent(rs.getString("INQUIRE_CONTENT"));
				dto.setInquireNum(rs.getLong("INQUIRE_NUM"));
				dto.setInquireSubject(rs.getString("INQUIRE_SUBJECT"));
				dto.setMemberNum(rs.getString("MEMBER_NUM"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	public List<InquireDTO> selectList(String goodsNum){
		List<InquireDTO> list = new ArrayList<InquireDTO>();
		con = getConnection();
		sql = " select INQUIRE_NUM,MEMBER_NUM"
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
