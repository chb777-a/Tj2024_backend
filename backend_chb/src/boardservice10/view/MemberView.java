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
				login();
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
	
	//2. 로그인 화면 메소드
	public void login() {
		//[1] 입력
		System.out.println("ID : "); String mid = scan.next();
		System.out.println("Password : "); String mpwd = scan.next(); // documentQuerySelector (html)
		//[2] 객체화 / 데이터포장 view -> controller 이동
		MemberDto memberDto = new MemberDto();
		memberDto.setMid(mid);
		memberDto.setMpwd(mpwd);
		
		//[3] 컨트롤러에게 전달 후 응답 결과 받기
		boolean result = MemberController.getInstance().login(memberDto);
		//[4] 컨트롤러의 결과에 따른 처리
		if(result) {
			System.out.println("로그인 성공");
		}else {System.out.println("로그인 실패");}
		
	} // login end
	
	//3. 아이디 찾기 화면 메소드
	public void findId() {
		//[1] 입력
		System.out.println(" 이름 : "); String mname = scan.next();
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

	
	//4. 비밀번호 찾기 화면 메소드
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
	
	//5. 로그아웃 화면 메소드
	public void logout() {
		MemberController.getInstance().logout();
		System.out.println("로그아웃 완료");
	} //logout end
	
	//6. 내 정보 보기 메소드
	public void myInfo() {
		//컨트롤러에게 응답 받기
		// 받는 곳 = MemberController.getInstance().myInfo(주는 곳);
		MemberDto result = MemberController.getInstance().myInfo();
		System.out.println("========== 마이 페이지 ==========");
		System.out.println("mid : " + result.getMid());
		System.out.println("mname : " + result.getMname());
		System.out.println("mphone : " + result.getMphone());
		System.out.println("mdate : " + result.getMdate());
		//서브 메뉴
		while(true) {
			System.out.println("1.회원수정 2.회원탈퇴 3.뒤로가기");
			int choose2 = scan.nextInt();
			if(choose2 == 1) {
				
			}
			else if(choose2 == 2) {
				delete(); break;
			}
			else if(choose2 == 3) {
				break; // 메뉴에서 무한반복 탈출 // w end - > f end
			}
		} // w end
		
	}
	
	//7. 회원탈퇴 화면 메소드
	public void delete() {
		System.out.println("회원 탈퇴 하시겠습니까? 0.예 1.취소"); // 입력으로 처리
		int choose2 = scan.nextInt();
		if(choose2 == 0) {
			MemberController.getInstance().delete(); // 탈퇴처리 컨트롤러 요청
			logout(); // 탈퇴 처리시 로그아웃
		}
	}
}// c end
