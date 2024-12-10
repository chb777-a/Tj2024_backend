package day02; //폴더명

public class Example2 { //클래스 시작

	public static void main(String[] args) { //main 시작
		
		//1. 자동(자료/타입)형 변환, 묵시적 (자로/타입)형 변환
			// - 1. 메모리 크기가 작은 것부터 큰 순으로 변환
			// - 2. 데이터 손실이 없다.
			// - 3. 연산(계산) 중에 큰 값으로 변환된다.
			// byte => short , char => int => long => float => double
		
		byte byteValue = 10;	// byte 타입으로 'byteValue'라는 변수에 10을 대입
		short shortValue = byteValue;	// short 타입으로 'shortValue'라는 변수에 byte 10을 대입
		int intValue = shortValue;	//int 타입으로 'intValue'라는 변수에 short 10을 대입
		long longValue = intValue; //long 타입으로 'longValue'변수에 int 10을 대입
		float floatValue = longValue; // float 타입으로 'floatValue'변수에 long 10을 대입
		double doubleValue = floatValue; // double 타입으로 'doubleValue'변수에 float 10을 대입
		System.out.println("double value : " + doubleValue); //byte에서 double까지 자동형변환
			// + 연산중에 묵시적 형변환 , 연산시 피연산자중에 더 큰 타입으로 결과를 반환한다.
				//byte + byte => int , int 이하 byte와 short 연산 결과는 무조건 int로 변환된다.
				//byte + short => int ,
				//int + int => int
				//int + long => long
				//int + float => float
		
		byte b1 = 10; byte b2 = 20; short s1 = 30; int i1 = 40;
		float f1 = 3.14f; double d1 = 41.25;
		int result1 = b1 + b2;
		int result2 = b1 + s1;
		float result3 = i1 + f1;
		double result4 = f1 + d1;
		//System.out.println("b3 :" + b3);
		
		
		//2. 강제 (자료/타입)형 변환 , 명시적 (자료/타입)형 변환 , 캐스팅
			// -1. 메모리 크기가 큰값부터 작은 순으로 변환
			// -2. 데이터의 (허용범위 외) 손실이 있을 수 있다.
			// -3. (변환할 타입명)변수명
			// - double => float => long => int => short, char => byte
		double value1 = 3.14;
		float value2 = (float)value1;
		long value3 = (long)value2;
		int value4 = (int)value3;
		short value5 = (short)value4;
		byte value6 = (byte)value5;
		System.out.println("byte value: " + value6); //3.14 =>3
		
		//++ 자바특징 중 다형성(다양한 형식/타입을 가지는 성질)은 형변환으로부터 표현할 수 있다.
		
		//
		char ch1 = 'A';
		int int1 = ch1;
		System.out.println(int1); //65: A, 66: B , 67 : C , 아스키코드표에서 확인
		System.out.println((int)ch1);
		
		int ch2 = 67;
		System.out.println((char)ch2); // 'C'
				
		// + 연산중에 강제 타입변환
		int result5 = (int)381.01+3;
		
		int rel1 = 10;
		double rel2 = 2.0;
		double relsu = rel1 + rel2; //int + double -> double
		System.out.println("결과1 : " + relsu);
		
		char 문자1 = '글'; // 문자열 "" , 문자 ''
		int 문자정수1 = 문자1;
		System.out.println("글 정수 : " + 문자정수1);
		System.out.println("글 정수 : " +(char)(문자정수1+1)); // 긁 (아스키코드표에서 확인)
			//+ JAVA 정수로 표현하면 , 74 65 86 65
		System.out.println((char)74 +""+(char)65+""+(char)86+""+(char)65); //JAVA
		
		
		
	}

}
