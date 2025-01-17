package moviereservation.view.admin;

import java.util.Scanner;

import moviereservation.controller.admin.AdminController;
import moviereservation.model.dto.admin.AdminDto;


public class AdminView {
	private static AdminView instance = new AdminView();
	private AdminView() {}
	public static AdminView getInstance() {return instance;}
	
	private Scanner scan = new Scanner(System.in);
	public void run() {
		while(true) {
			System.out.println("1. 회원가입 2. 로그인 3.뒤로가기");
			int logChoose =scan.nextInt();
			if(logChoose ==1) {adminSignup();}
			else if(logChoose ==2) {adminLogin();}
			else if(logChoose ==3) {break;}
		}
		
	}
	private void adminSignup() {
		System.out.println("관리자 아이디 : "); String aid = scan.next();
		System.out.println("관리자 비밀번호 : "); String apw = scan.next();
		System.out.println("관리자 이름 : "); String aname = scan.next();
		AdminDto adminDto = new AdminDto(aid,apw,aname);
		boolean result = AdminController.getInstance().adminSignup(adminDto);
		if(result) {System.out.println("[ 관리자 회원가입성공 ]");}
		else {System.out.println("[ 관리자 회원가입실패 ]");}
			
	}
	private void adminLogin() {
		System.out.println("관리자 아이디 : "); String aid = scan.next();
		System.out.println("관리자 비밀번호 : "); String apw = scan.next();
		AdminDto adminDto = new AdminDto();
		adminDto.setAid(aid);
		adminDto.setApw(apw); 
		boolean result = AdminController.getInstance().adminLogin(adminDto);
		if(result) {
			System.out.println("[ 관리자 로그인 성공 ]");
			AdminView.getInstance().adminMainMenu();
		}
		else {System.out.println("[ 관리자 로그인 실패 ]");}
		
	}
	
	public void adminMainMenu() {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("-------------------------MENU-------------------------");
			System.out.println("1. 영화정보 관리\r\n"
					+ "2. 사용자 계정출력\r\n"
					+ "3. 상영시간표 관리\r\n"
					+ "4. 영화 상영관 관리\r\n"
					+ "5. 회원정보 수정\r\n"
					+ "6. 회원정보 삭제\r\n"
					+ "7. 로그아웃");
			int adminChoose = scan.nextInt();
			if (adminChoose == 1) {
				AdminMovieInfoView.getInstance().MovieInfoView();
			}else if(adminChoose == 2) {
				AdminPrintUserView.getInstance().printUser();
			}else if(adminChoose == 3) {
				AdminMovieTimeView.getInstance().MovieTimeView();
			}else if(adminChoose == 4) {
				AdminTheaterView.getInstance().TheaterView();
			}else if(adminChoose == 5) {
				AdminInfo.getInstance().adminUpdate();
			}else if(adminChoose == 6) {
				AdminInfo.getInstance().adminDelete();
				break;
			}else if(adminChoose == 7) {
				AdminInfo.getInstance().adminLogout();
				break;
			}
			
		}
	}
	
	
}
