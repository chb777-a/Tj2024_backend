package boardservice10;

import boardservice10.view.MemberView;

public class AppStart {
	public static void main(String[] args) {
	// 싱글톤 메소드 호출 방법 : 클래스명.getInstance().메소드명();
		MemberView.getInstance().run(); // 메소드 호출
		
	}// main end
}// c end
