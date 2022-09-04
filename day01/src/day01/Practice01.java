package day01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Practice01 {

	public static void main(String[] args) {
		String menu = "";
		String name = "";
		String phone = "";
		String ed_name;
		String de_name;
		int end = 0;

		Map<String, String> info = new HashMap<>();

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("1.입력  2.출력  3.수정 4.삭제 5.종료 : ");
			menu = sc.next();
			end = 0;
			switch (menu) {
			case "1":
				System.out.println("이름을 입력하세요");
				name = sc.next();

				System.out.println("전화번호를 입력하세요");
				phone = sc.next();

				info.put(name, phone);
				break;
			case "2":
				if (name.isEmpty() == false) {
					System.out.printf("%s님의 전화번호는 %s", name, phone);
					System.out.println("");
				}
				break;
			case "3":
				System.out.println("수정하실 회원의 이름 : ");
				ed_name = sc.next();
				if (name.equals(ed_name)) {
					System.out.printf("현재 전화번호는 %s입니다. 수정하실 번호 : ", phone);
					phone = sc.next();
				}
				break;
			case "4":
				System.out.println("삭제하실 회원의 이름 : ");
				de_name = sc.next();
				if (name.equals(de_name)) {
					name = "";
					System.out.printf("%s님을 삭제하였습니다.", de_name);
					System.out.println("");
				}
				break;
			case "5":
				System.out.println("프로그램을 종료합니다.");
				end = 1;
				break;
			}

			if (end == 1) {
				break;
			}

		}

	}

}
