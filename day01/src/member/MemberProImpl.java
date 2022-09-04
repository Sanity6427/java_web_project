package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import sungjuk.Student;

public class MemberProImpl implements MemberPro {
	private Scanner in;
	private List<Member> list;
	
	private String url, user, pass;
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public MemberProImpl() {
		in = new Scanner(System.in);
		list = new ArrayList<>();
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		user = "web09";
		pass = "web09";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 검색 실패!!");
		}
	}

	@Override
	public void insert() {
		System.out.println("이름을 입력 :");
		String name = in.next();
		System.out.println("전화번호를 입력 :");
		String tel = in.next();
		 
		Connection con;
		PreparedStatement ps;
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "insert into java_member values(?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, tel);
			int res = ps.executeUpdate();
			if(res > 0) {
				System.out.println(name + "님을 입력하셨습니다.");
			}else {
				System.out.println(name + "님 입력시 오류 발생!!");
			}
		} catch (SQLException e) {
			System.out.println("insert문에서 에러!!");
		}

	}

	@Override
	public void view() {
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from java_member";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("name") 
						+ "님의 전화번호 :" + rs.getString("tel"));
			}
		} catch (SQLException e) {
			System.out.println("view 메소드 실행중 에러 발생!!");
		}
	}

	@Override
	public void delete() {
		System.out.println("삭제할 회원의 이름 :");
		String name = in.next();
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "delete from java_member where name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			int res = ps.executeUpdate();
			if(res > 0) {
				System.out.println(name + "님을 삭제하였습니다.");
			}else {
				System.out.println(name + "님은 저희 회원이 아닙니다.");
			
	
		}} catch (SQLException e) {
			System.out.println("view 메소드 실행중 에러 발생!!");
		}
	}

	@Override
	public void edit() {
		System.out.println("수정할 회원의 이름 :");
		String name = in.next();
		System.out.println(" 수정하실 번호 :");
		String tel = in.next();
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "update java_member set tel = ?"
					+ "where name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, tel);
			ps.setString(2, name);
			int res = ps.executeUpdate();
			if (res > 0) {
				System.out.println(name + "님을 수정하였스비낟.");
			}else {
				System.out.println(name + "님은 저희 회원이 아닙니다.");
			}
		}catch(SQLException e) {
			
		}
	}

	@Override
	public void exit() {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);

	}

}
