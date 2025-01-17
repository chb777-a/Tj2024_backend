package moviereservation.view.member;

import java.util.Scanner;

import moviereservation.controller.member.MemberController;
import moviereservation.model.dto.member.MemberDto;

public class MemberView {
	private static MemberView instance = new MemberView();
	private MemberView() {}
	public static MemberView getInstance() {return instance;}
	
	private Scanner scan = new Scanner(System.in);
	public void run() {
		while(true) {
			System.out.println("-------------------------MENU-------------------------");
			System.out.println("1.회원가입\n2.로그인\n3.뒤로가기");
			int choose = scan.nextInt();
			if(choose == 1) {signup();}
			else if(choose ==2) {login();}
			else if(choose ==3) {break;}
		}
	}
	// 1. 회원가입 화면
	public void signup() {
		System.out.println("아이디 : "); String mid = scan.next();
		System.out.println("비밀번호 : "); String mpw = scan.next();
		System.out.println("이름 : "); String mname = scan.next();
		System.out.println("생년월일 : "); String mbirth = scan.next();
		MemberDto memberDto = new MemberDto(mid, mpw, mname, mbirth);
		boolean result = MemberController.getInstance().signup(memberDto);
		if(result) {System.out.println("[ 회원 가입 성공] ");}
		else {System.out.println("[ 회원 가입 실패 ]");}
		
	}
	// 2. 로그인 화면
	public void login() {
		System.out.println("아이디 : "); String mid = scan.next();
		System.out.println("비밀번호 : "); String mpw = scan.next();
		MemberDto memberDto = new MemberDto();
		memberDto.setMid(mid); memberDto.setMpw(mpw);
		boolean result = MemberController.getInstance().login(memberDto);
		if(result) {
			System.out.println("[ 사용자 로그인 성공 ]");
			MemberResvView.getInstance().run();
		}
		else {System.out.println("[ 사용자 로그인 실패 ]");}
	}
	// 2-2. 로그아웃 화면
	public void logout() {
		MemberController.getInstance().logout();
		System.out.println("[ 로그아웃 성공 ]");
	}
	// 3. 회원탈퇴 화면
	public int delete() {
		System.out.println("비밀번호 재입력 : "); String mpw = scan.next();
		MemberDto memberDto = new MemberDto();
		memberDto.setMpw(mpw);
		boolean result = MemberController.getInstance().checkPw(memberDto);
		if(result) {
			System.out.println("정말 회원 탈퇴 하겠습니까? 1:예 0:취소");
			int choose2 = scan.nextInt();
			if(choose2 == 1) {
			MemberController.getInstance().delete();
			logout();
			return 1;
			}
		}
		else {System.out.println("[ 비밀번호가 일치하지 않습니다. ]");}
		return 0;
	}
	// 4. 회원수정 화면
	public void update() {
		System.out.println("비밀번호 재입력 : "); String mpw = scan.next();
		MemberDto memberDto = new MemberDto();
		memberDto.setMpw(mpw); 
		boolean result = MemberController.getInstance().checkPw(memberDto);
		if(result) {
			System.out.println("새로운 비밀번호 : "); String newPw = scan.next();
			System.out.println("새로운 이름 : "); String mname = scan.next();
			System.out.println("새로운 생년월일 : "); String mbirth = scan.next();
			memberDto.setMpw(newPw); memberDto.setMname(mname); memberDto.setMbirth(mbirth);
			boolean result1 = MemberController.getInstance().update(memberDto);
			if(result1) {
				System.out.println("[ 회원 정보 수정 완료 ]");
			}
		}
		else {System.out.println("[ 비밀번호가 일치하지 않습니다. ]");}
	}
}
