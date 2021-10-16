package ranking;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

// 한 라인씩 콤마로 구분

public class Reading {

	static ArrayList<Userdata> userlist = new ArrayList<Userdata>();

	public static void readFileAddList(String filePath) {
		try {

			try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
				while (true) {

					@SuppressWarnings("deprecation")
					String text = dis.readLine();
					// 텍스트 파일 내 데이터를 한 줄 씪 읽음

					// 무한 반복 현상을 막기 위해 텍스트 내 데이터가 없으면 끝내도록
					if (text == null) {
						break;
					}

					String[] strArray = text.split(","); // comma를 기준으로 자르기

					userlist.add(new Userdata(strArray[0], Integer.valueOf(strArray[1])));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 내용 출력
	public static void printUserList() {
		for (Userdata userdata : userlist) {
			System.out.println(userdata);
		}
		System.out.println("");
	}

}
