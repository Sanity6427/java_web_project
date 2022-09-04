package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentProImpl implements StudentPro {

	private Scanner in;
	private List<Student> list;
	private int rank = 1;
	private int score;

	public StudentProImpl() {
		in = new Scanner(System.in);
		list = new ArrayList<>();
	}


	@Override
	public void insert() {
		System.out.println("�̸��� �Է� :"); // �ߺ��˻�
		String name = in.next();
		System.out.println("���������� �Է� :");
		int kor = in.nextInt();
		System.out.println("���������� �Է� :");
		int eng = in.nextInt();
		
		for(Student sa_name : list) {
			if(name.equals(sa_name.getName())) {
				System.out.println("�̸��� �ߺ��Ǿ����ϴ�.");
			}else {
				Student insert = new Student(name, kor, eng);

				list.add(insert);
			}
		}
	}

	@Override
	public void view() {
		for (Student view : list) {
			
			System.out.println(view.getName() + "����  ���� :  " + (view.getKor() + view.getEng()));
			// ����
			
			
		}

	}

	@Override
	public void delete() {
		System.out.println("������ �л��� �̸� :");
		String name = in.next();

		for (Student delete : list) {
			if (name.equals(delete.getName())) {
				list.remove(delete);
				System.out.println(name + "���� �����Ͽ����ϴ�.");
				return;
			}
		}
		System.out.println(name + "���� ���� �л��� �ƴմϴ�.");
	}

	@Override
	public void edit() {
		System.out.println("������ �л��� �̸� :");
		String name = in.next();

		for (Student edit : list) {
			if (name.equals(edit.getName())) {
				System.out.println("���� ���� ������ " + edit.getKor() + "���Դϴ�.");
				System.out.println(" �����Ͻ� ���� :");
				int kor = in.nextInt();
				edit.setKor(kor);

				System.out.println("���� ���� ������ " + edit.getEng() + "���Դϴ�.");
				System.out.println(" �����Ͻ� ���� :");
				int eng = in.nextInt();
				edit.setEng(eng);
				return;
			}
		}
		System.out.println(name + "���� ���� �л��� �ƴմϴ�.");

	}

	@Override
	public void exit() {
		System.out.println("���α׷��� �����մϴ�.");
		System.exit(0);

	}

}
