package moviereservation.controller.member;

import java.util.ArrayList;

import moviereservation.model.dao.member.MemberReviewDao;
import moviereservation.model.dto.member.MemberReviewDto;

public class MemberReviewController {
	private static MemberReviewController instance = new MemberReviewController();
	private MemberReviewController() {}
	public static MemberReviewController getInstance() {return instance;}
	// 1. 리뷰 등록 컨트롤러 메소드
	public boolean regist(MemberReviewDto memberReviewDto) {
		
		//1. 로그인 회원 번호를 DTO 대입  
		memberReviewDto.setMemberId( MemberController.getInstance().getLoginMno() );
		//2. 입력받은 영화명을 영화번호 조회하는 Dao 호출
		int mno = MemberReviewDao.getInstance().checkMovie(memberReviewDto);
		memberReviewDto.setMovieId(mno);
		
		boolean result = MemberReviewDao.getInstance().regist(memberReviewDto);
		return result;
	}
	// 2. 리뷰 전체 조회 컨트롤러 메소드
	public ArrayList<MemberReviewDto> print(){
		ArrayList<MemberReviewDto> result = MemberReviewDao.getInstance().print();
		return result;
	}
	// 3. 리뷰 수정 컨트롤러 메소드
	public boolean update(MemberReviewDto memberReviewDto) {
		// 내가 쓴 리뷰인지 유효성 검사
			// 현재 로그인된 회원번호
		int loginMno = MemberController.getInstance().getLoginMno();
			// 수정할 리뷰 번호
		int reviewId = memberReviewDto.getReviewId();
		boolean result = MemberReviewDao.getInstance().reviewCheck(reviewId, loginMno);
		if(result == false) {return false;} // 내가 쓴게 아니면 false 반환
		boolean result2 = MemberReviewDao.getInstance().update(memberReviewDto);
		return result2;
	}
	// 4. 리뷰 삭제 컨트롤러 메소드
	public boolean delete(MemberReviewDto memberReviewDto) {
		int loginMno = MemberController.getInstance().getLoginMno();
		int reviewId = memberReviewDto.getReviewId();
		boolean result = MemberReviewDao.getInstance().reviewCheck(reviewId, loginMno);
		if(result == false) {return false;}
		boolean result2 = MemberReviewDao.getInstance().delete(memberReviewDto);
		return result2;
	}
}
