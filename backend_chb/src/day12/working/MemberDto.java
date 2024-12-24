package day12.working;

//기능 : 로그인 / 회원가입 / 로그아웃 / 도서등록 / 도서목록 출력 / 도서대여 / 도서반납 / 대여현황 출력
	// [1]회원가입 : [1]일반인 => 아이디 비밀번호 / [2]관리자 => 아이디 비밀번호 관리자번호
	// [2]로그인 : [1]일반인 => 아이디 비밀번호 일치시 로그인 / [2]관리자 => 아이디 비밀번호 관리자번호 일치시 로그인

public class MemberDto {
	private String id;
	private String pw;
	private String manager;
	
	public MemberDto() {};
	public MemberDto(String id , String pw , String manager) {
		this.id = id;
		this.pw = pw;
		this.manager = manager;
	}
	public String getId() {return this.id;}
	public void setId(String id) {this.id = id;}
	
	public String getPw() {return this.pw;}
	public void setPw(String pw) {this.pw = pw;}
	
	public String getManager() {return this.manager;}
	public void setManager(String manager) {this.manager = manager;}
	
	
} //class end	
