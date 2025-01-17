package moviereservation.view.member;


import java.util.ArrayList;
import java.util.Scanner;

import moviereservation.controller.member.MemberRsvDetailController;

import moviereservation.model.dto.member.MemberRsvDetailDto;

public class MemberRsvDetailView {
	Scanner scan = new Scanner(System.in);
	private static MemberRsvDetailView instance = new MemberRsvDetailView();
	private MemberRsvDetailView() {}
	public static MemberRsvDetailView getInstance() {return instance;}
		public void MemberRsvDetail() {
			System.out.println("1.예매하기 2.예매 확인 3.예매 취소");
			int rsvInfo = scan.nextInt();
			if( rsvInfo == 1) {
				System.out.println("예매하기");
				movieRsvRes();
			}else if (rsvInfo == 2) {
				System.out.println("예매 확인");
				printRsv();
			}else if (rsvInfo == 3) {
				System.out.println("예매 취소");
				rsvCan();
			}
		} // f end
	
		public void movieRsvRes() {
	         
	            
            printMovieName();
            System.out.println("영화 선택 : ");
            int rsvMovieName = scan.nextInt();
            printTheaterTime(rsvMovieName);
            System.out.println("영화 상영 시간 선택 : ");
            int rsvTime = scan.nextInt();
            // printTheater(rsvMovieName);
            // System.out.println("영화 상영관 선택 : ");
            // int rsvTheater = scan.nextInt();
            System.out.println("영화 관람 인원 수 선택 : ");
            int rsvPerson = scan.nextInt();
            printTheater(rsvTime);
            System.out.println("영화 좌석 선택 : ");
            System.out.println("좌석을 하나씩 입력해 주세요.");
            
            int[] rsvSeatNums = new int[rsvPerson];
            
            
            for(int index=0;index<=rsvPerson-1;index++) {
            	System.out.println("예매 좌석 : ");
            	rsvSeatNums[ index ] = scan.nextInt();
   	          }
            
            // 영화번호 , 상영시간 , (배열)좌석(인원수)만큼
            
            MemberRsvDetailDto memberRsvDetailDto = new MemberRsvDetailDto();
            memberRsvDetailDto.setMovieId(rsvMovieName);
            memberRsvDetailDto.setTimepk(rsvTime);
            //memberRsvDetailDto.setRsvPerson(rsvPerson);
            
            boolean result = 
            MemberRsvDetailController.getInstance().movieRsvRes(memberRsvDetailDto, rsvSeatNums);
            
            if( result ) {
            	System.out.println("[ 예매 성공 ]");
            }else {
            	System.out.println("[ 예매 실패 ]");
            }
            
		}
		
		//영화 선택
		public void printMovieName() {
			ArrayList<MemberRsvDetailDto> result1 = MemberRsvDetailController.getInstance().printMovieName();
			for(int index = 0; index <= result1.size()-1; index++) {
				MemberRsvDetailDto memberRsvDetailDto = result1.get(index);
				System.out.println(memberRsvDetailDto.getMovieId() + "." + memberRsvDetailDto.getRsvMovieName());
				
			}
		} // printMovieName end
		
		//영화 상영 시간 선택
	      public void printTheaterTime(int movieId) {
	         ArrayList<MemberRsvDetailDto> result = MemberRsvDetailController.getInstance().printTheaterTime(movieId);
	         System.out.println("상영번호 / 상영날짜 / 시작시간 / 종료시간/ 관");
	         for(int i = 0; i <= result.size()-1; i++) {
	            MemberRsvDetailDto memberRsvDetailDto = result.get(i);
	            System.out.println(memberRsvDetailDto.getTimepk() +"."+ memberRsvDetailDto.getMovieDate() +" / "+ memberRsvDetailDto.getStartTime() +" / "+ memberRsvDetailDto.getFinishTime()+" / "+ memberRsvDetailDto.getTheaterId());
	         }
	      }
	      
