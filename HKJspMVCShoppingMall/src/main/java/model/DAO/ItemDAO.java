package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.CartDTO;
import model.DTO.CartListDTO;

public class ItemDAO {
	String jdbcDriver;
	String jdbcURL;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	public ItemDAO() {
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
	public CartListDTO selectOne(String memberNum, String goodNum) {
		CartListDTO dto = null;
		con = getConnection();
		sql = " select MEMBER_NUM, g.GOODS_NUM, CART_QTY, CART_DATE "
			+ "      , goods_name , CART_QTY * goods_price total_price"
			+ "		 , goods_image "
			+ " from carts c , goods g "
			+ " where c.goods_num = g.goods_num "
			+ " and MEMBER_NUM = ? and  c.goods_num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			pstmt.setString(2, goodNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new CartListDTO();
				dto.setCartDate(rs.getDate("CART_DATE"));
				dto.setCartQty(rs.getInt("CART_QTY"));
				dto.setGoodsName(rs.getString("goods_name"));
				dto.setGoodsNum(rs.getString("GOODS_NUM"));
				dto.setMemberNum(rs.getString("MEMBER_NUM"));
				dto.setTotalPrice(rs.getInt("total_price"));
				dto.setGoodsImage(rs.getString("goods_image"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally { close(); }
		
		
		return dto;
	}
	public void itemDelete(String memberNum, String goodNum) {
		con = getConnection();
		sql = " delete from carts where member_Num = ? and goods_Num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			pstmt.setString(2, goodNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삭되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public void itemQtyDown(String memberNum, String goodNum) {
		System.out.println(memberNum);
		System.out.println(goodNum);
		con = getConnection();
		sql  = " update carts "
			 + " set CART_QTY = CART_QTY - 1 "
			 + " where MEMBER_NUM = ? and GOODS_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			pstmt.setString(2, goodNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public List<CartListDTO> cartList(String memberNum){
		List<CartListDTO> list = new ArrayList();
		con = getConnection();
		sql = " select MEMBER_NUM, g.GOODS_NUM, CART_QTY, CART_DATE "
			+ "      , goods_name , CART_QTY * goods_price total_price"
			+ "		 , goods_image "
			+ " from carts c , goods g "
			+ " where c.goods_num = g.goods_num "
			+ " and MEMBER_NUM = ? ";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CartListDTO dto = new CartListDTO();
				dto.setCartDate(rs.getDate("CART_DATE"));
				dto.setCartQty(rs.getInt("CART_QTY"));
				dto.setGoodsName(rs.getString("goods_name"));
				dto.setGoodsNum(rs.getString("GOODS_NUM"));
				dto.setMemberNum(rs.getString("MEMBER_NUM"));
				dto.setTotalPrice(rs.getInt("total_price"));
				dto.setGoodsImage(rs.getString("goods_image"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}
	public void cartInsert(CartDTO dto) {
		con = getConnection();
		sql = " merge into carts  c"
			+ " using (select * from goods where goods_Num = ? ) g"
			+ " on (c.goods_num = g.goods_num )"
			+ " when matched then"
			+ " update set cart_qty = cart_qty + ?"
			+ " when not matched then"
			+ " insert (MEMBER_NUM,GOODS_NUM, CART_QTY, CART_DATE)"
			+ " values (?,?,?,sysdate)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsNum());
			pstmt.setInt(2, dto.getCartQty());
			
			pstmt.setString(3, dto.getMemberNum());
			pstmt.setString(4, dto.getGoodsNum());
			pstmt.setInt(5, dto.getCartQty());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삽입되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}
	public void close() {
		if(rs != null) try{rs.close();}catch(Exception e) {}
		if(pstmt != null) try{pstmt.close();}catch(Exception e) {}
		if(con != null) try{con.close();}catch(Exception e) {}
	}

}
