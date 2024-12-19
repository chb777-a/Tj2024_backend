package day09;

import java.util.Scanner;

public class Example1 {

	public static void main(String[] args) {
		Waiting info = new Waiting(); // 웨이팅 목록 객체 생성
		WaitingList[] waitingAr = new WaitingList[100]; // 객체 여러개 배열 저장
		
		while(true) {
			System.out.println("[1]대기등록 , [2]대기현황");
			Scanner scan = new Scanner(System.in);
			int choose = scan.nextInt();
			if(choose == 1) {
				info.waitingAdd(scan , waitingAr );
			}
			else if(choose ==2 ) {
				info.waitingOut(waitingAr);
			}
		}
		
		

	}

}
