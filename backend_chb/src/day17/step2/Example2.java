package day17.step2;

public class Example2 {
	public static void main(String[] args) {
		//[1] 인터페이스 타입의 변수 생성 , 키보드 변수 생성
		키보드 myKeyBoard;
		//[2] 구현체 : 인터페이스의 추상 메소드를 구현한 객체
			//1. 사냥 게임 ㄱㄱ
			//2. 키보드에 사냥게임 연결
		myKeyBoard = new 사냥게임(); // new 사냥게임() --> 구현한 객체
		myKeyBoard.aKey(); // 공격 !!
		myKeyBoard.bKey(); // 방어 !!
			//1. 다른 게임으로 ㄱㄱ (타입 변환)
		myKeyBoard = new 축구게임();
		myKeyBoard.aKey(); // 슈팅 !!
		myKeyBoard.bKey(); // 패스 !!
		
		//[3] 생각해보기  : 키보드 타입이 없어도 게임타입으로 실행이 가능하다.
		사냥게임 게임1 = new 사냥게임();
		게임1.aKey(); // 공격
		게임1.bKey(); // 방어
		
		// 게임1 = new 축구게임; // 오류 : 사냥게임 인스턴스는 축구게임의 타입을 모른다.
			//사냥게임 --> 키보드
			//축구게임 --> 키보드
		
	} // main end
} // c end
