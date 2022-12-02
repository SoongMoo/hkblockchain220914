package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.ReviewDTO;
import model.DTO.ReviewDetailDTO;

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
	public List<ReviewDTO> selectAll(String goodsNum){
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		con = getConnection();
		sql = "select REVIEW_NUM , MEMBER_NUM, GOODS_NUM"
			+ ", REVIEW_SUBJECT,REVIEW_CONTENT "
			+ " from reviews "
			+ " where goods_Num = ?";	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setGoodsNum(rs.getString("GOODS_NUM"));
				dto.setMemberNum(rs.getString("MEMBER_NUM"));
				dto.setReviewContent(rs.getString("REVIEW_CONTENT"));
				dto.setReviewNum(rs.getInt("REVIEW_NUM"));
				dto.setReviewSubject(rs.getString("REVIEW_SUBJECT"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	public void reviewDelete(String reviewNum) {
		con = getConnection();
		sql = "delete from reviews "
			+ " where review_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reviewNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	public void reviewUpdate(ReviewDTO dto) {
		con = getConnection();
		sql = "update reviews"
			+ " set review_subject = ?,"
			+ "    review_content = ?"
			+ " where review_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getReviewSubject());
			pstmt.setString(2, dto.getReviewContent());
			pstmt.setInt(3, dto.getReviewNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {close();}
		
	}
	public ReviewDetailDTO reviewDetail(String reviewNum) {
		ReviewDetailDTO dto = null;
		con = getConnection();
		sql= " select goods_image, goods_name, review_subject "
		   + "     , review_content , review_num "
		   + " from goods g, reviews r "
		   + " where g.goods_num = r.goods_num and review_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reviewNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new ReviewDetailDTO(); 
				dto.setGoodsImage(rs.getString("goods_image"));
				dto.setGoodsName(rs.getString("goods_name"));
				dto.setReviewSubject(rs.getString("review_subject"));
				dto.setReviewContent(rs.getString("review_content"));
				dto.setReviewNum(rs.getString("review_num"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
		
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
