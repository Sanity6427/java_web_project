package member;

import java.sql.*;
import java.util.*;

public class MemberDAO {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	String url, user, pass;

	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 검색 실패!!");
			e.printStackTrace();
		}

		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "web09";
		pass = "web09";
	}

	public MemberDTO getMember(int no) throws SQLException {
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from member where no = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			List<MemberDTO> list = makeList(rs);
			return list.get(0);
		} finally {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		}
	}
	
	public int checkMember(String name, 
						String ssn1, String ssn2) throws SQLException{
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from jsp_member where "
					+ "ssn1=? and ssn2=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, ssn1);
			ps.setString(2, ssn2);
			rs = ps.executeQuery();
			if (rs.next()) {
				return 1; //결과가 있으면 회원이다
			}else {
				return 0; //결과가 없으면 회원이 아니다
			}
		}finally {
			if (rs != null) rs.close();
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
	
	public List<MemberDTO> makeList(ResultSet rs) throws SQLException{
		List<MemberDTO> list = new ArrayList<>();
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setNo(rs.getInt("no"));
			dto.setName(rs.getString("name"));
			dto.setId(rs.getString("id"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setSsn1(rs.getString("ssn1"));
			dto.setSsn2(rs.getString("ssn2"));
			dto.setEmail(rs.getString("email"));
			dto.setHp1(rs.getString("hp1"));
			dto.setHp2(rs.getString("hp2"));
			dto.setHp3(rs.getString("hp3"));
			dto.setJoindate(rs.getString("joindate"));
			list.add(dto);
		}
		return list;
	}
	
	public int insertMember(MemberDTO dto) throws SQLException{
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "insert into jsp_member values"
				+ "(member_seq.nextval, ?,?,?,?,?,?,?,?,?,sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getId());
			ps.setString(3, dto.getPasswd());
			ps.setString(4, dto.getSsn1());
			ps.setString(5, dto.getSsn2());
			ps.setString(6, dto.getEmail());
			ps.setString(7, dto.getHp1());
			ps.setString(8, dto.getHp2());
			ps.setString(9, dto.getHp3());

			int res = ps.executeUpdate();
			return res;
		}finally {
			if (ps != null) ps.close();
			if (con != null) con.close();
		}
	}
}
