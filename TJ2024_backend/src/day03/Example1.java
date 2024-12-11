package day03;

public class Example1 {// 자바는 번역(컴파일)단위를 클래스 단위로 함으로써 모든 코드는 클래스안에 존재
	

	public static void main(String[] args) {
		// 번역된(.class파일) 코드가 실행하기 위해서는 main함수 안에 있어야 실행된다.
		
		//연산자
		
		// [1] 대입연산자 , 왼쪽 변수 = 오른쪽변수(또는 식) , 오른쪽 항 먼저 확인/계산
		int age = 30; // 나이를 의미하는 age 변수에 값 24를 대입함
		
		int mathScore = 10;
		int engScore = 20;
		int totalScore = mathScore + engScore; // 수학점수와 영어점수 값을 더해서 총점을 의미하는 변수에 대입한다.
		
		// [2] 부호연산자 , + 양수 , -음수
		int num = 10;
		System.out.println(+num); // +10 --> 10
		System.out.println(-num); // -10 --> 10 // 부호를 붙여서 출력했지만 수정은 아니다.
		System.out.println(num); // 10 --> 10

		num=-num;
		//변수 선언 : 타입 변수명 = 값; // 변수 호출 : 변수명 // 변수값 수정 : 변수명 = 새로운 값
		
		//[3] 산술연산자 , + 덧셈 - 뺄셈 *곱셈 /나누기 %나머지
		System.out.println(5/3); // 1.xxxxxx -> 1로 출력 (몫) *int / int
		System.out.println(5.0 / 3.0); //1.666666666667 -> 나누기 결과
		System.out.println((int)(5.0/3.0)); // 1.66666666666667 -> 강제타입 -> 정수 변환
		
		int math = 90; int eng = 70;
		int total = math + eng; //총점
		System.out.println(total); // 총점변수의 값을 출력
		
		double avg = total / 2.0; // 평균 구하기
		System.out.println(avg); //평균변수의 값을 출력
		
		
		//복습
		int korScore2 = 100;
		int mathScore2 = 90;
		int engScore2 = 80;
		int tatalScore2 = korScore2 + mathScore2 + engScore2;
		double avgScore2 = tatalScore2 / 3.0; // totalScore2(int) / 3(int); => tatalScore2(int) / 3.0(double);
		System.out.println(tatalScore2);
		System.out.println(avgScore2);
		
		//[4] 증감연산자 , ++ -- , 주의할 점 : ;(세미클론/명령어단위) 기준으로 연산 우선순위를 정한다.
		int num2 = 10;
		int value2;
		value2 = ++num2; // num2 값이 1씩 증가 후에 value2 변수에 대입한다.
			System.out.println(value2); // num2 = 11 , value2 = 11
		value2 = num2++; // value2변수에 기존 num2 값이 먼저 대입한 후에 1씩 증가한다.
			System.out.println(value2); // value2 = 11 , num2 = 12
		value2 = --num2; // num2 값이 1씩 감소한 후에 value2 변수에 대입한다.
			System.out.println(value2); // num2 = 11 , value2 = 11
		value2 = num2--; // value2변수에 기존 num2 값이 먼저 대입한 후에 1씩 감소한다.
			System.out.println(value2); // value2 = 11 , num2 = 10;
		
		//복습
		int gameScore = 150;
		int lastScore = ++gameScore; // 변수앞에 ++이 있으므로 대입(=)보다 1증가가 우선이다.
		System.out.println(lastScore); // 151
		
		int lastScore2 = --gameScore; // 변수앞에 --이 있으므로 대입(=)보다 1감소가 우선이다.
		System.out.println(lastScore2); // 150
			//*사칙연산의 우선순위에 따라 *곱하기 후 +더하기 =>9
		int result1 = 3+3*2; System.out.println(result1);
			//* 연산순서
			// 3 * 2 = 6
			// 3 + 6 = 9
		
		int x = 10;
		int y = x-- +5+ --x;
			//* 연산순서
			//1. x-- + 5 = 10 + 5 => 15 [x는 +연산후 1차감] x = 9
			//2. 15 + --x = 15 + 8 => 23 [x는 +연산전 1차감] x = 8
		System.out.println(x); // 8
		System.out.println(y); // 23
		
		//[5] 비교연산자 , > 초과 < 미만 >=이상 <=이하 ==같다 !=다르다 , 결과는 true or false
		int myAge = 31;
		boolean value = (myAge >= 31);
		System.out.println(value); // true
			//() 소괄호를 사용한 이유는 가독성 높이기 위해서 사용
		
		
		
	}

}
