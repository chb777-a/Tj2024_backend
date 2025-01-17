package moviereservation.view.member;

import java.util.Scanner;

public class MemberResvView {
	private static MemberResvView instance = new MemberResvView();
	private MemberResvView() {}
	public static MemberResvView getInstance() {return instance;}
	
	public void run() {
		Scanner scan = new Scanner(System.in);
		System.out.println("====메뉴 선택====");
		while(true) {
			System.out.println("-------------------------MENU-------------------------");
			System.out.println("1.예매\n2.리뷰\n3.회원정보 수정\n4.회원탈퇴\n5.로그아웃");
			int choose = scan.nextInt();
			if (choose == 1) {MemberRsvDetailView.getInstance().MemberRsvDetail();}
			else if(choose == 2) {MemberReviewView.getInstance().run();}
			else if(choose == 3) {MemberView.getInstance().update();}
			else if(choose == 4) {MemberView.getInstance().delete();}
			else if(choose == 5) {MemberView.getInstance().logout(); break;}
		}
	}
}
