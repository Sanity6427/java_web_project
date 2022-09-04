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
		System.out.println("이름을 입력 :"); // 중복검사
		String name = in.next();
		System.out.println("국어점수를 입력 :");
		int kor = in.nextInt();
		System.out.println("영어점수를 입력 :");
		int eng = in.nextInt();
		
		for(Student sa_name : list) {
			if(name.equals(sa_name.getName())) {
				System.out.println("이름이 중복되었습니다.");
			}else {
				Student insert = new Student(name, kor, eng);

				list.add(insert);
			}
		}
	}

	@Override
	public void view() {
		for (Student view : list) {
			
			System.out.println(view.getName() + "님의  총점 :  " + (view.getKor() + view.getEng()));
			// 순위
			
			
		}

	}

	@Override
	public void delete() {
		System.out.println("삭제할 학생의 이름 :");
		String name = in.next();

		for (Student delete : list) {
			if (name.equals(delete.getName())) {
				list.remove(delete);
				System.out.println(name + "님을 삭제하였습니다.");
				return;
			}
		}
		System.out.println(name + "님은 저희 학생이 아닙니다.");
	}

	@Override
	public void edit() {
		System.out.println("수정할 학생의 이름 :");
		String name = in.next();

		for (Student edit : list) {
			if (name.equals(edit.getName())) {
				System.out.println("현재 영어 점수는 " + edit.getKor() + "점입니다.");
				System.out.println(" 수정하실 점수 :");
				int kor = in.nextInt();
				edit.setKor(kor);

				System.out.println("현재 영어 점수는 " + edit.getEng() + "점입니다.");
				System.out.println(" 수정하실 점수 :");
				int eng = in.nextInt();
				edit.setEng(eng);
				return;
			}
		}
		System.out.println(name + "님은 저희 학생이 아닙니다.");

	}

	@Override
	public void exit() {
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);

	}

}
