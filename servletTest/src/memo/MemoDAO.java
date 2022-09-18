package memo;

import java.sql.*;
import java.util.*;

public class MemoDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private String url, user, pass;
	
	public MemoDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "web09";
		pass = "web09";
	}
	
	public int insertMemo(String id, String email, String memo) {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "insert into memo values(?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, email);
			ps.setString(3, memo);
			int res = ps.executeUpdate();
			return res;
		}catch(SQLException e) {
			System.out.println("insertMemo 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
			return 0;
		}finally {
			try {
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}
		}
	}
	
	public List<MemoDTO> listMemo(){
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from memo";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<MemoDTO> list = new ArrayList<>();
			while(rs.next()) {
				MemoDTO dto = new MemoDTO();
				dto.setId(rs.getString("id"));
				dto.setEmail(rs.getString("email"));
				dto.setMemo(rs.getString("memo"));
				list.add(dto);
			}
			return list;
		}catch(SQLException e) {
			System.out.println("listMemo 메소드 실행 중 오류 발생!!");
			e.printStackTrace();
			return null;
		}finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			}catch(SQLException e) {}
		}
	}
}







