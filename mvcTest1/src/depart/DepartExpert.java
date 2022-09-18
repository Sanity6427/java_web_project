package depart;

import java.util.ArrayList;
import java.util.List;

public class DepartExpert {
	public List<String> getAdivce(String depart){
		List<String> list = new ArrayList<String>();
		switch(depart) {
		case "kor" :
			list.add("국문학을 공부하는 곳입니다.");
			list.add("국어를 잘해야 합니다.");
			break;
		case "eng" :
			list.add("영문을 공부하는 곳입니다.");
			list.add("영어를 잘해야 합니다.");
			break;
		case "com" :
			list.add("컴퓨터를 공부하는 곳입니다.");
			list.add("컴퓨터를 잘해야 합니다.");
			break;
		case "bus" :
			list.add("경영학을 공부하는 곳입니다.");
			list.add("경영를 잘해야 합니다.");
			break;
		}
		return list;
	} 

}
