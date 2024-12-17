package day07;

import java.util.Scanner;

/*자바 조별 과제 1 
  주제 : 회원 서비스 구현하기 
  	- 문법 : 변수 , 입출력함수 , 연산자 , 제어문(조건문/반복문) , 클래스 (멤버변수) / 객체
  	- 회원 최대 3명까지 저장
  	- 회원 정보는 아이디 , 비밀번호 , 닉네임을 갖는다
  	- 회원클래스를 정의하고 회원 객체 활용하여 구현
  	- 프로그램 초기 메뉴 : 1. 회원가입 2. 로그인 :
  		1 선택시 : 아이디 , 비밀번호 , 닉네임 3개 각 정보를 입력받아 저장
  		2. 선택시 : 아이디, 비밀번호를 입력받아 기존의 저장된 정보와 일치한 정보가 있으면 '로그인성공' 아니면 '로그인 실패' 출력

   1. 코드 구현 : 카카오톡방에 과제 코드가 존재하는 본인 git 상세주소 제출 
   2. 구현 된 코드에서 문법찾기 : 아래 링크의 각 슬라이드에서 조별 작성 , 카톡방 링크 참고
https://docs.google.com/presentation/d/1k7xc6I3MwnBI57zr1WTGm0mVgzQ5CXkmrEro2PFc9UI/edit?usp=sharing
  		*/
public class Example3 {

	public static void main(String[] args) {
		Join Member1 = null; Join Member2 = null; Join Member3 = null;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
		System.out.println("[1]회원가입 , [2] 로그인");
		
		int choose = scan.nextInt();
		
		if(choose == 1) {
			System.out.println("회원가입");
			System.out.print("아이디"); String id = scan.next();
			System.out.print("비밀번호"); String password = scan.next();
			System.out.println("닉네임"); String name = scan.next();
			Join member = new Join();
			member.id = id; member.password = password; member.name = name;
			if(Member1 == null) {
				Member1 = member;
			}
			else if(Member2 == null) {
				Member2 = member;
			}
			else if(Member3 == null) {
				Member3 = member;
			}
			else {
				System.out.println("회원은 최대 3명까지만 가능합니다.");
			}
		}// if end
		else if(choose == 2) {
			System.out.println("로그인");
			System.out.print("아이디"); String idr = scan.next();
			System.out.print("비밀번호"); String passwordr = scan.next();
			if (Member1 != null && Member1.id.equals(idr) && Member1.password.equals(passwordr)) {
				System.out.println("로그인 완료");
			}
			else if(Member2 != null && Member2.id.equals(idr) && Member2.password.equals(passwordr)) {
				System.out.println("로그인 완료");
			}
			else if(Member3 != null && Member3.id.equals(idr) && Member3.password.equals(passwordr)) {
				System.out.println("로그인 완료");
			}
			else {System.out.println("로그인 실패");}
			
			
		}
		
		} //while end

	}

}
