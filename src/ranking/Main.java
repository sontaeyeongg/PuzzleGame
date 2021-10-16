package ranking;

import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		System.out.println("main method start");
		// 아래의 메소드를 이용해 새 점수를 텍스트파일에 넣을 수 있다.
		// Writing.write();
		Reading.readFileAddList(Properties.filePath);

		System.out.println("정렬 전(텍스트파일에 입력된 순) ->");
		Reading.printUserList();
		Collections.sort(Reading.userlist, new UserComparator());
		System.out.println("정렬 후(오름차순)->");
		Reading.printUserList();

		// 어레이 리스트의 개별 요소에 접근하고 싶다면 아래를 이용.
		System.out.println("가장 점수가 낮은 유저의 데이터는 아래와 같다");
		System.out.println(Reading.userlist.get(0).getName());
		System.out.println(Reading.userlist.get(0).getScore());

		System.out.println("main method end");
	}
}