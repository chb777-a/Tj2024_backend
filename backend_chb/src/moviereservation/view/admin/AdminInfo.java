package moviereservation.view.admin;

import java.util.Scanner;

import moviereservation.controller.admin.AdminController;
import moviereservation.controller.admin.AdminInfoController;
import moviereservation.model.dto.admin.AdminDto;


public class AdminInfo {
	private Scanner scan = new Scanner(System.in);
	private AdminInfo() {}
	private static AdminInfo instance = new AdminInfo();
	public static AdminInfo getInstance() {
		return instance;
	}
	//admin 정보 수정
	public void adminUpdate() {
		System.out.println("비밀번호 재입력해주세요"); String apw = scan.next();
		AdminDto adminDto = new AdminDto();
		adminDto.setApw(apw); 
		boolean result = AdminInfoController.getInstance().checkPw(adminDto);
		if(result) {
			System.out.println("새로운 비밀번호 : "); String newApw = scan.next();
			System.out.println("새로운 이름 : "); String newAname = scan.next();
			adminDto.setApw(newApw); adminDto.setAname(newAname);
			boolean result1 = AdminInfoController.getInstance().adminUpdate(adminDto);
			if(result1) {
				System.out.println("[ 관리자 정보 수정성공 ]");
			}
		}
		else {System.out.println("비밀번호가 일치하지 않습니다.");}
	}
	
	
	
	//admin 정보 삭제
	public void adminDelete() {
		System.out.println("비밀번호 재입력해주세요"); String apw = scan.next();
		AdminDto adminDto = new AdminDto();
		adminDto.setApw(apw); 
		boolean result = AdminInfoController.getInstance().checkPw(adminDto);
		if(result) {
			System.out.println("정말 회원 탈퇴하실건가요? 0:예 1:취소");
			int choose1= scan.nextInt();
			if(choose1==0) {
				AdminInfoController.getInstance().adminDelete();
				}
			}
		else {System.out.println("비밀번호가 일치하지 않습니다.");}
	}
	//admin 정보 로그아웃
	public void adminLogout() {
		AdminInfoController.getInstance().adminLogout();
		System.out.println("[ 로그아웃 성공 ]");
	}
}
