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
import model.DTO.PaymentDTO;
import model.DTO.PurchaseDTO;
import model.DTO.PurchaseInfoDTO;
import model.DTO.PurchaseListDTO;

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
	public String wishSelect(String goodsNum,String memberNum) {
		String str= null;
		con = getConnection();
		sql = " select goods_num from wish "
			+ " where goods_num = ? and member_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			pstmt.setString(2, memberNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				str = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
		
	}
	public void wishItem(String goodsNum,String memberNum) {
		con = getConnection();
		sql = " merge into wish w "
			+ " using (select goods_num from goods where goods_num = ? ) g "
			+ " on (w.goods_num = g.goods_num and w.member_num = ?) "
			+ " When MATCHED THEN "
			+ "    update set WISH_DATE = sysdate "
			+ "    delete where member_num = ? and goods_num = ? "
			+ " When not MATCHED THEN "
			+ "    insert (MEMBER_NUM, GOODS_NUM, WISH_DATE) "
			+ "    values(?,?,sysdate) ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			pstmt.setString(2, memberNum);
			pstmt.setString(3, memberNum);
			pstmt.setString(4, goodsNum);
			pstmt.setString(5, memberNum);
			pstmt.setString(6, goodsNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 병합되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public void paymentDelete(String purchaseNum) {
		con = getConnection();
		sql = "delete from payments "
			+ " where purchase_Num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, purchaseNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
	}
	public void paymentInsert(PaymentDTO dto) {
		con = getConnection();
		sql = "insert into payments(PURCHASE_NUM,PAYMENT_METHOD,"
				+ "        PAYMENT_DATE,CONFORM_DATE,PAYMENT_COMPANY,"
				+ "        CONFORM_NUM, CARD_NUM)"
				+ "values(?, ?, sysdate , sysdate, ?,"
				+ "        to_char(sysdate,'yymmddMMss'),?)";
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, dto.getPurchaseNum());
			pstmt.setString(2, dto.getPaymentMethod());
			pstmt.setString(3, dto.getPaymentCompany());
			pstmt.setString(4, dto.getCarNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public int totalPrice(String purchaseNum) {
		int totalPrice = 0;
		con = getConnection();
		sql = " select TOTAL_PRICE "
			+ " from purchase "
			+ " where PURCHASE_NUM = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, purchaseNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalPrice = rs.getInt("TOTAL_PRICE");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return totalPrice;
	}
	public List<PurchaseInfoDTO> purchaseItemSelect(String memberNum){
		List<PurchaseInfoDTO> list = new ArrayList<PurchaseInfoDTO>();
		con = getConnection();
		sql = " select g.goods_num, goods_image, goods_name,p.purchase_num "
				+ "   , p.member_num "
				+ "   , conform_num , delivery_state , review_num "
				+ "   , goods_price * PURCHASE_QTY total_price"
				+ " from goods g join purchase_list pl "
				+ " on g.goods_num = pl.goods_num join  purchase p"
				+ " on pl.purchase_num = p.purchase_num left outer join payments pm"
				+ " on p.purchase_num = pm.purchase_num left outer join delivery d"
				+ " on p.purchase_num = d.purchase_num left outer join reviews re"
				+ " on g.goods_num = re.goods_num"
				+ " where p.member_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PurchaseInfoDTO dto = new PurchaseInfoDTO();
				dto.setConformNum(rs.getString("conform_num"));
				dto.setDeliveryState(rs.getString("delivery_state"));
				dto.setGoodsImage(rs.getString("goods_image"));
				dto.setGoodsName(rs.getString("goods_name"));
				dto.setGoodsNum(rs.getString("goods_num"));
				dto.setMemberNum(rs.getString("member_num"));
				dto.setPurchaseNum(rs.getInt("purchase_num"));
				dto.setReviewNum(rs.getString("review_num"));
				dto.setTotalPrice(rs.getInt("total_price"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	public void cartItemDelete(String goodsNum,String memberNum) {
		con = getConnection();
		sql = "delete from carts "
			+ " where MEMBER_NUM = ? and GOODS_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberNum);
			pstmt.setString(2, goodsNum);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {close();}
	}
	public int purchaseListInsert(PurchaseListDTO dto, String memberNum) {
		int i = 0;
		con = getConnection();
		sql = " insert into purchase_list(PURCHASE_NUM, GOODS_NUM, PURCHASE_QTY)"
			+ " select ? ,GOODS_NUM, CART_QTY  from carts"
			+ " where MEMBER_NUM = ? and GOODS_NUM = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getPurchaseNum());
			pstmt.setString(2, memberNum);
			pstmt.setString(3, dto.getGoodsNum());
			i = pstmt.executeUpdate();
			System.out.println(i + "개가 삽입되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public void purchaseInsert(PurchaseDTO dto) {
		con = getConnection();
		sql = "insert into purchase(PURCHASE_NUM,TOTAL_PRICE"
			+ "        ,LOCATION, RECEIVE_PHONE,RECEIVE_NAME"
			+ "        ,MEMBER_NUM)"
			+ "values(?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getPuchaseNum());
			pstmt.setInt(2, dto.getTotalPrice());
			pstmt.setString(3, dto.getLocation());
			pstmt.setString(4, dto.getReceivePhone());
			pstmt.setString(5, dto.getReceiveName());
			pstmt.setString(6, dto.getMemberNum());
			int i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public int purchaseNum() {
		int i = 0;
		con = getConnection();
		sql = " select to_char(sysdate,'mmdd') || purcase_seq.NEXTVAL "
			+ " from dual";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			i = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return i;
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
