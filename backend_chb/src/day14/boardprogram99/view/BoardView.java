package day14.boardprogram99.view;

import java.util.Scanner;

public class BoardView {
	private BoardView() {}
	private static BoardView instance = new BoardView();
	public static BoardView getInstance() {return instance;}
	private Scanner scan = new Scanner(System.in);//입력
	public void run() {
		while(true) {
			System.out.println("[1] 입력 [2] 출력 [3] 수정 [4] 삭제"); // 1~4입력해서 명령
			int choose = scan.nextInt();
			if(choose == 1) {create();}
			else if(choose == 2) {read();}
			else if(choose == 3) {update();}
			else if(choose == 4) {delete();}
		}//while end
	}//run end
	
	//1 = 게시물 쓰기
	public void create() {
		// 게시물 입력받기
		System.out.println("제목 : ");
		String title = scan.next();
		System.out.println("내용 : ");
		String content = scan.next();
		System.out.println("작성자 : ");
		String writer = scan.next();
		
	}//create end
	//2 = 게시물 출력
	public void read() {
		System.out.println(" 출력 ");// 출력 페이지 선택 시 출력
		
		
	}//read end
	//3 = 게시물 수정
	public void update() {
		System.out.println(" 수정 ");// 수정 페이지 선택 시 출력
		
	}//update end
	//4 = 게시물 삭제
	public void delete() {
		System.out.println(" 삭제 ");// 삭제 페이지 선택 시 출력
	}//delete end
} // c end
