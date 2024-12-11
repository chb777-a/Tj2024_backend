package day03;

import java.util.Scanner;

public class Example3 {

	public static void main(String[] args) {
		//[if ~else]문
		int age = 7;
		if(age >= 8) {System.out.println("학교에 다닙니다.");} //if end
		else{System.out.println("학교에 다니지 않습니다.");}
		
		
		//[복습]
		char gender = 'F';
			if( gender=='F') {
				System.out.println("여성입니다.");}
			else {System.out.println("남성입니다.");}
			
			
			
		//[3]
		Scanner scan = new Scanner(System.in);
		System.out.println("나이를 입력하세요.");
		int age2 = scan.nextInt();
		int charge;
		if(age2<8) {
			charge=1000;
			System.out.println("취학 전 아동입니다.");
		}
		else if(age2<14) {
			charge=2000;
			System.out.println("초등학생입니다.");
		}
		else if(age2<20) {
			charge=2500;
			System.out.println("중,고등학생입니다.");
		}
		else if(age2>=60) {
			charge=0;
			System.out.println("경로 우대 대상입니다.");
		}
		else {
			charge=3000;
			System.out.println("성인입니다.");
		} //if end
		System.out.println("입장료는"+charge+"원 입니다.");
		
		
		// if~else if ( 다수 조건에 따른 하나의 결과실행문 ) vs if if ( 다수조건에 따른 N개의 결과실행문)
		
		
		//[나 혼자 코딩] p.100
		System.out.println("점수를 입력하세요.");
		int score = scan.nextInt();
		char grade;
		if (score <=100 && score >= 90 ) {
			grade = 'A';
			System.out.println("A학점입니다.");
		}
		else if (score < 90 && score >= 80 ) {
			grade = 'B';
			System.out.println("B학점입니다.");
		}
		else if (score < 80 && score >= 70 ) {
			grade = 'C';
			System.out.println("C학점입니다.");
		}
		else if (score < 70 && score >= 60 ) {
			grade = 'D';
			System.out.println("D학점입니다.");
		}
		else {
			grade = 'F';
			System.out.println("F학점입니다.");
		}
		System.out.println("점수는"+score+"이고 학점은"+grade+"입니다.");
	}//main end

	
} //class end
