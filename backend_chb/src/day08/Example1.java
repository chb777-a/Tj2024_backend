package day08;

import java.util.Scanner;

public final class Example1 {

	public static void main(String[] args) {
			Waiting[] waitingAr = new Waiting[100];
			
			while(true) {
				System.out.println("[1].대기명단등록 , [2].대기명단확인");
				Scanner scan = new Scanner(System.in);
				int choose = scan.nextInt();
				if(choose == 1) {
					System.out.println("대기명단 등록");
					System.out.println("인원수 : "); int count = scan.nextInt();
					System.out.println("전화번호 : "); String phone = scan.next();
					
					Waiting waiting = new Waiting();
					waiting.phone = phone; waiting.count = count;
					
					for(int index= 0; index <= waitingAr.length-1; index++) {
						if(waitingAr[index] == null) {waitingAr[index] = waiting; break;}
					}//for end
				}
				else if(choose == 2) {
					for(int index= 0 ; index <= waitingAr.length-1; index++) {
						if(waitingAr[index] != null)
							System.out.printf("인원수 %d명 , 연락처 : %s \n", waitingAr[index].count, waitingAr[index].phone);
					}
				}
			}
	}

}
