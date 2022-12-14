package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.GoodsDTO;

public class GoodsDAO {
	String jdbcURL;
	String jdbcDriver;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	public GoodsDAO() {
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
	public String goodsAutoNum() {
		String goodsNum= null;
		con = getConnection();
		sql = "select goods_seq.nextval from dual";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			goodsNum = "gd"+rs.getString("nextval");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return goodsNum;
	}
	public void goodsDelete(String goodsNum) {
		con = getConnection();
		sql = " delete from goods "
			+ " where goods_num =? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void goodsUpdate(GoodsDTO dto) {
		con = getConnection();
		sql = " update goods"
			+ " set GOODS_NAME = ?, GOODS_PRICE = ?"
			+ "   , GOODS_CONTENT = ? "
			+ "   , COMPANY = ?, GOODS_UPD_DATE = sysdate"
			+ "   , EMPLOYEE_UPT_NUM = ?"
			+ " where GOODS_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsName());
			pstmt.setInt(2, dto.getGoodsPrice());
			pstmt.setString(3, dto.getGoodsContent());
			pstmt.setString(4, dto.getCompany());
			pstmt.setString(5,dto.getEmployeeUptNum() );
			pstmt.setString(6, dto.getGoodsNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public GoodsDTO selectOne(String goodsNum) {
		GoodsDTO dto = null;
		con = getConnection();
		sql = " select GOODS_NUM, GOODS_NAME, GOODS_PRICE, GOODS_CONTENT, "
				+ "	      GOODS_IMAGE,"
				+ "      COMPANY, GOODS_REGI_DATE, GOODS_UPD_DATE,"
				+ "      EMPLOYEE_NUM, EMPLOYEE_UPT_NUM "
				+ " from goods"
				+ " where GOODS_NUM = ? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new GoodsDTO();
				dto.setCompany(rs.getString("COMPANY"));
				dto.setEmployeeNum(rs.getString("EMPLOYEE_NUM"));
				dto.setEmployeeUptNum(rs.getString("EMPLOYEE_UPT_NUM"));
				dto.setGoodsContent(rs.getString("GOODS_CONTENT"));
				dto.setGoodsName(rs.getString("GOODS_NAME"));
				dto.setGoodsNum(rs.getString("GOODS_NUM"));
				dto.setGoodsPrice(rs.getInt("GOODS_PRICE"));
				dto.setGoodsRegiDate(rs.getDate("GOODS_REGI_DATE"));
				dto.setGoodsUptDate(rs.getDate("GOODS_UPD_DATE"));
				dto.setGoodsImage(rs.getString("GOODS_IMAGE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}
	public List<GoodsDTO> selectAll(){
		List<GoodsDTO> list = new ArrayList<GoodsDTO>();
		con = getConnection();
		sql = " select GOODS_NUM, GOODS_NAME, GOODS_PRICE, GOODS_CONTENT, "
			+ "	      GOODS_IMAGE,"
			+ "      COMPANY, GOODS_REGI_DATE, GOODS_UPD_DATE,"
			+ "      EMPLOYEE_NUM, EMPLOYEE_UPT_NUM "
			+ " from goods";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GoodsDTO dto = new GoodsDTO();
				dto.setCompany(rs.getString("COMPANY"));
				dto.setEmployeeNum(rs.getString("EMPLOYEE_NUM"));
				dto.setEmployeeUptNum(rs.getString("EMPLOYEE_UPT_NUM"));
				dto.setGoodsContent(rs.getString("GOODS_CONTENT"));
				dto.setGoodsName(rs.getString("GOODS_NAME"));
				dto.setGoodsNum(rs.getString("GOODS_NUM"));
				dto.setGoodsPrice(rs.getInt("GOODS_PRICE"));
				dto.setGoodsRegiDate(rs.getDate("GOODS_REGI_DATE"));
				dto.setGoodsUptDate(rs.getDate("GOODS_UPD_DATE"));
				dto.setGoodsImage(rs.getString("GOODS_IMAGE"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public void goodsInsert(GoodsDTO dto) {
		con = getConnection();
		sql  =" insert into goods(GOODS_NUM,GOODS_NAME,GOODS_PRICE,GOODS_CONTENT,"
			+ "                GOODS_IMAGE, COMPANY, GOODS_REGI_DATE, GOODS_UPD_DATE,"
			+ "                EMPLOYEE_NUM, EMPLOYEE_UPT_NUM)"
			+ " values(?,?,?,?,?,?,sysdate,sysdate,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsNum());
			pstmt.setString(2, dto.getGoodsName());
			pstmt.setInt(3, dto.getGoodsPrice());
			pstmt.setString(4, dto.getGoodsContent());
			pstmt.setString(5, dto.getGoodsImage());
			pstmt.setString(6, dto.getCompany());
			pstmt.setString(7, dto.getEmployeeNum());
			pstmt.setString(8, dto.getEmployeeNum());
            int i = pstmt.executeUpdate();
            System.out.println(i +"개가 삽입되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
