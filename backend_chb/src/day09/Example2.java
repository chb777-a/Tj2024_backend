package day09;

import java.util.Scanner;

public class Example2 {

	public static void main(String[] args) {
		Join info = new Join(); // 회원가입 객체 생성
		JoinList[] joinAr = new JoinList[100]; // 객체 여러개 배열 저장
		
		while(true) {
			System.out.println("[1] Join [2] Login");
			Scanner scan = new Scanner(System.in);
			
			int choose = scan.nextInt();
			
			if(choose == 1) {
				info.JoinUs(scan , joinAr);
			}
			else if(choose == 2) {
				info.LoginUs(scan , joinAr);
			}
		}
	}

}
