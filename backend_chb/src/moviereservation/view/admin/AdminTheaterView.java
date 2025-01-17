package moviereservation.view.admin;

import java.util.ArrayList;
import java.util.Scanner;

import moviereservation.controller.admin.AdminTheaterController;
import moviereservation.model.dao.admin.AdminTheaterDao;
import moviereservation.model.dto.admin.AdminDto;
import moviereservation.model.dto.admin.AdminTheaterDto;

public class AdminTheaterView {
	private static AdminTheaterView instance = new AdminTheaterView();
	private AdminTheaterView() {}
	public static AdminTheaterView getInstance() {
		return instance;
	}
	Scanner scan = new Scanner(System.in);
	public void TheaterView() {
		while(true) {
			System.out.println("-------------------------MENU-------------------------");
			System.out.println("1. 상영관 정보 등록 ");
			System.out.println("2. 상영관 정보 출력 ");
			System.out.println("3. 상영관 정보 수정 ");
			System.out.println("4. 상영관 정보 삭제 ");
			System.out.println("5. 뒤로가기 ");
			int theaterInfo = scan.nextInt();
			if(theaterInfo==1) {
				addTheater();
				
			}else if(theaterInfo==2) {
				showAllTheaters();
				
			}else if(theaterInfo==3) {
				findupdateTheater();
				
			}else if(theaterInfo==4) {
				finddeleteTheater();
				
			}else if(theaterInfo==5) {
				break;
			}
			else {
				System.out.println("숫자로 다시 입력하세요.");
			}
		}
		
	}
	public void addTheater() {
		System.out.println("상영관 번호 : "); int Tid = scan.nextInt();
		System.out.println("전체 좌석 수 : "); int Tseat = scan.nextInt();
		System.out.println("스크린 : "); String Tscreen =scan.next();
		AdminTheaterDto adminTheaterDto = new AdminTheaterDto(Tid,Tseat,Tscreen);
		boolean result = AdminTheaterController.getInstance().addTheater(adminTheaterDto);
		if(result) {System.out.println("[ 상영관 정보등록 성공 ]");}
		else {System.out.println("[ 상영관 정보등록 실패 ]");}
	}

	public void showAllTheaters() {
		System.out.println("------------------------CHOOSE------------------------");
		System.out.println("1. 상영관 전체 정보 출력");
		System.out.println("2. 상영관 정보와 배치가 포함된 상세 정보 출력");
		int theaterSeat = scan.nextInt();
		if(theaterSeat==1) {
			printBasicTheater();
			
		}else if(theaterSeat==2) {
			 findPrintDetailtheater();
		}else {
			System.out.println("1 2 중 선택하세요.");
		}

	}
	
	public void printBasicTheater() {
		ArrayList<AdminTheaterDto>result = AdminTheaterController.getInstance().printBasicTheater();
		System.out.println("상영관번호\t전체좌석수\t스크린");
		for(int index=0;index<=result.size()-1;index++) {
			AdminTheaterDto adminTheaterDto = result.get(index);
			System.out.print(adminTheaterDto.getTid()+"관\t");
			System.out.print(adminTheaterDto.getTseat()+"석\t");
			System.out.print(adminTheaterDto.getTscreen()+"\n");
		}
		
	}
	
	public void printDetailTheater(AdminTheaterDto adminTheaterDto) {

		AdminTheaterDto result =AdminTheaterController.getInstance().printDetailTheater(adminTheaterDto);
	
		if(result !=null) {
			System.out.print("상영관번호\t전체좌석수\t스크린\n");
			System.out.print(result.getTid()+"관\t");
			System.out.print(result.getTseat()+"석\t");
			System.out.print(result.getTscreen()+"\n");
			System.out.print("--------------SCREEN--------------"+"\n");
			System.out.printf("  %4d %4d %4d %4d %4d %4d %4d %4d %4d %4d\n",1,2,3,4,5,6,7,8,9,10);
			 int rows = result.getTseat() / 10 ;  // 전체 좌석을 10으로 나누어서 행 수 구하기
			    int remainSeat = result.getTseat() % 10;  // 나머지 좌석 처리

			    // 행 출력
			    for (int row = 0; row <= rows-1; row++) {  // 각 행에 대해
			        System.out.printf("%2d",row);  // 행 번호 출력
			        for (int col = 1; col <= 10; col++) {  // 각 행에 대해 10개의 "□" 출력
			            System.out.printf("%2s ","□");
			        }
			        System.out.println();
			    }
			    if (remainSeat > 0) {
			    	 System.out.printf("%2d",rows);  // 마지막 행 번호 출력
			        for (int i = 1; i <= remainSeat; i++) {
			        	 System.out.printf("%2s ","□");
			        }
			        System.out.println();  
			    }
		}
	}
	
	public void findPrintDetailtheater() {
		System.out.println("출력할 상영관 번호 : "); int Tid = scan.nextInt();
		AdminTheaterDto result = AdminTheaterController.getInstance().findPrintDetailTheater(Tid);
		if(result!=null)
		{
			printDetailTheater(result);
		}else {
			System.out.println("동일한 상영관 정보가 없습니다.");
		}
	}

	
	public void updateTheater(AdminTheaterDto adminTheaterDto) {
			System.out.println("수정할 전체 좌석 수 : "); int Tseat = scan.nextInt();
			System.out.println("수정할 스크린(상영관 종류) : " ); String Tscreen = scan.next();
			adminTheaterDto.setTseat(Tseat); adminTheaterDto.setTscreen(Tscreen);
			boolean result1 = AdminTheaterController.getInstance().updateTheater(adminTheaterDto);
			if(result1) {
				System.out.println("[ 상영관 정보 수정완료 ]");
			}
			else {System.out.println("[ 상영관 정보 수정실패 ]");}
		}
	
	
	public void findupdateTheater() {
		System.out.println("수정할 상영관 번호 : "); int Tid = scan.nextInt();
		AdminTheaterDto result = AdminTheaterController.getInstance().finddeleteTheater(Tid);
		if(result!=null)
		{
			updateTheater(result);
		}else {
			System.out.println("동일한 상영관 정보가 없습니다.");
		}
	}
	public void deleteTheater(AdminTheaterDto adminTheaterDto) {
		AdminTheaterController.getInstance().deleteTheater(adminTheaterDto);
		System.out.println("[ 상영관 정보 삭제성공 ]");
	}
	
	public void finddeleteTheater() {
		System.out.println("삭제할 상영관 번호 : "); int Tid = scan.nextInt();
		AdminTheaterDto result = AdminTheaterController.getInstance().finddeleteTheater(Tid);
		if(result!=null)
		{
			deleteTheater(result);
		}else {
			System.out.println("동일한 상영관 정보가 없습니다.");
		}
	}


}
