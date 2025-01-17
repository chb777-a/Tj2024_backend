package moviereservation;

import java.util.Scanner;

import moviereservation.view.admin.AdminView;
import moviereservation.view.member.MemberView;

public class AppStart {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("1.관리자 2.사용자");
			int choose = scan.nextInt();
			if (choose == 1) {
				AdminView.getInstance().run();
			} else if (choose == 2) {
				MemberView.getInstance().run();
			}
		}
	}

}
