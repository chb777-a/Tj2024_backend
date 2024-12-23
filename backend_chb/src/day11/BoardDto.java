package day11;

//2. 게시물정보를 갖는 객체의 설계 클래스
public class BoardDto { //class start
	// 주석 먼저 달고 코드 작성 !!!
	
	//*클래스 멤버
	//1. 멤버변수 , 접근제한자 , 객체 속성
		//private - 외부 다른 클래스로부터 접근을 차단시킴
	private String title; //제목
	private String contents; // 내용물
	private String writer; // 작성자
	
	//2. 생성자 , 객체 생성시 초기화 담당 , new 생성자()
		// + 디폴트 생성자 규칙 : class명과 동일해야함 / 매개변수와 인수값 타입/개수 일치해야함
		// 1) 빈 생성자 (디폴트 생성자)
	public BoardDto() {}
		// 2) (전체) 매개변수가 3개인 생성자
	public BoardDto( String title, String content , String writer) {
		this.title = title;
		this.contents = content;
		this.writer = writer;
	}
	
	//3. 메소드 // 멤버함수 , 객체의 이벤트 또는 행위 // 객체가 실행할 함수 정의
		// 1. getter(호출) and setter(저장) : private 멤버변수를 다른 클래스로부터 간접 접근 제공하는 함수
	public String getTitle() { return this.title; }
	public void setTitle(String title) {this.title = title;}
	
	public String getContent() {return this.contents;}
	public void setContent(String content) {this.contents = content;}
	
	public String getWriter() {return this.writer;}
	public void setWriter(String writer) {this.writer = writer;}
	
}//class end
