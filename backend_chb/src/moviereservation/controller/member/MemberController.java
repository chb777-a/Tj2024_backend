package moviereservation.controller.member;

import moviereservation.model.dao.member.MemberDao;
import moviereservation.model.dto.member.MemberDto;

public class MemberController {
	private static MemberController instance = new MemberController();
	private MemberController() {}
	public static MemberController getInstance() {return instance;}
	// 1. 회원가입 컨트롤러
	public boolean signup(MemberDto memberDto) {
		boolean result = MemberDao.getInstance().signup(memberDto);
		return result;
	}
	// 2. 로그인 컨트롤러
	private int loginMno = 0;
	public int getLoginMno() {return loginMno;}
	public boolean login(MemberDto memberDto) {
		int result = MemberDao.getInstance().login(memberDto);
		if(result > 0) {
			loginMno = result;
			return true;
		}
		else {return false;}
	}
	// 2-2. 로그아웃 컨트롤러
	public void logout() {
		loginMno = 0;
	}
	// 3. 회원 탈퇴 컨트롤러
	public void delete() {
		MemberDao.getInstance().delete(loginMno);
	}
	// 3-2. 비밀번호 확인 컨트롤러
	public boolean checkPw(MemberDto memberDto) {
		memberDto.setMemberId(loginMno);
		return MemberDao.getInstance().checkPw(memberDto);
	}
	// 4. 회원 수정 컨트롤러
	public boolean update(MemberDto memberDto) {
		memberDto.setMemberId(loginMno);
		boolean result = MemberDao.getInstance().update(memberDto);
		return result;
	}
}
