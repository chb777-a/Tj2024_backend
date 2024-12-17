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
			if( choose ==1 ) { //[4] 조건문
				System.out.println("전화번호 : "); String phone = scan.next();
				System.out.println("인원수 : "); int count = scan.nextInt();
				//[6] 만약에 비어 있는 대기명단이 있으면 객체 생성 후 대입 , 객체 생성 후 입력받은 값 대입
				Waiting waiting = new Waiting(); // 대기명단 객체 생성
				waiting.phone = phone; waiting.count = count; // 대기명단 객체내 입력받은 값 대입
				if (wait1 == null) { // 만약에 첫번째 대기명단이 비어 있으면
					wait1 = waiting; // 대기명단 객체를 while 밖 변수에 대입한다.
				}else if(wait2 == null) { //만약에 두번째 대기명단이 비어 있으면
					wait2 = waiting;// 대기명단 객체를 while 밖 변수에 대입한다.
				}else if(wait3 == null) { // 만약에 세번째 대기명단이 비어있으면
					wait3 = waiting; // 대기명단 객체를 while 밖 변수에 대입한다.
				}
			} else if (choose ==2 ) {
				if(wait1 != null) {
					System.out.printf("인원수 %d 명 , 연락처 : %s \n" , wait1.count , wait1.phone);
				}
				if(wait2 != null) {
					System.out.printf("인원수 %d 명 , 연락처 : %s \n" , wait2.count , wait2.phone);
				}
				if(wait3 != null) {
					System.out.printf("인원수 %d 명 , 연락처 : %s \n" , wait3.count , wait3.phone);
				}
					
				}
			}
			
		}
	}

