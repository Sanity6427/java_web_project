package depart;

import java.util.ArrayList;
import java.util.List;

public class DepartExpert {
	public List<String> getAdivce(String depart){
		List<String> list = new ArrayList<String>();
		switch(depart) {
		case "kor" :
			list.add("�������� �����ϴ� ���Դϴ�.");
			list.add("��� ���ؾ� �մϴ�.");
			break;
		case "eng" :
			list.add("������ �����ϴ� ���Դϴ�.");
			list.add("��� ���ؾ� �մϴ�.");
			break;
		case "com" :
			list.add("��ǻ�͸� �����ϴ� ���Դϴ�.");
			list.add("��ǻ�͸� ���ؾ� �մϴ�.");
			break;
		case "bus" :
			list.add("�濵���� �����ϴ� ���Դϴ�.");
			list.add("�濵�� ���ؾ� �մϴ�.");
			break;
		}
		return list;
	} 

}
