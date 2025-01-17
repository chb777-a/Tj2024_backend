package moviereservation.view.admin;

import java.util.ArrayList;
import java.util.Scanner;

import moviereservation.controller.admin.AdminMovieInfoController;
import moviereservation.model.dao.admin.AdminMovieInfoDao;
import moviereservation.model.dto.admin.AdminMovieInfoDto;

public class AdminMovieInfoView {
	Scanner scan = new Scanner(System.in);
	private static AdminMovieInfoView instance = new AdminMovieInfoView();
	private AdminMovieInfoView() {}
	public static AdminMovieInfoView getInstance() {return instance;}
		public void MovieInfoView() {
		while(true) {
			System.out.println("-------------------------MENU-------------------------");
			System.out.println(" 1. 영화정보 등록 \n 2. 영화정보 출력 \n 3. 영화정보 수정 \n 4. 영화정보 삭제 \n 5. 뒤로가기");
			int movieInfo = scan.nextInt();
			if (movieInfo == 1) {
				System.out.println("영화정보 등록");
				movieInfoRes();
			}else if(movieInfo == 2) {
				System.out.println("영화정보 출력");
				movieInfoShow();
			}else if(movieInfo == 3) {
				System.out.println("영화정보 수정");
				movieInfoUpdate();
			}
			else if(movieInfo == 4) {
				System.out.println("영화정보 삭제");
				movieInfoDelete();
			}else if(movieInfo == 5) {
				break;
			}
		} 
	}
		public void movieInfoRes() {
			System.out.println("영화이름 : ");
			String movieName = scan.next(); 
			System.out.println("런닝타임 : ");
			int runTime = scan.nextInt(); 
			System.out.println("관람 등급 :");
			String movieGrade = scan.next();
			System.out.println("영화장르 번호 : ");
			int genreId = scan.nextInt();
			AdminMovieInfoDto adminMovieInfoDto = new AdminMovieInfoDto(movieName, runTime, movieGrade, genreId);
			boolean result = AdminMovieInfoDao.getInstance().movieInfoRes(adminMovieInfoDto);
			if(result) {
				System.out.println("[ 등록 성공 ]");
			}else {
				System.out.println("[ 등록 실패 ]");
			}
		}
		public void movieInfoShow() {
			ArrayList<AdminMovieInfoDto> show = AdminMovieInfoController.getInstance().movieInfoShow();
			System.out.println("번호\t영화명\t런닝타임\t관람 등급\t장르"); // 줄맞추기 해야됨
			for(int i = 0; i<=show.size()-1; i++) {
				AdminMovieInfoDto adminMovieInfoDto = show.get(i);
				System.out.printf(adminMovieInfoDto.getMovieId()+ "\t");
				System.out.printf(adminMovieInfoDto.getMovieName()+ "\t");
				System.out.printf(adminMovieInfoDto.getRunTime()+ "\t");
				System.out.printf(adminMovieInfoDto.getMovieGrade()+ "\t");
				System.out.printf(adminMovieInfoDto.getGenreName()+ "\n");
				
			}
		}
		
		public void movieInfoUpdate() {
			System.out.println("수정할 번호 :");
			int movieId = scan.nextInt();
			System.out.println("수정할 영화정보 이름 : ");
			String movieName = scan.next();
			System.out.println("수정할 영화정보 런닝타임 : ");
			int runTime = scan.nextInt();
			System.out.println("수정할 관람 등급 : ");
			String movieGrade = scan.next();
			System.out.println("수정할 영화장르 번호 : ");
			int genreId = scan.nextInt();
			
			AdminMovieInfoDto adminMovieInfoDto = new AdminMovieInfoDto(movieId, movieName, runTime, movieGrade, genreId, movieGrade);
			boolean result = AdminMovieInfoController.getInstance().updateByNum(adminMovieInfoDto);
		}
		public void movieInfoDelete() {
			System.out.println("삭제할 번호 :");
	        int movieId = scan.nextInt();
	        boolean result = AdminMovieInfoController.getInstance().deleteByNum(movieId);
	        if (result) {
	            System.out.println("[ 삭제 성공 ]");
	        } else {
	            System.out.println("[ 삭제 실패 ]");
	        }
		}
}
