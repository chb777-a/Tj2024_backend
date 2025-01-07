package boardservice10.controller;

public class MemberController {
	// 싱글톤 : 프로그램 내 인스턴스(객체) 1개만 만들 수 있도록 하는 디자인 패턴
	// 싱글톤 생성
	private static MemberController instance = new MemberController();
	private MemberController() {}
	public static MemberController getInstance() {return instance;}
}
