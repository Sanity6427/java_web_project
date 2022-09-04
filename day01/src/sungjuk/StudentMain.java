package sungjuk;

import java.io.IOException;


public class StudentMain {

	public static void main(String[] args) throws IOException{
		
		StudentPro pro = new StudentProImpl();
		
		while(true) {
			System.out.println("1.입력  2.출력  3.수정 4.삭제 5.저장 6.로드 7.종료 : ");
			int select = System.in.read() -48;
			System.in.skip(5);
			switch(select) {
			case 1 : pro.insert(); break;
			case 2 : pro.view(); break;
			case 3 : pro.edit(); break;
			case 4 : pro.delete(); break;
			case 7 : pro.exit(); break;
			case 5 : pro.saveDB(); break;
			case 6 : pro.load(); break;
			default : System.out.println("잘 못 입력하셨습니다." + "다시 입력해 주세요!!");
			}
			
		}
	}

}
