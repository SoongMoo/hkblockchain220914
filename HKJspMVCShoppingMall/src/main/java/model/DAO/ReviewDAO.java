package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReviewDAO {
	String jdbcDriver;
	String jdbcURL;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	public ReviewDAO() {
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		jdbcURL ="jdbc:oracle:thin:@localhost:1521:xe";
	}
	public Connection getConnection() {
		Connection conn= null;
		try {
			Class.forName(jdbcDriver);
			conn = 
			   DriverManager.getConnection(jdbcURL,"hk1234","oracle");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public void close() {
		if(rs != null) try{rs.close();}catch(Exception e) {}
		if(pstmt != null) try{pstmt.close();}catch(Exception e) {}
		if(con != null) try{con.close();}catch(Exception e) {}
	}
	public void reviewInsert(String goodsNum,String reviewSubject,
			String reviewContent,String memberNum) {
		con = getConnection();
		sql = " insert into reviews(REVIEW_NUM, MEMBER_NUM "
			+ "            , GOODS_NUM, REVIEW_SUBJECT "
			+ "            ,REVIEW_CONTENT)"
			+ " values(goods_seq.nextval, ?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			pstmt.setString(2, goodsNum);
			pstmt.setString(3, reviewSubject);
			pstmt.setString(4, reviewContent);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 십입되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {close();}
		
	}
	
	
	
	
	
	
	
	
	
}
