package sungjuk;

public class Student {

	private String name;
	private int kor;
	private int eng;
	private int tot;
	private int rank;
	
	public Student(String name, int kor, int eng) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.tot = kor + eng;
		this.rank = 1;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getTot() {
		return tot;
	}

	public void setTot() {
		tot = kor + eng;
	}

	public String getName() {
		return name;
	}
	public int getRank() {
		return rank;
	}
	public void plusRank() {
		rank++;
	}
	public void clearRank() {
		rank = 1;
	}
}
