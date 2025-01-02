package day17.step2;

// 키보드를 인터페이스로 사용하는 이유? 여러 게임(클래스)들을 조작하기 위해서 사용

public interface 키보드 {
	//1. 상수 : 수정 불가능한 변수
	public static final String 제조사 = "HP";
	String 제조일 ="2025-01-02"; // pulic static final는 생략 가능
	
	//2. 추상 메소드 : 메소드(함수)를 구현부{}는 작성하지 않고 선언부만 작성한다.
	public abstract void aKey();
	void bKey(); // public abstract는 생략 가능
	
}
