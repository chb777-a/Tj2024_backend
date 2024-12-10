//한 줄 주석
/*여러 줄 주석*/

/*
 	1. .java 파일이란? 자바 코드를 작성할 수 있는 확장자명
 		-확장자명이란? 데이터를 사용하는 방법 정의
 	2. .class 파일이란? 자바가 .java파일을 컴파일(변역)해서 만든 파일 
 		- 워크스페이스내 프로젝트내 bin폴더내 번역된 .class파일 확인
 	3. main 함수란? 스레드가 내장된 함수
 		- 스레드란 ? 번역된  코드를 읽어들이기 위한 실흐름
 	
 	
 		*/

package day02; //현재 클래스가 위치한 패키지 / 폴더명

public class Example1 { //클래스의 시작 //컴파일이 번역하는 단위 // class 밖에 있는 코드는 번역 안 됨.
	//번역된 코드들을 읽고 실행할 코드는 무조건 main함수{} 안에서 코드를 작성

	public static void main(String[] args) { //main 함수 시작
		
		//상수 , final 키워드 , 상수명은 대문자로 사용한다. //p.61
		final int MAX_NUM = 100;
		final int MIN_NUM;
		MIN_NUM=0;
		
		// MAX_NUM = 1000; // 오류 : 상수는 수정이 불가능하다.
		
		// + 출력함수 JS : consolelog() JAVA : System.out.printIn();
		// 자동완성 , syso 입력 후 컨트롤 스페이스바 , +(연결연산자) : "문자열" + 변수명
		System.out.println("MAX_NUM" + MAX_NUM);
		System.out.println("MIN_NUM" + MIN_NUM);
		
		// 리터럴이란 ? 개발자가 키보드로부터 입력한 숫자, 문자, 논리들을 일컫는 말
			// 자바는 이러한 리터럴값들을 상수풀(메모리공간)이라는 곳에서 "상수"로 사용한다.
		// - 변수는 2개 , 리터럴값 1개
		int num1 = 3;
		int num2 = num1;
		// 0 변수는 2개 , 리터럴값 1개
		char str1 = 'a';
		char str2 = 'a';

	} //main 함수 시작

}//클래스 끝
