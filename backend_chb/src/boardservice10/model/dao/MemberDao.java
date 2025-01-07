package boardservice10.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

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
}
