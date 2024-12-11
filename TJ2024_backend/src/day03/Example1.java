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
		
	}

}
