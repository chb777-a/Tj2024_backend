package day18.step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	// + DB연동 정보
	private String DBURL = "jdbc:mysql://localhost:3306/mydb0103";
	private String DBID = "root";
	private String DBPW = "1234";
	// + JDBC 인터페이스
	private Connection conn;
	
	// + 싱글톤
	// 1. 디폴트 생성자를 private 한다.
	private Dao() {
		// JDBC (DB) 연동
		try {
		//1. 드라이버 로드
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2. DB 서버와 연결 시도
		DriverManager.getConnection(DBURL , DBID , DBPW);
		System.out.println("DB연동 성공!");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버가 존재하지 않습니다." + e);
		} catch (SQLException e) {
			System.out.println("DB연동 실패!" + e);
		} // f end
	}
	
	// 2. private static 인스턴스 생성
	private static Dao instance = new Dao();
	
	// 3. 싱글톤 반환 함수
	public static Dao getInstance() {
		return instance;
	}
} // c end
