package sungjuk;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.io.*;
import java.sql.*;

public class StudentProImpl implements StudentPro {

	private Hashtable<String, Student> ht; // 해쉬테이블을 쓰는 이유 : 해쉬맵이 멀티 스레드에서 효율적이지 않음
	// but 웹사이트는 멀티 스레드가 default, so use hashtable
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
			System.out.println("오라클 드라이버 검색 실패!!");
		}
	}
	
	
	
	

	@Override
	public void insert() {
		String name;
		while (true) {
			System.out.println("이름을 입력 :");
			name = in.next();
			if (ht.containsKey(name)) {
				System.out.println("동일한 이름이 있습니다. 다시 입력해 주세요!!");
			} else {
				break;
			}
		}

		System.out.println("국어점수를 입력 :");
		int kor = in.nextInt();
		System.out.println("영어점수를 입력 :");
		int eng = in.nextInt();

		Student insert = new Student(name, kor, eng);
		ht.put(name, insert);

	}

	protected void rank() {
		// 1이라고 적힌 변수는 기준점이고, 2라고 적힌 변수는 비교대상
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
			System.out.println(view.getName() + "님의 총점은" + view.getTot() + "점이고, 순위는 " + view.getRank() + "등 입니다.");
		}
	}

	@Override
	public void edit() {
		System.out.println("수정할 학생의 이름 :");
		String name = in.next();
		if (ht.containsKey(name)) {
			Student edit = ht.get(name);
			System.out.printf("현재 국어점수는  %d점 입니다.", edit.getKor());
			System.out.println("수정하실 국어점수는 :");
			edit.setKor(in.nextInt());
			System.out.printf("현재 영어점수는  %d점 입니다.", edit.getEng());
			System.out.println("수정하실 영어점수는 :");
			edit.setEng(in.nextInt());
			edit.setTot();
			System.out.println(name + "학생의 점수를 수정하였습니다.");
		} else {
			System.out.println(name + "님은 저희반 학생이 아닙니다.");
		}

	}

	@Override
	public void delete() {
		System.out.println("삭제할 학생의 이름 :");
		String name = in.next();
		if (ht.containsKey(name)) {
			ht.remove(name);
			System.out.println(name + "학생을 삭제하였습니다.");
		} else {
			System.out.println(name + "님은 저희반 학생이 아닙니다.");
		}

	}

	@Override
	public void exit() {
		System.out.println("프로그램을 종료합니다.");
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
		System.out.println("파일 저장 끝!!");
		
		
	}

	@Override
	public void load() {
		ht.clear(); // 기존 자료 초기화
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream(data);
			BufferedInputStream bis = new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			Object obj = ois.readObject();
			ht = (Hashtable<String, Student>)obj;
		} catch (IOException e) { // 객체선언
		} catch (ClassNotFoundException e) {
		} // readObject
		System.out.println("파일 로드 끝!!");

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
			System.out.println("save메소드 실행 중 오류 발생!!");
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
			System.out.println("load메소드 실행 중 오류 발생!!");
		}
		
	}

}
