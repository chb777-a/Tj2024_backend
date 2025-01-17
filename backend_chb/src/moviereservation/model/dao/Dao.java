package moviereservation.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

//접근제한자
//public : 프로그램내 모든 곳에서 접근 가능
//private : 현재 클래스에서만 사용 가능
//(defalut)/기본값 : 같은 패키지에서만 접근 가능 * 접근제한자를 작성
//protected : 같은 패키지에서만 접근 가능 *상속관계이면 다른 패키지도 가능

public class Dao {
	protected Connection conn;	//DB와 연동 결과를 조작하는 인터페이스
	private String dburl = "jdbc:mysql://localhost:3306/moviereservation"; //연동할 DB서버의 URL
	private String dbuser = "root";
	private String dbpwd="1234";
	public Dao() {
		try {
			//1.JDBC 클래스 드라이버 로드,Class.forName()
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2. 설정한 경로/계정/비밀번호로 DB서버 연동을 시도하고 결과를 (구현체) 반환
			conn = DriverManager.getConnection(dburl, dbuser, dbpwd);
			}catch(Exception e) {
				System.out.println("[ DB연동 실패 ]"+e);
			}
	}

}
