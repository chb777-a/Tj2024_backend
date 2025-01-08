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
				findId();
			}
			else if(choose == 4) {
				findPwd();
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
	
	//2. 아이디 찾기 화면 메소드
	public void findId() {
		//[1] 입력
		System.out.println("이름 : "); String mname = scan.next();
		System.out.println(" 전화번호 : "); String mphone = scan.next();
		
		//[2] 객체화 / 데이터포장 ( view에서 controller 이동 )
		// MemberDto memberDto = new MemberDto(mname , mphone); // 오류 : new 키워드 뒤로 생성자가 오는데 클래스에 선언된 (매개변수가 일치한) 생성자만 가능
			// 오류 해결1 : 클래스에서 매개변수2개의 생성자를 만든다.
			// 오류 해결2 : 디폴트 생성자로 인스턴스 생성후 setter로 값을 넣는다.
		MemberDto memberDto = new MemberDto();
		memberDto.setMname(mname);
		memberDto.setMphone(mphone);

		//[3] 컨트롤러에게 전달(request/요청/매개변수) 후 응답(response/응답/리턴) 결과 받기
		String result = MemberController.getInstance().findId(memberDto);
		
		//[4] 컨트롤러의 결과에 따른 처리
		if(result != null) {System.out.println("찾은아이디 : " + result);}
		else{System.out.println("동일한 회원 정보 없음");}
	}

	
	//3. 비밀번호 찾기 화면 메소드
	public void findPwd() {
		// [1] 입력
		System.out.println("아이디 : "); String mid = scan.next();
		System.out.println("전화번호 : "); String mphone = scan.next();
		//[2] 객체화 / 데이터포장 ( view에서 controller 이동 ) // ***디폴트 생성자로 인스턴스 생성후 setter로 값을 넣는다.
		MemberDto memberDto = new MemberDto();
		memberDto.setMid(mid);
		memberDto.setMphone(mphone);
		//[3] 컨트롤러에게 전달 후 응답 결과 받기
		String result = MemberController.getInstance().findPwd(memberDto);
		//[4] 컨트롤러의 결과에 따른 처리
		if(result!=null) {System.out.println("찾은 비밀번호 : " + result);}
		else {System.out.println("일치한 회원 정보 없음");}
	}
	
}// c end
