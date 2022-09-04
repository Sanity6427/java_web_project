package sungjuk;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.io.*;
import java.sql.*;

public class StudentProImpl implements StudentPro {

	private Hashtable<String, Student> ht; // �ؽ����̺��� ���� ���� : �ؽ����� ��Ƽ �����忡�� ȿ�������� ����
	// but ������Ʈ�� ��Ƽ �����尡 default, so use hashtable
	private Scanner in;
	
	private File data, dir;

	public StudentProImpl() {
		ht = new Hashtable<>();
		in = new Scanner(System.in);
		dir = new File("D:\\09_java_project\\Workspace\\day01\\src\\sungjuk");
		data = new File(dir, "data.txt");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.out.println("����Ŭ ����̹� �˻� ����!!");
		}
	}
	
	
	
	

	@Override
	public void insert() {
		String name;
		while (true) {
			System.out.println("�̸��� �Է� :");
			name = in.next();
			if (ht.containsKey(name)) {
				System.out.println("������ �̸��� �ֽ��ϴ�. �ٽ� �Է��� �ּ���!!");
			} else {
				break;
			}
		}

		System.out.println("���������� �Է� :");
		int kor = in.nextInt();
		System.out.println("���������� �Է� :");
		int eng = in.nextInt();

		Student insert = new Student(name, kor, eng);
		ht.put(name, insert);

	}

	protected void rank() {
		// 1�̶�� ���� ������ �������̰�, 2��� ���� ������ �񱳴��
		Enumeration<String> enu = ht.keys();
		while (enu.hasMoreElements()) {
			String key1 = enu.nextElement();
			Student rank1 = ht.get(key1);
			rank1.clearRank();
			Enumeration<String> enu2 = ht.keys();
			while (enu2.hasMoreElements()) {
				String key2 = enu2.nextElement();
				Student rank2 = ht.get(key2);
				if (rank1.getTot() < rank2.getTot()) {
					rank1.plusRank();
				}
			}
		}
	}

	@Override
	public void view() {
		rank();
		Enumeration<String> enu = ht.keys();
		while (enu.hasMoreElements()) {
			String key = enu.nextElement();
			Student view = ht.get(key);
			System.out.println(view.getName() + "���� ������" + view.getTot() + "���̰�, ������ " + view.getRank() + "�� �Դϴ�.");
		}
	}

	@Override
	public void edit() {
		System.out.println("������ �л��� �̸� :");
		String name = in.next();
		if (ht.containsKey(name)) {
			Student edit = ht.get(name);
			System.out.printf("���� ����������  %d�� �Դϴ�.", edit.getKor());
			System.out.println("�����Ͻ� ���������� :");
			edit.setKor(in.nextInt());
			System.out.printf("���� ����������  %d�� �Դϴ�.", edit.getEng());
			System.out.println("�����Ͻ� ���������� :");
			edit.setEng(in.nextInt());
			edit.setTot();
			System.out.println(name + "�л��� ������ �����Ͽ����ϴ�.");
		} else {
			System.out.println(name + "���� ����� �л��� �ƴմϴ�.");
		}

	}

	@Override
	public void delete() {
		System.out.println("������ �л��� �̸� :");
		String name = in.next();
		if (ht.containsKey(name)) {
			ht.remove(name);
			System.out.println(name + "�л��� �����Ͽ����ϴ�.");
		} else {
			System.out.println(name + "���� ����� �л��� �ƴմϴ�.");
		}

	}

	@Override
	public void exit() {
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);

	}

	@Override
	public void save() {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fos = new FileOutputStream(data);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(ht);
			oos.close();
		} catch (IOException e) {
		}
		System.out.println("���� ���� ��!!");
		
		
	}

	@Override
	public void load() {
		ht.clear(); // ���� �ڷ� �ʱ�ȭ
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream(data);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			Object obj = ois.readObject();
			ht = (Hashtable<String, Student>)obj;
		} catch (IOException e) { // ��ü����
		} catch (ClassNotFoundException e) {
		} // readObject
		System.out.println("���� �ε� ��!!");

	}

	@Override
	public void saveDB() {
		Connection con;
		PreparedStatement ps;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "web09";
		String pass = "web09";
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "insert into sungjuk values(?, ?, ?)";
			ps = con.prepareStatement(sql);
			Enumeration<String> enu = ht.keys();
			while(enu.hasMoreElements()) {
				Student save = ht.get(enu.nextElement());
				ps.setString(1, save.getName());
				ps.setInt(2, save.getKor());
				ps.setInt(3, save.getEng());
				ps.executeUpdate();
			}
			
		}catch(SQLException e) {
			System.out.println("save�޼ҵ� ���� �� ���� �߻�!!");
		}
	}
	

	@Override
	public void loadDB() {
		ht.clear();
		Connection con;
		PreparedStatement ps;
		ResultSet rs;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "web09";
		String pass = "web09";
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from student";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				Student load = new Student(name, kor, eng);
				ht.put(name, load);
			}
		}catch(SQLException e) {
			System.out.println("load�޼ҵ� ���� �� ���� �߻�!!");
		}
		
	}

}
