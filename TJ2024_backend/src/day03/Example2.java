package day03;

public class Example2 {

	public static void main(String[] args) {
		// [1]
		int myAge = 23;
		int teacherAge = 38;
		
		boolean value = (myAge>25);
		System.out.println(value);
		System.out.println(myAge<=25);
		System.out.println(myAge == teacherAge);
		char ch;
		ch = (myAge> teacherAge) ? 'T' : 'F';
		System.out.println(ch);
	
		//[2]
		int num;
		num = -5 +3*10 / 2;
		System.out.println(num); // 10
		
		//[3]
		int num2 = 10;
		System.out.println(num2); // 10
		System.out.println(num2++); //10
		System.out.println(num2); //11
		System.err.println(--num2); //10
		
		//[4]
		int num3 = 10;
		int num4 = 20;
		boolean result1;
		result1 = ((num3>10) && (num4>10)); //false --> 둘 중 하나만 틀려도 거짓
		System.out.println(result1);
		
		result1 = ((num3>10) || (num4>10)); //true --> 둘 중 하나만 맞아도 참
		System.out.println(result1);
		System.out.println(!result1); //false --> ! 참을 거짓으로 바꿈
	
		
		//[6]
		int num5 = 8;
		System.out.println(num5 +=10);
		System.out.println(num -=10);
		
		//[7]
		int num6 = 10;
		int num7 = 20;
		int result7 = (num6 >= 10) ? num7 + 10 : num7 -10;
		System.out.println(result7);
	}

}
