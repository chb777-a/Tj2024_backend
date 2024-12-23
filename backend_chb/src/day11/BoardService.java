package day11;

import java.util.Scanner;

public class BoardService { //class start
	//1. 멤버변수
	//2. 생성자
	//3. 메소드
	// 3_1. 게시물 등록
	public void boardAdd(Scanner scan , BoardDto[] boards) {
		System.out.println("제목 : "); String title = scan.next();
		System.out.println("내용 : "); String content = scan.next();
		System.out.println("작성자 : "); String writer = scan.next();
		// 생성자를 이용한 객체 생성
		BoardDto boardDto = new BoardDto(title,content,writer);
		// 배열에 저장
		boolean saveState = false;
		for(int index = 0; index <= boards.length-1; index++) {
			if(boards[index] == null) {// boards의 인덱스가 비어있으면
				boards[index] = boardDto;//boards의 인덱스에 boardDto를 넣는다.
				break;//종료
			}//if end
		}//for end
		if(saveState) {System.out.println("등록 성공!");}
		
	} // main end
	
	// 3_2. 모든 게시물 출력
	public void boardPrint(BoardDto[] boards) {
		for(int index = 0; index <= boards.length-1; index++) {
			if(boards[index] != null) {// boards의 인덱스가 비어있지 않다면
				System.out.printf("제목 : %s , 내용 : %s , 작성자 : %s" , //제목 , 내용 , 작성자를 boards 배열의 제목 , 내용 , 작성자를 boards 인덱스번째에 넣는다.
						boards[index].getTitle(),
						boards[index].getContent(),
						boards[index].getWriter());
			}//if end
		}//for end
		
	}
}
