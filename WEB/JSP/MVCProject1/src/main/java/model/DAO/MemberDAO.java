package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.MemberDTO;

public class MemberDAO {
	final String COLUMNS = "MEM_NUM,MEM_NAME,MEM_REGI_DATE,MEM_ID,MEM_PW"
			+ "            ,MEM_PHONE1,MEM_PHONE2,MEM_ADDR,MEM_EMAIL,MEM_GENDER,"
			+ "             MEM_birth";
	String jdbcURL;
	String jdbcDriver;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	public MemberDAO() { // 생성자 
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	}
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcURL,"hk1234","oracle");
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	public MemberDTO selectId(String userId) {
		MemberDTO dto = null;
		con = getConnection();
		sql = "select " + COLUMNS + " from member where mem_id = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setMemAddr(rs.getString("mem_addr"));
				dto.setMemBirth(rs.getTimestamp("mem_birth"));
				dto.setMemEmail(rs.getString("mem_email"));
				dto.setMemGender(rs.getString("mem_gender"));
				dto.setMemId(rs.getString("mem_id"));
				dto.setMemName(rs.getString("mem_name"));
				dto.setMemNum(rs.getString("mem_num"));
				dto.setMemPhone1(rs.getString("mem_phone1"));
				dto.setMemPhone2(rs.getString("mem_phone2"));
				dto.setMemPw(rs.getString("mem_pw"));
				dto.setMemRegiDate(rs.getDate("mem_regi_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	public void memberJoin(MemberDTO dto) {
		con = getConnection();
		sql = "insert into member(MEM_NUM,MEM_NAME,MEM_REGI_DATE,MEM_ID,MEM_PW,"
				+ "MEM_PHONE1,MEM_PHONE2, MEM_ADDR,MEM_EMAIL,MEM_birth,mem_gender  )"
				+ "values(("
				+ "select concat('hkusr',nvl(max(substr(MEM_NUM,6)),10000) + 1 ) from member),"
				+ "?, sysdate,?,?,?,?,?,?,?,? )";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,dto.getMemName() );
			pstmt.setString(2,dto.getMemId() );
			pstmt.setString(3,dto.getMemPw() );
			pstmt.setString(4,dto.getMemPhone1() );
			pstmt.setString(5,dto.getMemPhone2() );
			pstmt.setString(6,dto.getMemAddr() );
			pstmt.setString(7,dto.getMemEmail() );
			pstmt.setDate(8,new java.sql.Date(dto.getMemBirth().getTime()));
			pstmt.setString(9, dto.getMemGender());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void memberDelete(String num) {
		con = getConnection();
		sql = "delete from member where mem_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삭재되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void memberUpdate(MemberDTO dto) {
		con = getConnection();
		sql = " update member "
			+ " set MEM_NAME = ?, MEM_REGI_DATE = ?, "
			+ "    MEM_ID = ? , MEM_PHONE1 = ?, "
			+ "    MEM_PHONE2 = ?, MEM_ADDR = ?, "
			+ "    MEM_EMAIL = ?, MEM_GENDER =?, "
			+ "    MEM_birth = ? "
			+ " where mem_num = ? ";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemName());
			pstmt.setDate(2, new java.sql.Date(dto.getMemRegiDate().getTime()));
			pstmt.setString(3, dto.getMemId());
			pstmt.setString(4, dto.getMemPhone1());
			pstmt.setString(5, dto.getMemPhone2());
			pstmt.setString(6, dto.getMemAddr());
			pstmt.setString(7, dto.getMemEmail());
			pstmt.setString(8, dto.getMemGender());
			pstmt.setDate(9, new java.sql.Date(dto.getMemBirth().getTime()));
			pstmt.setString(10, dto.getMemNum());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수 정되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public MemberDTO selectOne(String num) {
		MemberDTO dto = null;
		con = getConnection();
		sql = "select " + COLUMNS + " from member where mem_num = ? ";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setMemAddr(rs.getString("mem_addr"));
				dto.setMemBirth(rs.getDate("mem_birth"));
				dto.setMemEmail(rs.getString("mem_email"));
				dto.setMemGender(rs.getString("mem_gender"));
				dto.setMemId(rs.getString("mem_id"));
				dto.setMemName(rs.getString("mem_name"));
				dto.setMemNum(rs.getString("mem_num"));
				dto.setMemPhone1(rs.getString("mem_phone1"));
				dto.setMemPhone2(rs.getString("mem_phone2"));
				dto.setMemPw(rs.getString("mem_pw"));
				dto.setMemRegiDate(rs.getDate("mem_regi_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	public List<MemberDTO> selectAll(){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		con = getConnection();
		sql = "select " + COLUMNS + " from member";
		try {
			pstmt = con.prepareStatement(sql);
			rs  = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setMemAddr(rs.getString("mem_addr"));
				dto.setMemBirth(rs.getDate("mem_birth"));
				dto.setMemEmail(rs.getString("mem_email"));
				dto.setMemGender(rs.getString("mem_gender"));
				dto.setMemId(rs.getString("mem_id"));
				dto.setMemName(rs.getString("mem_name"));
				dto.setMemNum(rs.getString("mem_num"));
				dto.setMemPhone1(rs.getString("mem_phone1"));
				dto.setMemPhone2(rs.getString("mem_phone2"));
				dto.setMemPw(rs.getString("mem_pw"));
				dto.setMemRegiDate(rs.getDate("mem_regi_date"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void memberInsert(MemberDTO dto) {
		con = getConnection();
		sql = "insert into member(" + COLUMNS + ")"
			+ " values(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemNum());
			pstmt.setString(2, dto.getMemName());
			pstmt.setDate(3, new java.sql.Date(dto.getMemRegiDate().getTime()));
			pstmt.setString(4, dto.getMemId());
			pstmt.setString(5, dto.getMemPw());
			pstmt.setString(6, dto.getMemPhone1());
			pstmt.setString(7, dto.getMemPhone2());
			pstmt.setString(8, dto.getMemAddr());
			pstmt.setString(9, dto.getMemEmail());
			pstmt.setString(10, dto.getMemGender());
			pstmt.setDate(11, new java.sql.Date(dto.getMemBirth().getTime()));
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삽입되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
}
