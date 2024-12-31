package day16.step2;

class 상위클래스{ //상위 start
	int value1 = 10;
	int value3 = 30;
	//static int value3 = 30; : 멤버변수 공유
	//멤버변수는 공유 X // 변수는 (고유)값을 저장
	//메소드는 공유 O // 메소드는 코드(실행, 행위 코드) 저장
	public void showSuperValue() {
		System.out.println("상위클래스");
	}//show end
} // 상위 end

class 하위클래스 extends 상위클래스{ // 하위 start
	int value1 = 100;
	int value2 = 200;
	public void showSubValue() {
		System.out.println("하위클래스" + (this.value1) + (super.value1));
		//this : 100 // super : 10
	}//show end
} // 하위 end

public class Example2 { // c start
	public static void main(String[] args) {
		//1. 상위클래스 인스턴스 생성
		상위클래스 obj1 = new 상위클래스();
		System.out.println(obj1.value1); // 10 // 본인 인스턴스의 멤버변수 호출 // 단 하위 클래스의 멤버변수 접근 불가능
		// System.out.println(obj1.value2); // 오류 : 하위 클래스의 멤버변수 접근 불가능
		
		//2. 하위클래스 인스턴스 생성
		하위클래스 obj2 = new 하위클래스();
		System.out.println(obj2.value1); //100 // 만일 상위클래스와 하위클래스의 멤버변수명이 같으면 현재 클래스의 멤버변수가 우선순위
		System.out.println(obj2.value2); //200
		System.out.println(obj2.value3); // 30 // 하위 클래스의 인스턴스는 상위 클래스의 멤버변수를 호출 가능
		
		//3. 하위클래스에서 메소드 호출
		obj2.showSubValue(); // 현재 인스턴스의 메소드 호출
		obj2.showSuperValue(); // 현재 인스턴스가 물려받은 상위클래스의 메소드 호출
		
		//*
		하위클래스 obj3 = new 하위클래스();
		obj3.value1 = 300;
		obj3.showSubValue(); // [하위클래스] 300 10
		
	}//main end
}// c end
