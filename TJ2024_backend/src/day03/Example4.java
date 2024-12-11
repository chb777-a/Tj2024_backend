package day03;

import java.util.Scanner;

public class Example4 {

	public static void main(String[] args) {
			/*
			[ 구현 문제 , FOR문 없이 풀이 ] 
			문제1 : 점수를 정수형으로 입력받아 점수가 90점 이상이면 '합격' 아니면 '불합격' 출력 하시오.
			
			문제2 : 점수를 정수형으로 입력받아 점수가 90점 이상이면 'A등급', 80점 이상이면 'B등급', 70점 이상이면 'C등급', 그외 '재시험' 으로 출력 하시오.
			
			문제3 : 각 3개의 정수형으로 수를 입력받아 가장 큰 수를 출력 하시오. [ 전제조건 : 각 정수는 서로 다른 정수값 ]
			
			문제4 : 각 3개의 정수형으로 수를 입력받아 오름차순 순서대로 출력하시오. [ 전제조건 : 각 정수는 서로 다른 정수값 ]
			
			문제5 : 가위바위보 게임 구현하기.
			      - 가위가 '0' 이고 바위가 '1' 이고 보가 '2' 일때 플레이어1와 플레이어2 가 있습니다.
			     - 승리자 판단과 무승부 경우의수를 출력하시오.
			      [입력 조건] 플레이어1 과 플레이어2 에게 각각 입력을 받습니다.
			     [출력 조건] 플레이어1 이기면 ' 플레이어1 승리 ', 플레이어2 이기면 ' 플레이어2 승리 ' 무승부 이면 '무승부' 출력 하시오.
			
			문제6 : 윤년/평년 판단하기
			   [ 입력조건 ] 하나의 연도를 입력 받습니다.
			   [ 윤년/평년 조건 ]
			   -연수가 4로 나누어 떨어지는 해는 윤년으로 한다.
			   -연수가 4, 100으로 나누어 떨어지는 해는 평년으로 한다.
			   -연수가 4, 100, 400으로 나누어 떨어지는 해는 윤년으로 둔다.
			   [ 출력조건] '입력한OOOO년 은' 윤년 입니다.  혹은 평년 입니다 로 출력하시오.
			
			문제7 : 주차 사용요금 계산하기
			   [ 선언 변수 조건 ] 입차시간이 9시30분 입니다. 
			   - int 시 = 9;  int 분 = 30; 이와 같이 변수를 먼저 선언해주세요.
			   [ 출차시간 입력 조건 ] 출차시간의 시 와 분을 각 입력받아 각 변수에 저장하시오. 
			   [ 처리출력 조건 ] 1분당 1000원으로 계산하여 사용요금' 0000원' 을 출력하시오,
			   - 단 입차 시간 이전 으로 입력 할 경우에는 '출차시간 오류' 출력하시오.
			
			문제8 : 로그인 처리
			   [입력 조건] 아이디[문자열] 와 비밀번호[문자열] 를 입력받기
			   [처리출력 조건]
			   1. 아이디가 'admin' 이고 비밀번호가 '1234' 모두 동일하면 '로그인성공'
			   2. 아이디가 다르면 '아이디 정보가 일치하지 않습니다.'
			   3. 아이디는 일치하고 비밀번호가 다르면 '비밀번호 정보가 일치하지 않습니다'
			   [ 참고 ]
			   1. 문자열 비교시에는 == 같다 연산자 대신에 .equals() 함수를 이용해주세요.
			   예] 
			      String name = scan.next();
			      name =="admin" 대신에 name.equals( "admin" ) 사용.
			
			문제9 : 당첨번호 개수  찾기
			   [ 선언 변수 조건 ] int 공1 = 14 ; int 공2 = 21 ; int 공3 = 9; 이와 같이 변수를 먼저 선언해주세요.
			   [ 입력 조건 ] 세개의 정수를 입력받아 각 변수에 저장하시오.
			   [ 출력 조건 ] 입력받은 세 정수 중에서 공1~공3 까지 동일한 번호 가 몇개 인지 출력하시오.
			 */

		
		
		Scanner scan = new Scanner(System.in);
		//문제1 : 점수를 정수형으로 입력받아 점수가 90점 이상이면 '합격' 아니면 '불합격' 출력 하시오.
		//1
		System.out.println("점수 입력");
		int score1 = scan.nextInt();
		String result1;
		result1 = (score1 >= 90) ? "합격" : "불합격" ;
		System.out.println(result1);
		
		//문제2 : 점수를 정수형으로 입력받아 점수가 90점 이상이면 'A등급', 80점 이상이면 'B등급', 70점 이상이면 'C등급', 그외 '재시험' 으로 출력 하시오.
		//2
		System.out.println("점수 입력");
		int score2 = scan.nextInt();
		char grade;
		if(score2 >= 90) {
			grade = 'A';
			System.out.println("A등급");
		}
		else if(score2 >= 80) {
			grade = 'B';
			System.out.println("B등급");
		}
		else if(score2 >= 70) {
			grade = 'C';
			System.out.println("C등급");
		}
		else {grade = 'F';
			System.out.println("재시험");
		}
		
		//문제3 : 각 3개의 정수형으로 수를 입력받아 가장 큰 수를 출력 하시오. [ 전제조건 : 각 정수는 서로 다른 정수값 ]
		//3
		System.out.println("정수 3개 입력");
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		
		int total;
		
		if(a>b && a>c) {
			total=a;
		}
		else if(b>c && b>a) {
			total=b;
		}
		else {
			total=c;
		}
		
		System.out.println("가장 큰 수 :" + total);
		//3_1
		System.out.println("정수 3개 입력2");
		int a1 = scan.nextInt();
		int b1 = scan.nextInt();
		int c1 = scan.nextInt();
		
		int max = a1; //첫번째 값을 최댓값으로 설정
		if(max<b1) {max = b1;}
		if(max<c1) {max = c1;}
		System.out.println(max);

		
		//문제4 : 각 3개의 정수형으로 수를 입력받아 오름차순 순서대로 출력하시오. [ 전제조건 : 각 정수는 서로 다른 정수값 ]
		//4
		System.out.println("정수 3개 입력2");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		
		if(num1<num2 && num1<num3) {
			if(num2<num3) {
				System.out.println(num1 + "" + num2 + "" + num3);
				}
			else {System.out.println(num1 + "" + num3 + "" + num2);
				}
			}
		else if(num2<num1 && num2<num3) {
			if(num1<num3) {
				System.out.println(num2 + "" + num1 + "" + num3);
			}
			else {System.out.println(num2 + "" + num3 + "" + num2);
			}
		}
		else {
			if(num1<num2) {
				System.out.println(num3 + "" + num1 + "" + num2);
			}
			else {
				System.out.println(num3 + "" + num2 + "" + num1);
			}
		}
		
		
		//4_1
		//[입력]
		int value1 = scan.nextInt();
		int value2 = scan.nextInt();
		int value3 = scan.nextInt();
		
		//[처리] , 3개의 변수들간의 값 비교 , 오름차순 : 작=>큰 / 내림차순 : 큰=>작
			//1. 비교 , 조건 3 개
				//조건1. 첫번째 값 > 두번째 값 //조건2. 첫번재값 > 세번째값; //조건3. 두번째값 > 세번째값
			//2. 스왑 , 두 변수간의 값 바꾸기. temp변수를 활용한 두 변수간의 값 바꾸기.
				// int temp = 첫번째변수값; , 첫번째변수명 = 두번째변수값; , 두번째변수명 = temp값;
		
		if(value1>value2) {
			int temp = value1; value1 = value2; value2 = temp;
			}
		if (value1>value3) {
			int temp = value1; value1 = value3; value3 = temp;
		}
		if(value2>value3) {
			int temp = value2; value2 = value3; value3 = temp;
		}
		
		System.out.println(value1); System.out.println(value2); System.out.println(value3);
		
		
		
		/* 문제5 : 가위바위보 게임 구현하기.
	     - 가위가 '0' 이고 바위가 '1' 이고 보가 '2' 일때 플레이어1와 플레이어2 가 있습니다.
	     - 승리자 판단과 무승부 경우의수를 출력하시오.
	      [입력 조건] 플레이어1 과 플레이어2 에게 각각 입력을 받습니다.
	     [출력 조건] 플레이어1 이기면 ' 플레이어1 승리 ', 플레이어2 이기면 ' 플레이어2 승리 ' 무승부 이면 '무승부' 출력 하시오.
		*/
		System.out.println("플레이어1");
		System.out.println("플레이어2");
		int i1 = 0;
		int i2 = 1;
		int i3 = 2;
		
		
		}// main end
} // class end