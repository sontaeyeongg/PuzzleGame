package ranking;

import java.util.Comparator;

// 이름, 점수 를 입력받아 유저 생성
public class Userdata {
	String name;
	int score;

	public Userdata() {
	}

	public Userdata(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "(이름=" + name + ", 점수=" + score + ")";
	}

}

// 내림차순 구현
class UserComparator implements Comparator<Userdata> {
	@Override
	public int compare(Userdata a, Userdata b) {
		if (a.score > b.score)
			return 1;
		if (a.score < b.score)
			return -1;
		return 0;
	}
}