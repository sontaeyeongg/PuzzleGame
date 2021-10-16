package ranking;

import java.io.File;
import java.io.FileWriter;

// Writing.write(); 를 메인 메소드에 써서 텍스트에 저장한다.
public class Writing {
	// Userdata 객체 생성자의 이름과 점수는 다른 클래스의 메소드를 받아온다.
	// 지금은 임시로 임의의 데이터를 기입해둔 상태다
	static Userdata A = new Userdata("Name", 9999);
	static String txt1 = A.getName();
	static String txt2 = ",";
	static String txt3 = String.valueOf(A.getScore());
	static String txt4 = "\n";

	static void write() {
		try {
			// 파일 객체 생성
			File file = new File(Properties.filePath);

			// true 지정시 파일의 기존 내용에 이어서 작성
			FileWriter fw = new FileWriter(file, true);

			// 파일안에 문자열 쓰기
			fw.write(txt1);
			fw.write(txt2);
			fw.write(txt3);
			fw.write(txt4);
			fw.flush();

			// 객체 닫기
			fw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
