package boardservice10.model.dto;

public class MemberDto {
	// DTO : 서로 다른 레이어(MVC패턴)들간의 데이터를 이동하는 객체
	// *** 주로 데이터베이스 테이블의 속성과 동일하다. + 커스텀 가능
	//1. 멤버 변수
	int mno;		// 회원번호
	String mid;		// 아이디
	String mpwd;	// 비밀번호
	String mname;	// 이름
	String mphone;	// 연락처
	String mdate;	// 가입일
	//2. 생성자
	
	//3. 메소드 , getter/setter , toString()
}
