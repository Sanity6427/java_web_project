package student;

import java.io.IOException;


public class StudentMain {

	public static void main(String[] args) throws IOException{
		
		StudentPro pro = new StudentProImpl();
		
		while(true) {
			System.out.println("1.�Է�  2.���  3.���� 4.���� 5.���� : ");
			int select = System.in.read() -48;
			System.in.skip(5);
			switch(select) {
			case 1 : pro.insert(); break;
			case 2 : pro.view(); break;
			case 3 : pro.edit(); break;
			case 4 : pro.delete(); break;
			case 5 : pro.exit(); break;
			default : System.out.println("�� �� �Է��ϼ̽��ϴ�." + "�ٽ� �Է��� �ּ���!!");
			}
			
		}
	}

}