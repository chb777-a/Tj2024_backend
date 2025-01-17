package moviereservation.view.member;

import java.util.ArrayList;
import java.util.Scanner;

import moviereservation.controller.member.MemberReviewController;
import moviereservation.model.dto.member.MemberReviewDto;

public class MemberReviewView {
	private static MemberReviewView instance = new MemberReviewView();
	private MemberReviewView() {}
	public static MemberReviewView getInstance() {return instance;}
	
	private Scanner scan = new Scanner(System.in);
	public void run() {
		while(true) {
			System.out.println("-------------------------MENU-------------------------");
			System.out.println("1.리뷰등록\n2.전체리뷰조회\n3.리뷰수정\n4.리뷰삭제\n5.뒤로가기");
			int choose = scan.nextInt();
			if(choose ==1 ) {regist();}
			else if(choose == 2) {print();}
			else if(choose ==3) {update();}
			else if(choose ==4) {delete();}
			else if(choose == 5) {break;}
		}
	}
	// 1. 리뷰 등록 화면
	public void regist() {
		System.out.println("영화명 : "); String movieName = scan.next();
		System.out.println("리뷰 제목 : "); String reviewTitle = scan.next();
		System.out.println("리뷰 내용 : "); String reviewContent = scan.next();
		System.out.println("리뷰 점수 : "); int reviewRating = scan.nextInt();
		System.out.println("리뷰 작성 날짜 : "); String reviewDate = scan.next();
		MemberReviewDto memberReviewDto = new MemberReviewDto();
		memberReviewDto.setMovieName(movieName);
		memberReviewDto.setReviewTitle(reviewTitle);
		memberReviewDto.setReviewContent(reviewContent);
		memberReviewDto.setReviewRating(reviewRating);
		memberReviewDto.setReviewDate(reviewDate);
		boolean result = MemberReviewController.getInstance().regist(memberReviewDto);
		if(result) {System.out.println("[ 리뷰 등록 성공 ]");}
		else {System.out.println("[ 리뷰 등록 실패 ]");}
	}
	// 2. 리뷰 전체 조회 화면
	public void print() {
		
		ArrayList<MemberReviewDto> result = MemberReviewController.getInstance().print();
		System.out.println("번호\t작성날짜\t\t영화\t점수\t제목\t내용\t작성자");
		for(int i = 0; i < result.size(); i++) {
			MemberReviewDto memberReviewDto = result.get(i);
			System.out.print(memberReviewDto.getReviewId()+"\t");
			System.out.print(memberReviewDto.getMovieName()+"\t");
			System.out.print(memberReviewDto.getReviewTitle()+"\t");
			System.out.print(memberReviewDto.getReviewRating()+"\t");
			System.out.print(memberReviewDto.getReviewContent()+"\t");
			System.out.print(memberReviewDto.getReviewDate()+"\t");
			System.out.print(memberReviewDto.getMid()+"\n");
		}
	}
	// 3. 리뷰 수정 화면
	public void update() {
		System.out.println("수정할 리뷰 번호 : "); int reviewId = scan.nextInt();
		System.out.println("새로운 제목 : "); String reviewTitle = scan.next();
		System.out.println("새로운 내용 : "); String reviewContent = scan.next();
		System.out.println("새로운 평점 : "); int reviewRating = scan.nextInt();
		MemberReviewDto memberReviewDto = new MemberReviewDto();
		memberReviewDto.setReviewId(reviewId);
		memberReviewDto.setReviewTitle(reviewTitle);
		memberReviewDto.setReviewContent(reviewContent);
		memberReviewDto.setReviewRating(reviewRating);
		boolean result = MemberReviewController.getInstance().update(memberReviewDto);
		if(result) {System.out.println("[ 리뷰 수정 성공 ]");}
		else {System.out.println("[ 리뷰 수정 실패 ]");}
	}
	// 4. 리뷰 삭제 화면
	public void delete() {
		System.out.println("삭제할 리뷰 번호 : "); int reviewId = scan.nextInt();
		MemberReviewDto memberReviewDto = new MemberReviewDto();
		memberReviewDto.setReviewId(reviewId);
		boolean result = MemberReviewController.getInstance().delete(memberReviewDto);
		if(result) {System.out.println("[ 리뷰 삭제 성공 ]");}
		else {System.out.println("[ 리뷰 삭제 실패 ]");}
	}
}
