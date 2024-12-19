package day09;

import java.util.Scanner;

public class Waiting {
	void waitingAdd(Scanner scan , WaitingList[] waitingAr) {
		//1 입력
		System.out.println("대기등록");
		System.out.println("인원수 : ");
		int count = scan.nextInt();
		System.out.println("전화번호 : ");
		String phoneNum = scan.next();
		//2 객체생성
		WaitingList wl = new WaitingList();
		wl.count = count; wl.phoneNum = phoneNum;
		//3 객체를 배열에 저장
		for(int index=0; index <= waitingAr.length-1; index++) {
			if(waitingAr[index] == null) {waitingAr[index] = wl;
			break;
			}

		}//for end
	}//void end
	
	void waitingOut(WaitingList[] waitingAr) {
		System.out.println("대기현황");
		for(int index=0; index <= waitingAr.length-1; index++) {
			if(waitingAr[index]!=null) {
				System.out.printf("인원수 %d명 , 연락처 : %s \n", waitingAr[index].count , waitingAr[index].phoneNum);
			}
		}
	}
}
