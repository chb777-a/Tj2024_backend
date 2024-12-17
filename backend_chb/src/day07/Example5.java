package day07;

public class Example5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[] {55, 55, 30, 47, 57};
		int sum = 0;
		for( int index = 0; index <= num.length-1 ; index ++) {
			sum += num[index]; System.out.println(sum);
		}
		int sum2 = sum/num.length;
		System.out.println(sum2);
	}

}
