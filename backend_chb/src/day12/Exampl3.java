package day12;

class Student{ //student class start
	
	// + 정적 변수 ( 스태틱 변수 ) : 프로그램 시작될 때 한 번 생성된다.
	public static int serialNum = 1000;
	
	// + 멤버 변수 : 인스턴스 생성할때마다 각 변수가 생성된다.
	public int studentID;
	public String studentName;
	public int grade;
	public String address;
	// + 생성자
	
	// + 메소드
	public String getStudentName() {return studentName;}
	public void setStudnetName(String name) {studentName = name;}
}//class end

class Student1{ //student class start
		
		
	public static int serialNum = 1000;
	
		
	public int studentID;
	public String studentName;
	public int grade;
	public String address;
		
	public Student1() {
		serialNum++; // 학생이 생성될때마다 1씩 증가
		studentID = serialNum;//증가된 값을 학번 멤버변수에 대입한다.
	}
		
	public String getStudentName() {return studentName;}
	public void setStudnetName(String name) {studentName = name;}
	}//class end

class Student2{ //student class start
	
	// static변수에 private
	private static int serialNum = 1000;
	
	// + 멤버 변수 : 인스턴스 생성할때마다 각 변수가 생성된다.
	public int studentID;
	public String studentName;
	public int grade;
	public String address;
	
	public Student2() {
		serialNum++;
		studentID = serialNum;
	}
	public static int getSerialNum() {
		int i = 10;
		// return this.serialNum; 오류 : static 변수라
		return serialNum;
		}
	public static void setSerialNum() {
		//this.serialNum = serialNum; 오류 : static에 안 먹힘
		Student2.serialNum = serialNum;
	}
	
	public String getStudentName() {
		return studentName;
		}
	public void setStudentName(String name) {
		studentName = name;
	}
	
	}//class end

	
public class Exampl3 { // c start
	public static void main(String[] args) {
		// 인스턴스 생성
		Student studentChoi = new Student();
		studentChoi.setStudnetName("최홍빈");
		System.out.println(studentChoi.serialNum);
		studentChoi.serialNum++; // 1증가
		//인스턴스 생성
		Student studentPark = new Student();
		studentPark.setStudnetName("박수진");
		System.out.println(studentChoi.serialNum); //1001
		System.out.println(studentPark.serialNum); //1001
		
		System.out.println(studentChoi.studentName);//최홍빈
		System.out.println(studentPark.studentName);//박수진
		
		//ex2
		Student1 studentChoi1 = new Student1();
		studentChoi.setStudnetName("최홍빈");
		System.out.println(studentChoi1.studentID); //1001
		
		Student1 studentPark1 = new Student1();
		studentPark1.setStudnetName("박수진");
		System.out.println(studentPark1.studentID); //1002
		
		//ex3 클래스 변수 // 클래스명.static변수명
		//첫글자 대문자 : class 명 // 첫글자 소문자 : 변수명
		System.out.println(Student.serialNum);
		System.out.println(Student1.serialNum);
	
		//ex4
		// Student2.serialNum; 오류 : static변수도 private 외부클래스 접근이 불가능하다.
		System.out.println(Student2.getSerialNum());
	}
	
	/*
	클래스 2개 : Student , Example3
	인스턴스 2개 : new Student(); , new Student();
	생성된 멤버 변수 : 8개
		(studentID , studentName , grade , address)
		(studentID , studentName , grade , address)
	정적변수 : 1개 (class가 다르면 서로 다른 static 변수로 취급한다.)
	 */
	
} // c end
