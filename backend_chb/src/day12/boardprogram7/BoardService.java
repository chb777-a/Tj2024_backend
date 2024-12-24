package day12.boardprogram7;

import java.util.Scanner;

public class BoardService {
	//게시물 등록함수
	public void boardAdd(Scanner scan , BoardDto[] boards , String loginId) {
		System.out.println("제목 :"); String title = scan.next();
		System.out.println("내용 :"); String content = scan.next();
		System.out.println("작성자는 로그인된 아이디로 대체됩니다.");
		String writer = loginId; // 로그인된 아이디를 작성자에 대입한다.
		// 생성자를 이용한 빠른 객체 생성
		BoardDto boardDto = new BoardDto(title , content , writer);
		// 빈 공간 찾기
		for(int i = 0; i<=boards.length-1; i++) {
			if(boards[i] == null) {
				boards[i] = boardDto;
				System.out.println("게시물 등록 성공");
				return; //함수 종료
			}
		} //for end
	}// 등록 함수 end
	
	//게시물 출력함수
	public void boardPrint(BoardDto[] boards) {
		System.out.println("순번 \t 작성자 \t 내용 ");
		for(int i = 0; i<= boards.length-1; i++) {
			if(boards[i] != null) {
				System.out.printf("%d \t %s \t %s \t %s \n",
					i ,
					boards[i].getWriter(),
					boards[i].getTitle(),
					boards[i].getContent() );
			}//if end
		}//for end
		
	}
}// c end
