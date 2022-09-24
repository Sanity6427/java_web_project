package student;

import java.sql.*;
import java.util.*;

public class StudentDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	String url, user, pass;
	
	public StudentDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.err.println("드라이버 겁색 실패!!");
			e.printStackTrace();
		}
		
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "web09";
		pass = "web09";
	}
	
	public int insertStudent(String id, String name, 
			String cname) throws SQLException{
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "insert into student values(?, ?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, cname);
			int res = ps.executeUpdate();
			return res;
		}finally {
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
	}
	
	public List<StudentDTO> listStudent() throws SQLException {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from student";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<StudentDTO> list = makeList(rs);
			return list;
		}finally {
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
	}
	
	public int deleteStudent(String id) throws SQLException{
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "delete from student where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			int res = ps.executeUpdate();
			return res;
		}finally {
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
	}
	
	public List<StudentDTO> makeList(ResultSet rs)throws SQLException{
		List<StudentDTO> list = new ArrayList<>();
		while(rs.next()) {
			StudentDTO dto = new StudentDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setCname(rs.getString("cname"));	
			list.add(dto);
		}
		return list;
	}
	
	public List<StudentDTO> findStudent(String name) throws SQLException {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from student where name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			List<StudentDTO> list = makeList(rs);
			return list;
		}finally {
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
	}
	
	
	
}
