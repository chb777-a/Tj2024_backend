package day09;

import java.util.Scanner;

public class BoardProgram4 {

	public static void main(String[] args) {
		//(1) 게시물 기능을 제공하는 서비스 객체 생성
		BoardService bs = new BoardService();
		//(2) 게시물 객체 여러개를 저장하는 배열 생성
		Board[] boards = new Board[100];
		
		while(true) {
			System.out.println("1.등록 2.출력");
			Scanner scan = new Scanner(System.in);
			int choose = scan.nextInt();
			if(choose == 1) {	
				bs.boardAdd(scan , boards);// (1) 객체를 통한 메소드 호출
				}
			else if(choose == 2) {
				bs.boardPrint(boards);// (1) 객체를 통한 메소드 호출
			}
		}//while end
		}
		

	}

