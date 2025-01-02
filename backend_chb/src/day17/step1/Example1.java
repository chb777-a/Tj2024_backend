package day17.step1;

import java.nio.channels.AsynchronousSocketChannel;

class Tool1 implements InterfaceTest{
	// (1) 클래스가 인터페이스의 추상메소드를 구현하기
	// - class 클래스명 implements 인터페이스명
	// - 인터페이스의 모든 추상메소드를 구현하기 전까지 오류메시지 발생
	
	// (2) 추상메소드 구현하기
		//1. 선언부 동일하게 작성! 반환타입명 메소드명 (타입 매개변수)
		//2. 오버라이딩 : 상속 또는 구현했을 때 메소드를 재정의
	public int method2(int a) {
		System.out.println("tool1 클래스 구현 메소드");
		return a;
	} // f end
	@Override // 생략 가능
	public int method3(int a) {
		System.out.println("tool1 클래스가 구현한 method3");
		return a;
	}
} // tool end

class Tool2 implements InterfaceTest{
	// 추상메소드 구현하기 . 자동완성 : 빈공간에 컨트롤 + 스페이스바
	@Override
	public int method2(int a) {
		System.out.println("tool2 클래스가 구현한 method2");
		return a;
	}
	@Override
	public int method3(int a) {
		System.out.println("tool2 클래스가 구현한 method3");
		return a;
	}
} // tool2 end

public class Example1 {
	public static void main(String[] args) {
		//1. 인터페이스 상수 사용
			//인터페이스.상수명;
		System.out.println(InterfaceTest.value2);
		System.out.println(InterfaceTest.value3);
		
		//2. 인터페이스의 추상 메소드 사용
			//추상메소드란? 구체적인 메소드가 아닌 공통적인 특성만 선언
				// InterfaceTest.method2(); // 오류
				//- 메소드의 구현부{}가 없으므로 호출이 불가능하다
		
			// !!! : 추상메소드를 (클래스들이) 구체적으로 구현하기
			Tool1 tool1 = new Tool1();
			tool1.method2(10);
			tool1.method3(20);
				// why? 인터페이스를 사용하는 이유?
			InterfaceTest inter1 = new Tool1();
			inter1.method2(10);
			inter1.method3(20);
				// why? :
			InterfaceTest inter2 = new Tool2();
			inter2.method2(10);
			inter2.method3(20);
			
			
	}//main end
}//c end
