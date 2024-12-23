package day11;

import java.util.Scanner;
//1. 메인함수를 갖는 프로그램 실행 클래스
public class BoardProgram6 { // class start
	public static void main(String[] args) { // main start
		//
		BoardDto[] boards = new BoardDto[100]; // boardDto 100개를 저장할 수 있는 배열 생성
		BoardService bs = new BoardService(); // BoardService 객체 생성
		
		while(true) { //while start , 무한루프
			System.out.println("[1] 등록 [2]출력");
			Scanner scan = new Scanner(System.in); // 입력
			int choose = scan.nextInt();
			if(choose == 1) { //1번을 입력했을 시
				//등록함수 호출 , 사용
				bs.boardAdd(scan , boards);
			}//if end
			else if(choose == 2) { //2번을 입력했을 시
				bs.boardPrint(boards);
				//출력함수 호출
				
			}//else if end
		} //while end
	}//main end
}//class end
