package day12;

class Member{
	String name;
	static int age;
	
	boolean getAge() { return true; }
	
	static int getName() {return 10;}
}	
	

	
public class Example4 {
	public static void main(String[] args) {
		//**********함수 = 메소드 *************???
		
		//함수 호출 판단 :
			//1. 호출하고자 하는 클래스가 같은 클래스인지 다른 클래스인지 판단
			//2. 호출하고자 하는 메소드가 static(정적) 인지 아닌지를 판단
			//3. 호출하고자 하는 위치의 메소드가 static인지 아닌지
				// -static 없는 메소드는 객체를 통해 호출 , 변수명.메소드명()
				// -static 있는 메소드는 클래스를 통해 호출 , 클래스명.메소드명()
		
		//[1] main 함수 안에서 동일한 클래스 내부 메소드 호출하기.
		// signup(); // main 함수가 우선 할당이여서 signup 함수를 모른다.
			//해결방안
		Example4 example4 = new Example4();
		example4.signup();
		
		//[2] main함수 안에서 동일한 클래스 내부 메소드 호출하기
		login(); //main함수가 우선 할당 되고 login함수도 우선 할당되므로 호출이 가능하다.
		Member.getName(); // --> 다른 클래스 static 메소드이면 , 클래스명.static메소드명();
	
		//[3] 일반함수 안에서 동일한 클래스 내부 메소드 호출하기
		// 함수명();
		
		//[4] 일반함수 안에서 서로 다른 클래스 내부 메소드 호출하기
		//객체생성 (new) ======>> 변수명.함수명();
	}
	
	void signup() { // 메소드 //멤버함수
		myinfo(); // 일반 함수안에서 동일한 클래스 내부 함수 호출 가능 // 같은 클래스 메소드
		Member member = new Member();
		member.getAge(); // 서로 다른 클래스이면 객체 필요함
		
	}
	void myinfo() {
		
	}
	
	static void login() { // 정적 메소드 (static)
		
	}
} //class end