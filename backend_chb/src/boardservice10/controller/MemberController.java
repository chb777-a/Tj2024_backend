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
} // c end
