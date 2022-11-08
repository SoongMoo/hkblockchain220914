package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BoardDTO;

public class BoardDAO {
	////
	String jdbcURL;
	String jdbcDriver;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	public BoardDAO() {
		jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	}
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(jdbcURL,"hk1234","oracle");
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	////
	public List<BoardDTO> selectAll() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		con = getConnection();
		sql=" select board_num,board_writer,board_subject, "
			+ " board_content,writer_ip,visit_count,board_date "
			+ " from board "
			+ " order by board_num desc ";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// 출력될 모든 레코드를갖디고 옮 
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoardContent(rs.getString("board_content"));
				dto.setBoardNum(rs.getInt("BOARD_NUM"));
				dto.setBoardSubject(rs.getString("BOARD_SUBJECT"));
				dto.setBoardWriter(rs.getString("BOARD_WRITER"));
				dto.setVisitCount(rs.getInt("VISIT_COUNT"));
				dto.setWriterIp(rs.getString("WRITER_IP"));
				dto.setBoardDate(rs.getDate("board_date"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void boardInsert(BoardDTO dto) {
		con = getConnection();
		sql = "insert into board(board_num,board_writer,board_subject,"
				+ "board_content,writer_ip,visit_count)"
				+ "values((  select nvl(max(board_num), 0) + 1 from board    ), "
				+ "?, ?, ?, ?, 0)";
		try {
			// sql문을 넘겨 받은 데이터베이스 정보를 가지고 와 pstmt에 전달 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardWriter());
			pstmt.setString(2, dto.getBoardSubject());
			pstmt.setString(3, dto.getBoardContent());
			pstmt.setString(4, dto.getWriterIp());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 삽입되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
