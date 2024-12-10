package day02;

import java.util.Scanner;

public class Example5 {

	public static void main(String[] args) {
		//[1]
		Scanner scan = new Scanner(System.in);
		
		System.out.println("국어 점수 입력");
		int kr = scan.nextInt();
		System.out.println("영어 점수 입력");
		int en = scan.nextInt();
		System.out.println("수학 점수 입력");
		int ma = scan.nextInt();
		
		
		
		
		int result1 = kr + en + ma;
		System.out.println("3과목 총점 : " + result1);
		
		double result2 = result1/3;
		System.out.println("3과목 평균 : " + result2);
		
		//[2]
		System.out.println("반지름 입력 :");
		double circle = scan.nextDouble();
		
		double result3 = circle*circle*3.14;
		System.out.println("원넓이 : " + result3);
		
		//[3]
		System.out.println("앞 실수 입력");
		double num1 = scan.nextDouble();
		System.out.println("뒤 실수 입력");
		double num2 = scan.nextDouble();
		double num3 = num1/num2*100;
		System.out.println("값의 비율 : " + num3 + "%");
		
		//[4]
		System.out.println("정수 입력");
		int num4 = scan.nextInt();
		boolean result5 = num4%2==0?false : true;
		System.out.println("홀짝 : " + result5);
		
		//[5]
		System.out.println("정수 입력");
		int num5 = scan.nextInt();
		boolean result6 = (num5 % 7 == 0) ? true : false;
		System.out.println("7의 배수: " + result6);
		
		//[6]
		System.out.println("정수 입력");
		int num6 = scan.nextInt();
		boolean result7 = (num6 % 2 == 1 && num6 % 7 == 0) ? true : false;
		System.out.println("결과 : " + result7);
		
		//[7]
		System.out.println("금액 입력");
		int 금액 = scan.nextInt();
		int 십만원권 = 금액 / 100000;
		int 만원권 = (금액 % 100000) / 10000;
		int 천원권 = (금액 % 10000) / 1000;
		
		System.out.printf("십만원권 : "+십만원권+" 만원권 : "+만원권+" 천원권: "+천원권+" \n");
		
		
		//[8]
		System.out.println("점수 입력 1");
		int score1 = scan.nextInt();
		System.out.println("점수 입력 2");
		int score2 = scan.nextInt();
		
		int scoreResult = score1 + score2;
		
		System.out.println(scoreResult>=150? "합격" : "불합격");
		

	}

}
