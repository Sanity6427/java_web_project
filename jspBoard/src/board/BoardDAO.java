package board;

import java.sql.*;
import java.util.*;

public class BoardDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	String url, user, pass;
	
	public BoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.err.println("드라이버 검색 실패!!");
			e.printStackTrace();
		}
		
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "web09";
		pass = "web09";
	}
	
	public List<BoardDTO> listBoard() throws SQLException{
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from board order by num desc";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<BoardDTO> list = makeList(rs);
			return list;
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public List<BoardDTO> makeList(ResultSet rs) throws SQLException{
		List<BoardDTO> list = new ArrayList<>();
		while(rs.next()) {
			BoardDTO dto = new BoardDTO();
			dto.setNum(rs.getInt("num"));
			dto.setWriter(rs.getString("writer"));
			dto.setEmail(rs.getString("email"));
			dto.setSubject(rs.getString("subject"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setReg_date(rs.getString("reg_date"));
			dto.setReadcount(rs.getInt("readcount"));
			dto.setContent(rs.getString("content"));
			dto.setIp(rs.getString("ip"));
			list.add(dto);
		}
		return list;
	}
	
	public int insertBoard(BoardDTO dto) throws SQLException{
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "insert into board values"
				+ "(board_seq.nextval, ?,?,?,?,sysdate,0, ?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getWriter());
			ps.setString(2, dto.getEmail());
			ps.setString(3, dto.getSubject());
			ps.setString(4, dto.getContent());
			ps.setString(5, dto.getContent());
			ps.setString(6, dto.getIp());
			int res = ps.executeUpdate();
			return res;
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	protected void plusReadcount(int num) throws SQLException{
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "update board set readcount = "
								+ "readcount + 1 where num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			ps.executeUpdate();
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public BoardDTO getBoard(int num, String mode) 
											throws SQLException {
		if (mode.equals("content")) {
			plusReadcount(num);
		}
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from board where num = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			List<BoardDTO> list = makeList(rs);
			return list.get(0);
			//num은 primary key값이라 1개의 값만 반환이 되서 온다.
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public int deleteBoard(int num, String passwd) throws SQLException{
		
			BoardDTO dto = getBoard(num, "password");
			if(dto.getPasswd().equals(passwd)) {
				try {	
					con = DriverManager.getConnection(url, user, pass);
					String sql = "delete from board where num = ?";
					ps = con.prepareStatement(sql);
					ps.setInt(1, num);
					int res = ps.executeUpdate();
					return res;
				}finally {
					if (rs != null) rs.close();
					if (ps != null) ps.close();
					if (con != null) con.close();
				}
			}else {
				return -1;
			}
		
	}
	
	
	public int updateBoard(BoardDTO dto)
							throws SQLException {
		BoardDTO dto2 = getBoard(dto.getNum(), "password");
		if(dto2.getPasswd().equals(dto.getPasswd())) {
			try {	
				con = DriverManager.getConnection(url, user, pass);
				String sql = "update board set subject=?, email=?, content=? where num = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, dto.getSubject());
				ps.setString(2, dto.getEmail());
				ps.setString(3, dto.getContent());
				ps.setInt(4, dto.getNum());
				int res = ps.executeUpdate();
				return res;
			}finally {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			}
		}else {
			return -1;
		}
	}
}









