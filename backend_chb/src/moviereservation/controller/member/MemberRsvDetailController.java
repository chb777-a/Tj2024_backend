package moviereservation.controller.member;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import moviereservation.model.dao.member.MemberReviewDao;
import moviereservation.model.dao.member.MemberRsvDetailDao;
import moviereservation.model.dto.member.MemberRsvDetailDto;

public class MemberRsvDetailController {
	private MemberRsvDetailController() {}
	private static MemberRsvDetailController instance = new MemberRsvDetailController();
	public static MemberRsvDetailController getInstance() {
		return instance;
	}
	
	
	public boolean movieRsvRes(MemberRsvDetailDto memberRsvDetailDto , int[] rsvSeatNums) {
		
		// [1] 예약 등록  , 날짜 , 현재 회원번호
		String nowDate = LocalDate.now().toString();
		int loginMno = MemberController.getInstance().getLoginMno();
		
		int resvId = MemberRsvDetailDao.getInstance().movieRsvRes(memberRsvDetailDto, nowDate , loginMno );
		
		// [2] 예약 상세 
		
		
		// 저장한 시트 상태 확인
		for(int i = 0; i<=rsvSeatNums.length-1; i++) {
			boolean result2 = 
			MemberRsvDetailDao.getInstance().checkSeat(rsvSeatNums[i] , memberRsvDetailDto.getTimepk());
			if(result2 == true) {
				return false;
			}
		}
		
		// 현재 시트 수 만큼 dao 호출
		boolean result1 = false;
		for( int i = 0 ; i<=rsvSeatNums.length-1 ; i++ ) {
			result1 = MemberRsvDetailDao.getInstance().movieRsvRes(resvId, rsvSeatNums[i] );
		}
		return result1;
	}
	
	public ArrayList<MemberRsvDetailDto> printMovieName(){
	      ArrayList<MemberRsvDetailDto> result = MemberRsvDetailDao.getInstance().printMovieName();
	      return result;
	   }
	   
	   public ArrayList<MemberRsvDetailDto> printTheaterTime(int movieId){
	      ArrayList<MemberRsvDetailDto> result = MemberRsvDetailDao.getInstance().printTheaterTime(movieId);
	      return result;
	   }
	    public MemberRsvDetailDto printTheater(int timeId) {
	           return MemberRsvDetailDao.getInstance().printTheater(timeId);
	       }
	    
	   public ArrayList<MemberRsvDetailDto> getRsvSeat(MemberRsvDetailDto memberRsvDetailDto, int rsvTime) {
	      
	      return MemberRsvDetailDao.getInstance().getRsvSeat(memberRsvDetailDto,rsvTime);
	   }
	
	// 영화 예매 내역 전체 출력
	public ArrayList<MemberRsvDetailDto> printRsv(){
		int loginMno = MemberController.getInstance().getLoginMno();
		if (loginMno == 0) {
	        System.out.println("로그인되지 않은 상태입니다.");
	        return new ArrayList<>(); // 빈 리스트 반환
	    }
		ArrayList<MemberRsvDetailDto> result = MemberRsvDetailDao.getInstance().printRsv(loginMno);
		return result;
		
	}
	
	//예매 취소
	public boolean rsvCan(MemberRsvDetailDto memberRsvDetailDto) {
		int loginMno = MemberController.getInstance().getLoginMno();
		int rsvId = memberRsvDetailDto.getRsvNum();
		boolean result = MemberRsvDetailDao.getInstance().rsvCheck(rsvId,loginMno);
		if(result == false) {return false;}
		boolean result2 = MemberRsvDetailDao.getInstance().rsvCan(memberRsvDetailDto);
		return result2;
	}
	
} //c end
