package day16.step3;

class Parent{
	String flied1; // 멤버변수
	
	public void method1() {
		System.out.println("Parent method1");
	} //method1 end
	public void method2() {
		System.out.println("Parent method2");
	} //emthod2 end
	
} //parent end

class Child extends Parent{
	String flied2; // 멤버변수
	
	public void method3() {
		System.out.println("Parent method3");
	} //method3 end

	// 물려받은 메소드를 재정의 ( 코드 변경 ) = 오버라이딩
		// 주의할 점 : 메소드의 선언부를 동일하게 작성해야함
		// 멤버변수가 동일하면 this/super , 메소드명은 동일해도 this/super 사용하지 않음 왜 ? 메소드는 공유
		// 멤버변수는 인스턴스마다 , 메소드는 공유.
	
	//@override // 오버라이딩 어노테이션 // 생략 가능
	public void method1() {
		System.out.println("Child method1");
	}
	public void method2() {
		System.out.println("Child method2");
	}
} //Child end

public class Example3 {
	public static void main(String[] args) {
		//1. 자식 클래스의 인스턴스 생성
		Child child = new Child();
		child.method1(); // 자식 인스턴스는 부모 클래스의 메소드를 사용할 수 있음
		child.method2(); // 부모 메소드 사용 => override => Child method1 ( 본인의 method1 사용 ) // 부모 메소드가 아닌 본인메소드 우선순위를 갖음
		child.method3(); // 본인(자식 , 하위 클래스) 메소드 사용 // 즉) 오버라이딩이 최우선 호출 대상이 된다.
		// 메소드는 본인 메소드 위주로 우선 순위를 갖는다.
		
		//2. 자식 클래스의 인스턴스가 부모 클래스로 타입 변환
		Parent parent = child; // 타입변환
		parent.method1();  // Child method1 // 타입이 변환된다고 해서 인스턴스 바뀌는 건 아니다.
		parent.method2();
		// parent.method3(); // 오류 : 타입변환시 하위타입 멤버에 접근할 수 없다.
		
		//3. 부모 클래스의 타입에서 자식 클래스의 타입 변환 
		Child child2 = (Child)parent; // 부모타입 --> 자식타입 OK // 태생이 child 이라서
		child2.method1(); // Child method1
		child2.method2(); // Child method2
		child2.method3(); // Parent method3
		
		//4. 부모 클래스의 인스턴스 생성
		Parent parent2 = new Parent();
		parent2.method1(); //Parent method1
		// Child child3 = (Child)parent2; // 부모타입 --> 자식타입 fail // 태생이 child 아니라서
		// 태생 검사
		if(parent2 instanceof Child) {
			//parent2 변수가 가리키는 인스턴스가 Child 타입을 참조하고 있는가? true or false 로 대답
			Child child3 = (Child)parent2;
			System.out.println("타입변환 성공!");
		}else {
			System.out.println("타입변환 불가!");
		}
		
	} // main end
} // c end
