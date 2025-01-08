package boardservice10.controller;

import boardservice10.model.dao.MemberDao;
import boardservice10.model.dto.MemberDto;

public class MemberController {
	// 싱글톤 : 프로그램 내 인스턴스(객체) 1개만 만들 수 있도록 하는 디자인 패턴
	// 싱글톤 생성
	private static MemberController instance = new MemberController();
	private MemberController() {}
	public static MemberController getInstance() {return instance;}
	
	//1. 회원가입 컨트롤러 메소드
	// 유효성 검사 할 예정
	public boolean signup( MemberDto memberDto) {
		boolean result = MemberDao.getInstance().signup(memberDto);
		return result;
	}
	
	//3. 아이디찾기 컨트롤러 메소드
	public String findId(MemberDto memberDto) {
		// 유효성 검사 넣을 예정
		String result = MemberDao.getInstance().findId(memberDto);
		return result;
	}
	
	//4. 비밀번호 찾기 컨트롤러 메소드
	public String findPwd(MemberDto memberDto) {
		// 유효성 검사 넣을 예정
		String result = MemberDao.getInstance().findPwd(memberDto);
		return result;
	}
} // c end