	      //영화 좌석 출력
	      //영화 시간 선택하면 관을 갖고와서 넣어줘야함
	      public void printTheater(int rsvTime) {
	          // 선택된 영화 시간에 해당하는 상영관 정보 가져오기
	          MemberRsvDetailDto memberRsvDetailDto = MemberRsvDetailController.getInstance().printTheater(rsvTime);

	          if (memberRsvDetailDto != null) {
	              // 상영관 좌석 정보 출력
	              System.out.print("전체좌석수\t스크린\n");
	              System.out.println(memberRsvDetailDto.getRsvSeat() + "석\t");
	              System.out.print(memberRsvDetailDto.getRsvScreen() + "\n");
	              System.out.print("--------------SCREEN--------------\n");
	              System.out.printf("  %2d %2d %2d %2d %2d %2d %2d %2d %2d %3d\n", 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

	              // 예약된 좌석 정보 가져오기
	              ArrayList<Integer> reservedSeats = getRsvSeat(memberRsvDetailDto, rsvTime);
	              int totalSeats = memberRsvDetailDto.getRsvSeat();
	              int rows = totalSeats / 10;  // 각 행에 10개의 좌석
	              int remainSeat = totalSeats % 10;  // 마지막 행의 남은 좌석 수

	              // 좌석 출력
	              int seatNumber = 1;  // 좌석 번호 초기화
	              for (int row = 0; row < rows; row++) {
	                  System.out.printf("%2d", row + 1);  // 행 번호 출력
	                  for (int col = 1; col <= 10; col++) {
	                      if (reservedSeats.contains(seatNumber)) {
	                          System.out.printf("%2s ", "■");  // 예약된 좌석
	                      } else {
	                          System.out.printf("%2s ", "□");  // 예약되지 않은 좌석
	                      }
	                      seatNumber++;
	                  }
	                  System.out.println();
	              }

	              // 남은 좌석 출력
	              if (remainSeat > 0) {
	                  System.out.printf("%2d", rows + 1);  // 마지막 행 번호 출력
	                  for (int i = 1; i <= remainSeat; i++) {
	                      if (reservedSeats.contains(seatNumber)) {
	                          System.out.printf("%2s ", "□");  // 예약된 좌석
	                      } else {
	                          System.out.printf("%2s ", "□");  // 예약되지 않은 좌석
	                      }
	                      seatNumber++;
	                  }
	                  System.out.println();
	              }
	          } else {
	              System.out.println("선택한 상영 시간에 대한 상영관 정보가 없습니다.");
	          }
	      }
	      
	      public ArrayList<Integer> getRsvSeat(MemberRsvDetailDto memberRsvDetailDto, int rsvTime) {
	          ArrayList<Integer> seatNumbers = new ArrayList<>();
	          // MemberRsvDetailController에서 좌석 정보를 가져옴
	          ArrayList<MemberRsvDetailDto> result = MemberRsvDetailController.getInstance().getRsvSeat(memberRsvDetailDto, rsvTime);

	          // 결과 리스트가 비어있지 않은지 확인
	          if (result.isEmpty()) {
	              System.out.println("예약된 좌석 정보가 없습니다.");
	          } else {
	              for (MemberRsvDetailDto detail : result) {
	                  seatNumbers.add(detail.getRsvSeat()); // 좌석 번호 추가
	              }
	          }
	          
	          return seatNumbers;
	      }
		
		//영화 좌석 선택
		   
		   
		// 영화 예매 내역 전체 출력
		   public void printRsv() {
			   ArrayList<MemberRsvDetailDto> result = MemberRsvDetailController.getInstance().printRsv();
			   System.out.println("예약번호\t영화이름\t영화날짜\t시작시간\t종료시간\t상영관\t좌석\t예약날짜");
			   for (MemberRsvDetailDto memberRsvDetailDto : result) {
					
					System.out.print(memberRsvDetailDto.getRsvNum()+"\t");
					System.out.print(memberRsvDetailDto.getRsvMovieName()+"\t");
					System.out.print(memberRsvDetailDto.getMovieDate()+"\t");
					System.out.print(memberRsvDetailDto.getStartTime()+"\t");
					System.out.print(memberRsvDetailDto.getFinishTime()+"\t");
					System.out.print(memberRsvDetailDto.getRsvTheater()+"\t");
					System.out.print(memberRsvDetailDto.getRsvSeat()+"\t");
					System.out.print(memberRsvDetailDto.getRsvTime()+"\n");
				}
		   }
		   
		// 영화 예매 취소
		   public void rsvCan() {
			   System.out.println("취소할 예매 번호 : ");
			   int rsvNum = scan.nextInt();
			   MemberRsvDetailDto memberRsvDetailDto = new MemberRsvDetailDto();
			   memberRsvDetailDto.setRsvNum(rsvNum);
			   boolean result = MemberRsvDetailController.getInstance().rsvCan(memberRsvDetailDto);
			   if(result) {System.out.println("[ 취소 성공 ]");}
			   else {System.out.println("[ 취소 실패 ]");}
			
		}
		
		 
} // c end