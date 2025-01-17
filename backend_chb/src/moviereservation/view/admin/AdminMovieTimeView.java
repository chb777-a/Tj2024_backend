package moviereservation.view.admin;

import java.util.ArrayList;
import java.util.Scanner;

import moviereservation.controller.admin.AdminMovieTimeController;
import moviereservation.model.dao.admin.AdminMovieTimeDao;
import moviereservation.model.dto.admin.AdminMovieTimeDto;

public class AdminMovieTimeView {
	Scanner scan = new Scanner(System.in);
	private static AdminMovieTimeView instance = new AdminMovieTimeView();
	private AdminMovieTimeView() {}
	public static AdminMovieTimeView getInstance() {return instance;}
		public void MovieTimeView() {
		System.out.println("상영시간표 관리");
		while(true) {
			System.out.println("-------------------------MENU-------------------------");
			System.out.println(" 1. 상영시간표 등록 \n 2. 상영시간표 출력 \n 3. 상영시간표 수정 \n 4. 상영시간표 삭제 \n 5. 뒤로가기");
			int movieTime = scan.nextInt();
			if(movieTime == 1) {
				System.out.println("상영시간표 등록");
				movieTimeRes();
			}else if(movieTime == 2) {
				System.out.println("상영시간표 출력");
				movieTimeShow();
			}else if(movieTime == 3) {
				System.out.println("상영시간표 수정");
				movieTimeUpdate();
			}else if(movieTime == 4) {
				System.out.println("상영시간표 삭제");
				movieTimeDelete();
			}else if(movieTime == 5) {
				break;
			}
		}
	}
		public void movieTimeRes() {
			System.out.println("시작시간입력");
			String startTime = scan.next(); 
			System.out.println("종료시간입력");
			String finishTime = scan.next(); 
			System.out.println("영화날짜입력");
			String movieDate = scan.next();
			System.out.println("관 입력");
			int theaterId = scan.nextInt();
			System.out.println("영화번호 입력");
			int movieId = scan.nextInt();
			AdminMovieTimeDto adminMovieTimeDto = new AdminMovieTimeDto(startTime, finishTime, movieDate, theaterId, movieId);
			boolean result = AdminMovieTimeDao.getInstance().movieTimeRes(adminMovieTimeDto);
			if(result) {
				System.out.println("[ 등록 성공 ]");
			}else {
				System.out.println("[ 등록 실패 ]");
			}
		}
		public void movieTimeUpdate() {
			System.out.println("수정할 번호 :");
	        int num = scan.nextInt();
	        System.out.println("수정할 시작시간입력");
			String startTime = scan.next(); 
			System.out.println("수정할 종료시간입력");
			String finishTime = scan.next(); 
			System.out.println("수정할 영화날짜입력");
			String movieDate = scan.next();
			System.out.println("수정할 관 입력");
			int theaterId = scan.nextInt();
			System.out.println("수정할 영화번호 입력");
			int movieId = scan.nextInt();
			 
			AdminMovieTimeDto adminMovieTimeDto = new AdminMovieTimeDto(num, startTime, finishTime, movieDate, theaterId, movieId);
			boolean result = AdminMovieTimeController.getInstance().updateByNum(adminMovieTimeDto);
	        if (result) {
	            System.out.println("[ 수정 성공 ]");
	        } else {
	            System.out.println("[ 수정 실패 ]");
	        }
		}
		public void movieTimeShow() {
			ArrayList<AdminMovieTimeDto> show = AdminMovieTimeController.getInstance().movieTimeShow(); 
			System.out.println("번호\t영화명\t상영시작\t상영종료\t상영일\t\t상영관\t런닝타임");
			for(int i = 0; i <=show.size()-1; i++) {
				AdminMovieTimeDto adMovieTimeDto = show.get(i);
				System.out.printf(adMovieTimeDto.getTimepk()+ "\t");
				System.out.printf(adMovieTimeDto.getMovieName()+ "\t");
				System.out.printf(adMovieTimeDto.getStartTime()+ "\t");
				System.out.printf(adMovieTimeDto.getFinishtime()+ "\t");
				System.out.printf(adMovieTimeDto.getMovieDate()+ "\t");
				System.out.printf(adMovieTimeDto.getTheaterId()+ "\t");
				System.out.println(adMovieTimeDto.getRunTime()+ "\n");
			}
		}
		public void movieTimeDelete() {
			System.out.println("삭제할 번호 :");
	        int timepk = scan.nextInt();
	        boolean result = AdminMovieTimeController.getInstance().deleteByNum(timepk);
	        if (result) {
	            System.out.println("[ 삭제 성공 ]");
	        } else {
	            System.out.println("[ 삭제 실패 ]");
	        }
		}
		
}