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

			System.out.println("1.�Է�  2.���  3.���� 4.���� 5.���� : ");
			menu = sc.next();
			end = 0;
			switch (menu) {
			case "1":
				System.out.println("�̸��� �Է��ϼ���");
				name = sc.next();

				System.out.println("��ȭ��ȣ�� �Է��ϼ���");
				phone = sc.next();

				info.put(name, phone);
				break;
			case "2":
				if (name.isEmpty() == false) {
					System.out.printf("%s���� ��ȭ��ȣ�� %s", name, phone);
					System.out.println("");
				}
				break;
			case "3":
				System.out.println("�����Ͻ� ȸ���� �̸� : ");
				ed_name = sc.next();
				if (name.equals(ed_name)) {
					System.out.printf("���� ��ȭ��ȣ�� %s�Դϴ�. �����Ͻ� ��ȣ : ", phone);
					phone = sc.next();
				}
				break;
			case "4":
				System.out.println("�����Ͻ� ȸ���� �̸� : ");
				de_name = sc.next();
				if (name.equals(de_name)) {
					name = "";
					System.out.printf("%s���� �����Ͽ����ϴ�.", de_name);
					System.out.println("");
				}
				break;
			case "5":
				System.out.println("���α׷��� �����մϴ�.");
				end = 1;
				break;
			}

			if (end == 1) {
				break;
			}

		}

	}

}
