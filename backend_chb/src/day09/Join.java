package day09;

import java.util.Scanner;

public class Join {
	void JoinUs(Scanner scan , JoinList[] joinAr) {
		//입력
		System.out.println("Join Us");
		System.out.println("ID"); String id = scan.next();
		System.out.println("Password"); String pw = scan.next();
		System.out.println("Nickname"); String nick = scan.next();
		//객체생성
		JoinList jl = new JoinList();
		jl.id = id; jl.pw = pw; jl.nick = nick;
		//객체 배열 저장
		boolean signupState = false;
		for(int index=0; index <= joinAr.length-1; index++) {
			if(joinAr[index] == null) {
				joinAr[index] = jl;
				signupState = true;
				break;}
					}//for end
			if(signupState) {System.out.println("Join Success");}
			else{System.out.println("Can't Join.");}
			
	}//void end
	
	void LoginUs(Scanner scan , JoinList[] joinAr) {
		//입력
		System.out.println("Login");
		System.out.println("ID"); String ida = scan.next();
		System.out.println("비밀번호"); String pwa = scan.next();
		//객체 생성
		boolean states = false;
		//객체 배열 저장
		for(int index = 0; index <= joinAr.length-1; index++) {
			if(joinAr[index]!= null) {
				if(joinAr[index].id.equals(ida) && joinAr[index].pw.equals(pwa)) {

					System.out.println("Login Succeess");
					states = true;
					break;
					}
				}
			} //for end
			if(states) {System.out.println("Login Success");}
			else {System.out.println("Login false");}
		
	}//void end
}//class end

/*
 	1. 기본타입 : boolean char byte short int long float double
 		- 스택 메모리 비교
 	2. 참조/클래스 타입 : String / Scanner / Member / MemberService ( 기본타입 8개 외)
 		- .equals() : 참조타입 비교*/

