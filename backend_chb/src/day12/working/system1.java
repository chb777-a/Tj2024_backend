package day12.working;
	/*
	 도서관리 프로그램
	 1. 초기메뉴 : 회원가입 , 로그인 기능
	 2. 회원가입시 일반인인지 관리자인지 구분하여 가입 진행
	 3. 로그인시 일반인 / 관리자 구분하여 로그인 진행
	 4. 로그인 성공시
	 	4_1. 관리자인 경우 메뉴 : 1.도서등록 2. 도서목록 제공
	 	4_2. 일반인 경우 메뉴 : 1.도서대여 2.도서반납 3.대여현황 제공
	 	
	 5. 관리자는 도서정보를 입력받아 도서등록 처리
	 6. 관리자는 현재 등록된 모든 도서목록을 출력
	 7. 일반인은 도서대여시 대여할 도서번호를 입력받아 대여가 가능하면 대여를 진행
	 8. 일반인은 도서반납시 현재 내가 대여한 도서번호를 입력하여 반납을 진행
	 9. 일반인은 내가 대여한 모든 도서 현황을 출력
	 10. 로그아웃 기능 제공
	 11. 회원과 도서 정보 멤버변수는 각 3개 이상씩 하여 진행
	 
	 */

import java.util.Scanner;

// 기능 : 로그인 / 회원가입 / 로그아웃 / 도서등록 / 도서목록 출력 / 도서대여 / 도서반납 / 대여현황 출력
	// [1]회원가입 : [1]일반인 => 아이디 비밀번호 / [2]관리자 => 아이디 비밀번호 관리자번호
	// [2]로그인 : [1]일반인 => 아이디 비밀번호 일치시 로그인 / [2]관리자 => 아이디 비밀번호 관리자번호 일치시 로그인
	
public class system1 {
	public static void main(String[] args) {
	//공통으로 사용되는 저장소 변수
		MemberDto[] members = new MemberDto[100];
		MemberDto1[] members1 = new MemberDto1[100];
		
		while(true) {
			System.out.println("\n [1]회원가입 [2]로그인 : ");
			Scanner scan = new Scanner(System.in);
			int choose = scan.nextInt();
			if(choose == 1) { //회원가입 함수 호출
				
			}
			else if( choose == 2 ) { //로그인 함수 호출
				
			}
		}
	} //main end
}//class end
