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
			System.out.println("����Ŭ ����̹� �˻� ����!!");
		}
	}

	@Override
	public void insert() {
		System.out.println("�̸��� �Է� :");
		String name = in.next();
		System.out.println("��ȭ��ȣ�� �Է� :");
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
				System.out.println(name + "���� �Է��ϼ̽��ϴ�.");
			}else {
				System.out.println(name + "�� �Է½� ���� �߻�!!");
			}
		} catch (SQLException e) {
			System.out.println("insert������ ����!!");
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
						+ "���� ��ȭ��ȣ :" + rs.getString("tel"));
			}
		} catch (SQLException e) {
			System.out.println("view �޼ҵ� ������ ���� �߻�!!");
		}
	}

	@Override
	public void delete() {
		System.out.println("������ ȸ���� �̸� :");
		String name = in.next();
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "delete from java_member where name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			int res = ps.executeUpdate();
			if(res > 0) {
				System.out.println(name + "���� �����Ͽ����ϴ�.");
			}else {
				System.out.println(name + "���� ���� ȸ���� �ƴմϴ�.");
			
	
		}} catch (SQLException e) {
			System.out.println("view �޼ҵ� ������ ���� �߻�!!");
		}
	}

	@Override
	public void edit() {
		System.out.println("������ ȸ���� �̸� :");
		String name = in.next();
		System.out.println(" �����Ͻ� ��ȣ :");
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
				System.out.println(name + "���� �����Ͽ�����.");
			}else {
				System.out.println(name + "���� ���� ȸ���� �ƴմϴ�.");
			}
		}catch(SQLException e) {
			
		}
	}

	@Override
	public void exit() {
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);

	}

}
