package day07;

import java.util.Scanner;

public class Example1 {

	public static void main(String[] args) {
		// [5] 클래스 정의하기 , 객체를 담을 변수 선언.
			//- 정수 3을 담기 위해서는 변수 타입 무엇을 사용하나요? int byte short long 중 하나 사용
			//- Waiting 객체를 담기 위해서는 변수 타입 무엇을 사용하나요? Waiting
		Waiting wait1 = null; Waiting wait2 = null; Waiting wait3 = null;
		
		while(true) { //[1]무한루프
			System.out.println("1.명단등록 2.명단확인 : "); //[2] 출력
			Scanner scan = new Scanner(System.in); //[3] 입력객체
			int choose = scan.nextInt();
			if( choose ==1 ) {
				System.out.println("전화번호 : "); String phone = scan.next();
				System.out.println("인원수 : "); int count = scan.nextInt();
			} else if (choose ==2 ) {
				
			}
			
		}
	}

}
