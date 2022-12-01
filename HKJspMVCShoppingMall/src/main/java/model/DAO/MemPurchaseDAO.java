package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DTO.BuyListDTO;
import model.DTO.DeliveryDTO;

public class MemPurchaseDAO {
	String jdbcDriver;
	String jdbcURL;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	public MemPurchaseDAO() {
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
	public void deliveryUpdate(DeliveryDTO dto) {
		con = getConnection();
		sql = " update DELIVERY "
			+ " set DELIVERY_NUM = ? "
			+ "    , DELIVERY_STATE =? "
			+ " where PURCHASE_NUM = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, dto.getDeliveryNum());
			pstmt.setString(2, dto.getDeliveryState());
			pstmt.setLong(3, dto.getPurchaseNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public DeliveryDTO selectOne(String purchaseNum) {
		DeliveryDTO dto = null;
		con = getConnection();
		sql= " select DELIVERY_NUM,PURCHASE_NUM,DELIVERY_DATE"
		   + "	, DELIVERY_STATE"
		   + " from DELIVERY"
		   + " where PURCHASE_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, purchaseNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new DeliveryDTO();
				dto.setDeliveryDate(rs.getDate("DELIVERY_DATE"));
				dto.setDeliveryNum(rs.getLong("DELIVERY_NUM"));
				dto.setPurchaseNum(rs.getLong("PURCHASE_NUM"));
				dto.setDeliveryState(rs.getString("DELIVERY_STATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	public void deliveryInsert(String purchaseNum,String deliveryNum) {
		con = getConnection();
		sql = " insert into DELIVERY(DELIVERY_NUM,PURCHASE_NUM"
			+ "                    ,DELIVERY_DATE, DELIVERY_STATE)"
			+ " values(?, ?, sysdate, '배송중')";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, deliveryNum);
			pstmt.setString(2, purchaseNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public List<BuyListDTO> buySelect() {
		List<BuyListDTO> list = new ArrayList<BuyListDTO>();
		con = getConnection();
		sql = "  select pc.purchase_Num, TOTAL_PRICE, MEMBER_NUM "
			+ "        , CONFORM_NUM , DELIVERY_NUM"
			+ " from purchase pc left outer join payments pm "
			+ " on pc.purchase_Num = pm.purchase_Num "
			+ "						 left outer JOIN  DELIVERY dl"
			+ " ON pc.purchase_Num = dl.purchase_Num";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BuyListDTO dto = new BuyListDTO();
				dto.setConformNum(rs.getLong("CONFORM_NUM"));
				dto.setMemberNum(rs.getString("MEMBER_NUM"));
				dto.setPurchaseNum(rs.getLong("purchase_Num"));
				dto.setTotalPrice(rs.getLong("TOTAL_PRICE"));
				dto.setDeliveryNum(rs.getLong("DELIVERY_NUM"));
				list.add(dto);
				System.out.println(list.size());
				System.out.println(dto.getDeliveryNum());
				System.out.println(dto.getConformNum());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {close();}
		
		return list;
	}
	public void close() {
		if(rs != null) try{rs.close();}catch(Exception e) {}
		if(pstmt != null) try{pstmt.close();}catch(Exception e) {}
		if(con != null) try{con.close();}catch(Exception e) {}
	}
}
