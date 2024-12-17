package day07;

import java.util.Arrays;

public class Example4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[0] 배열 사용하기 전, 학번 10개 저장하는 코드
		int studentId1; int studentId2; int studentId3; int studentId4; int studentId5;
		int studentId6; int studentId7; int studentId8; int studentId9; int studentId10;
		
		//[1] 배열 사용 , 학번 10개 저장하는 코드
		int[] studentIds = new int[10];
		
		//[2] 배열 초기화하기
			//1. 개수가 생략함.
			int[] studentIds2 = new int[] { 101,102,103 };
			//2. 오류발생
			//int[] studentIds3 = new int[3] { 101,102,103 };
			//3.
			int[] studentIds4 = {101,102,103};
			//4.
			int[] studentIds5 = new int[] {101,102,103};
	
		//[3] 배열 사용하기 , 인덱스 사용하기
			int[] num = new int[] {1,2,3,4,5,6,7,8,9,10};
			System.out.println(num); //[I@28a418fc
			System.out.println(num[0]); // 1
			System.out.println(num[3]); // 4
			System.out.println(Arrays.toString(num)); // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
			
		//1분 복습 :
			int sum = 0;
			for( int index = 0; index <= num.length-1 ; index ++) {
				sum += num[index]; System.out.println(sum);
			}
			
		//[4] 전체 배열 길이와 유효한 요소 값
			double[] data = new double[5]; // - 실수 5개를 저장할 수 있는 배열 선언
			data[0] = 10.0; // 첫번재 인덱스에 10.0을 대입
			data[1] = 20.0; // 두번째 인덱스에 20.0을 대입
			data[2] = 30.0; // 세번째 인덱스에 30.0을 대입
			// 네번째 인덱스 , 다섯번째 인덱스는 대입하지 않았다. [3] 와 [5]는 기본값인 0.0이 들어있다 (기본값)
			for(int i = 0; i < data.length-1; i++) {
				System.out.println(data[i]);
			}
	}
	

}
