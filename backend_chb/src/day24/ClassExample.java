package day24;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassExample {
	public static void main(String[] args) {
		//[1] .getClass() 메소드
		String s = new String();
		Class c = s.getClass();
		System.out.println(c);			//class java.lang.String
		
		Integer i = 3;
		Class c1 = i.getClass();
		System.out.println(c1);			//class java.lang.Integer
		
		
		//[2] .class
		Class c2 = String.class;
		System.out.println(c2);			//class java.lang.String
		
		//[3] Class.forName("클래스이름");
		try{Class.forName("java.lang.String");}
		catch(ClassNotFoundException e) {}
		//[-]
		try{Class.forName("com.mysql.cj.jdbc.Driver");}
		catch(ClassNotFoundException e) {}
		
		// 클래스 정보(클래스멤버=멤버변수/생성자/메소드)를 변환 함수.
		Field[] fields = c.getFields();
		for( int index = 0; index<=fields.length-1; index++) {
			System.out.println(fields[index]);
		} //public static final java.util.Comparator java.lang.String.CASE_INSENSITIVE_ORDER
		
		Constructor[] constructors = c.getConstructors();
		for( int index = 0; index<=constructors.length-1; index++) {
			System.out.println(constructors[index]);
		} /* 15 개의 생성자
			public java.lang.String(java.lang.StringBuilder)
			public java.lang.String(byte[],int,int,java.nio.charset.Charset)
			public java.lang.String(byte[],java.lang.String) throws java.io.UnsupportedEncodingException
			public java.lang.String(byte[],java.nio.charset.Charset)
			public java.lang.String(byte[],int,int)
			public java.lang.String(byte[])
			public java.lang.String(java.lang.StringBuffer)
			public java.lang.String(char[],int,int)
			public java.lang.String(char[])
			public java.lang.String(java.lang.String)
			public java.lang.String()
			public java.lang.String(byte[],int,int,java.lang.String) throws java.io.UnsupportedEncodingException
			public java.lang.String(byte[],int)
			public java.lang.String(byte[],int,int,int)
			public java.lang.String(int[],int,int)
		 */
		
		Method[] methods = c.getMethods();
		for(int index = 0; index <= methods.length-1; index++) {
			System.out.println(methods[index]);
		}
		
	} // main end
} // c end
