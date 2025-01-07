package boardservice10.view;

import java.util.Scanner;

import boardservice10.controller.MemberController;
import boardservice10.model.dto.MemberDto;

public class MemberView {
	// 싱글톤 : 프로그램 내 인스턴스(객체) 1개만 만들 수 있도록 하는 디자인 패턴
	// 싱글톤 생성
	private static MemberView instance = new MemberView();
	private MemberView() {}
	public static MemberView getInstance() {return instance;}
	
	private Scanner scan = new Scanner(System.in);
	
	//0. 메인 메뉴 메소드
	public void run() {
		while(true) {
			System.out.println("1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기");
			int choose = scan.nextInt();
			if(choose == 1) {
				signup();
			}
			else if(choose == 2) {
			}
			else if(choose == 3) {
				
			}
			else if(choose == 4) {
				
			}
		}// while end
	}// index end
	
	//1. 회원가입 화면 메소드
	public void signup() {
		System.out.println("아이디 :"); String mid = scan.next();
		System.out.println("비밀번호 :"); String mpwd = scan.next();
		System.out.println("이름 : "); String mname = scan.next();
		System.out.println("전화번호 : "); String mphone = scan.next();
		MemberDto memberDto= new MemberDto(mid , mpwd , mname , mphone);
		boolean result = MemberController.getInstance().signup(memberDto);
		if(result) {
			System.out.println("회원가입 성공");
		}else {System.out.println("회원가입 실패");}
	}
}// c end
