package moviereservation.model.dao.member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import moviereservation.model.dao.Dao;

import moviereservation.model.dto.member.MemberReviewDto;

public class MemberReviewDao extends Dao{
	private static MemberReviewDao instance = new MemberReviewDao();
	private MemberReviewDao() {}
	public static MemberReviewDao getInstance() {return instance;}
	// 영화 확인 SQL 처리 메소드
	public int checkMovie(MemberReviewDto memberReviewDto) {
		int movieId = -1; // 영화가 존재하지 않음
		try {
		String sql = "select movieId from movie where movieName = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, memberReviewDto.getMovieName());
		ResultSet rs = ps.executeQuery();
		if(rs.next()) { // 주어진 영화 이름에 해당하는 영화가 데이터베이스에 존재하면, 그 영화의 movieId를 가져와 변수에 저장
			movieId = rs.getInt("movieId");
		}
		}catch (Exception e) {System.out.println(e);}
		return movieId;
	}
	// 1. 리뷰 등록 SQL 처리 메소드
	public boolean regist(MemberReviewDto memberReviewDto) {
		System.out.println(memberReviewDto);
		try {
		String sql = "insert into movieReview(reviewTitle, reviewContent, reviewRating,reviewDate,memberId,movieId) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, memberReviewDto.getReviewTitle());
		ps.setString(2, memberReviewDto.getReviewContent());
		ps.setInt(3, memberReviewDto.getReviewRating());
		ps.setString(4, memberReviewDto.getReviewDate());
		ps.setInt(5, memberReviewDto.getMemberId());
		ps.setInt(6, memberReviewDto.getMovieId());
		int count = ps.executeUpdate();
		if(count == 1) {return true;} // INSERT 쿼리가 성공적으로 하나의 행을 추가했으면 true 반환
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 2. 리뷰 전체 조회 SQL 처리 메소드
	public ArrayList<MemberReviewDto> print(){
		ArrayList<MemberReviewDto> list = new ArrayList<>();
		try {
		String sql = "select * from movieReview as mr inner join movie as m on mr.movieId = m.movieId"
				+ " inner join member as mm on mr.memberId = mm.memberId";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) { // 각 행에서 데이터를 순차적으로 읽어서 가져온 후 정보 저장하는 객체 생성
			int reviewId = rs.getInt("reviewId");
			String movieName = rs.getString("movieName");
			String reviewTitle = rs.getString("reviewTitle");
			String reviewContent = rs.getString("reviewContent");
			int reviewRating = rs.getInt("reviewRating");
			String reviewDate = rs.getString("reviewDate");
			MemberReviewDto memberReviewDto = new MemberReviewDto(reviewId, movieName, reviewTitle, reviewRating, reviewContent,  reviewDate);
			memberReviewDto.setMid(rs.getString("mid"));
			list.add(memberReviewDto);
		}
		
		}catch (SQLException e) {System.out.println(e);}
		return list;
	}
	// 내가 쓴 리뷰 확인 SQL 처리 메소드
	public boolean reviewCheck(int reviewId, int memberId) {
		// 매개변수 : reviewId, memberId , 특정 리뷰(reviewId)의 작성자(memberId) 일치 여부 확인하기
		try {
		String sql = "select * from movieReview where reviewId = ? and memberId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, reviewId);
		ps.setInt(2, memberId);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {return true;}
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 3. 리뷰 수정 SQL 처리 메소드
	public boolean update(MemberReviewDto memberReviewDto) {
		try {
		String sql = "update movieReview set reviewTitle = ?, reviewContent = ?, reviewRating = ? where reviewId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, memberReviewDto.getReviewTitle());
		ps.setString(2, memberReviewDto.getReviewContent());
		ps.setInt(3, memberReviewDto.getReviewRating());
		ps.setInt(4, memberReviewDto.getReviewId());
		int count = ps.executeUpdate();
		if(count == 1) {return true;} // 하나의 행을 정상적으로 수정한 경우 true 반환
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
	// 5. 리뷰 삭제 SQL 처리 메소드
	public boolean delete(MemberReviewDto memberReviewDto) {
		try {
		String sql = "delete from movieReview where reviewId = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, memberReviewDto.getReviewId());
		int count = ps.executeUpdate();
		if(count == 1) {return true;} // 하나의 행을 정상적으로 삭제한 경우 true 반환
		}catch (Exception e) {System.out.println(e);}
		return false;
	}
}
