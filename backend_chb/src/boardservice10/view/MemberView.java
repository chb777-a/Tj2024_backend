package boardservice10.view;

public class MemberView {
	// 싱글톤 : 프로그램 내 인스턴스(객체) 1개만 만들 수 있도록 하는 디자인 패턴
	// 싱글톤 생성
	private static MemberView instance = new MemberView();
	private MemberView() {}
	public static MemberView getInstance() {return instance;}
}
