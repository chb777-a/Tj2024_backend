package boardservice10.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import boardservice10.model.dto.MemberDto;

public class MemberDao {
	private Connection conn; // DB와 연동된 결과를 조작하는 인터페이스
	private String dburl = "jdbc:mysql://localhost:3306/boardservice10"; // 연동할 DB 서버의 URL
	private String dbuser = "root"; // 연동할 DB 서버의 계정명
	private String dbpwd = "1234"; // 연동할 DB 서버의 비밀번호
	
	// 싱글톤 : 프로그램 내 인스턴스(객체) 1개만 만들 수 있도록 하는 디자인 패턴
	// 싱글톤 생성
	private static MemberDao instance = new MemberDao();
	private MemberDao() {
		try {
			//1. JDBC 클래스 드라이버 로드 , Class.forName() * 예외처리 try{}catch(){}
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. 설정한 경로/계정/비밀번호로 DB 서버 연동 시도하고 결과를 (구현체) 반환
			conn = DriverManager.getConnection(dburl, dbuser, dbpwd);
		}catch(Exception e) {
			System.out.println("DB 연동 실패!" + e);
		} //catch end
	}// MemberDao end
	public static MemberDao getInstance() {return instance;}
	
	//1. 회원가입 SQL 처리 메소드
	public boolean signup( MemberDto memberDto) {
		try{
			//[1] SQL 작성
			String sql = "insert into member( mid , mpwd , mname , mphone )values('"+memberDto.getMid()+"' , '"+memberDto.getMpwd()+"' , '"+memberDto.getMname()+"' , '"+memberDto.getMphone()+"')"; 
			//[2] DB의 연동된 곳에 SQL 기재한다. 연동된 db에 sql을 기재하는 방법 : conn.prepareStatement(SQL)
			PreparedStatement ps = conn.prepareStatement(sql);
			//[3] 기재된 SQL을 실행하고 결과 받기 기재된 sql을 실행하는 방법 : ps.excuteUpdate()
			int count = ps.executeUpdate();
			//[4] 결과에 따른 처리 및 반환을 한다.
			if( count == 1) {return true;}
		}catch(SQLException e) {System.out.println(e);}
		return false;
	} // signup end
	
	//2. 로그인 SQL 처리 메소드
	public int login( MemberDto memberDto) {
		//int : SQL로 조회된 회원번호를 반환하기 위해서
		try {
			//[1] SQL 작성
			String sql = "select mno from member where mid = ? and mpwd = ?";
			//[2] DB와 연동된 곳에 SQL 기재
			PreparedStatement ps = conn.prepareStatement(sql);
			//[*] 기재된 SQL에 매개변수 값을 대입
				ps.setString(1, memberDto.getMid());
				ps.setString(2, memberDto.getMpwd());
			//[3] 기재된 SQL을 실행하고 결과 받기
			ResultSet rs = ps.executeQuery();
			//[4] 결과에 따른 처리 및 반환
			if(rs.next()) {
				int mno = rs.getInt("mno");
				return mno;
			}//if end
		}catch(SQLException e) {System.out.println(e);}
		return 0;
	} //login end
	
	//3. 아이디 찾기 SQL 처리 메소드
	public String findId( MemberDto memberDto) {
		try{ // 검사
		//[1] SQL 작성		// mname = '유재석' ---> mname = ? : mname는 어떤 값이 들어갈지 정해져 있지 않다. (매개변수)
		String sql = "select mid from member where mname = ? and mphone = ? ";
		//[2] DB와 연동된 곳에 SQL 기재 + ? 매개변수 값 대입
		PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setString(1 , "유재석"); //ps.setString() : mname이 String 타입이라서
			ps.setString(1, memberDto.getMname());
			ps.setString(2, memberDto.getMphone());
		//[3] 기재된 SQL을 실행하고 결과 받기
		ResultSet rs = ps.executeQuery();
		//[4] 결과에 따른 처리 및 반환
		if(rs.next()) { //.next 다음 레코드로 이동
			String findMid = rs.getString("mid");
			return findMid; // 찾음 / 찾은 아이디 반환
		}//if end
	}// try end
	catch(SQLException e) {System.out.println(e);}
	return null; // 못찾음 null 반환
	} // findId end
	
	//4. 비밀번호 찾기 SQL 처리 메소드
	public String findPwd( MemberDto memberDto) {
		try {
		//[1] SQL 작성
			String sql = "select * from member where mid = ? and mphone = ?";
		//[2] DB와 연동된 곳에 SQL 기재
			//ps.setString(1 , "qwe1234"); //ps.setString() : mid이 String 타입이라서
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, memberDto.getMid());
				ps.setString(2, memberDto.getMphone());
		//[3] 기재된 SQL을 실행하고 결과 받기
			ResultSet rs = ps.executeQuery();
		//[4] 결과에 따른 처리 및 반환
			if(rs.next()) {
				String findPwd = rs.getString("mpwd");
				return findPwd;// 찾은 아이디 반환
			}//if end
		}catch(SQLException e) {System.out.println(e);}
		return null; // 못 찾음 null 반환
	}
	
	//6. 내정보보기 SQL 처리 메소드 
	public MemberDto myInfo(int loginMno) {
		try{
		//[1] SQL 작성
		String sql = "select * from member where mno = ?";
		//[2] DB와 연동된 곳에 SQL 기재
		PreparedStatement ps = conn.prepareStatement(sql);
		//[*] 기재된 SQl에 매개변수 값 대입
			ps.setInt(1, loginMno);
		//[3] 기재된 SQL 실행하고 결과를 받는다
		ResultSet rs = ps.executeQuery();
		//[4] 결과에 따른 처리 및 반환
		if(rs.next()) {
			MemberDto memberDto = new MemberDto();
			memberDto.setMid(rs.getString("mid"));
			memberDto.setMname(rs.getString("mname"));
			memberDto.setMphone(rs.getString("mphone"));
			memberDto.setMdate(rs.getString("mdate"));
			return memberDto; // 조회된 회원정보를 반환
		}//if end
		}catch(SQLException e) {System.out.println(e);}
		return null; // 조회된 회원 정보가 없을 시 null 반환
	} // myInfo end
	
	//7. 회원탈퇴 SQL 처리 메소드
	public void delete(int loginMno) {
		try {
			String sql = "delete from member where mno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, loginMno);
			int count = ps.executeUpdate();
		}catch(SQLException e) {System.out.println(e);}
		return;
	}// delete end
}// c end
