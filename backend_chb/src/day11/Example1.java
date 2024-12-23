package day11;
/*
 	자바 과제11 : 회원제 게시판
 	- 초기메뉴는 로그인과 회원가입을 제공한다.
 	- 로그인 성공하면 게시물 등록과 게시물 출력을 제공합니다.
 		- 단 게시물 등록시 작성자를 현재 로그인된 회원아이디로 자동 등록 됩니다.
 */

import java.util.Scanner;

public class Example1 {
	public static void main(String[] args) {
		
		// 로그인 및 회원가입
		while(true) {
			Scanner scan = new Scanner(System.in); // 입력
			System.out.println("[1]회원가입 [2]로그인");
			int choose = scan.nextInt();
			if(choose==1) {
				
			}
			else if(choose==2) {
				
			}
		}//while end
	}//main end
}//class end
