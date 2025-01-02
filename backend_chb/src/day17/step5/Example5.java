package day17.step5;

interface InterFaceTest2{
	//인터페이스의 구성멤버
	//1. 상수 : 수정이 불가능한 변수
	public static final int value = 10;
	//2. 추상 메소드 : 선언부(접근제한자 / 반환타입 / 메소드명 / 매개변수)만 작성 , 구현부 {} 작성하지 않음
	public abstract void method(); // {} 중괄호가 없음
	// 추가된 메소드
	//3. 디폴트 메소드
	public default void method2() {} // 인터페이스에 구현한 메소드를 만들수 있다.
	//4. 정적 메소드
	public static void method3() {} // 인터페이스에 정적 구현 메소드를 만들 수 있다.
	//5. private 메소드
	private void method4() {} // 현재 인터페이스에서 사용 가능한 구현 메소드를 만들 수 있다. 
	//6. private 정적 메소드
	private static void method5() {} // 현재 인터페이스에서 사용 가능한 정적 구현 메소드를 만들 수 있다.
	
	//+ : 인터페이스는 클래스와 다르게 생성자가 없다. 즉) 인터페이스는 new 인터페이스명(); / (인스턴스)를 만들 수 없다.
		// 생성자란  ? 클래스의 구성 멤버이자 클래스로 인스턴스를 만들 때 인스턴스를 초기화하는 메소드 / 역할
	// + : static 이란 ? 프로그램 시작할 때 메모리 할당 되고 프로그램이 끝날 때 메모리 초기화 [상수 / 전역(공유)]
		// - static 있는 변수 또는 메소드는 인스턴스가 없어도 사용이 가능하다.
} // itf end

public class Example5 {
	public static void main(String[] args) {
		//[1] 인터페이스의 상수 호출
		System.out.println(InterFaceTest2.value);
		//[2] 인터페이스의 추상메소드 호출
		// InterFaceTest2.method(); // 오류 // 불가능 // X
		//[3] 인터페이스의 디폴트메소드 호출
		// InterFaceTest2.method2(); // 오류 // 불가능 // X
		//[4] 인터페이스의 정적(static)메소드 호출
		InterFaceTest2.method3(); // 가능 // O

		//[*] 인터페이스 타입은 new 할 수 없다. 즉) 인스턴스 생성 불가능
		// InterFaceTest2 inter = new InterFaceTest2(); // 오류 : 인터페이스 타입은 인스턴스 생성 불가능
	} //main end
}//c end
