package moviereservation.model.dto.member;

public class MemberReviewDto {
	private int reviewId;
	private String reviewTitle;
	private String reviewContent;
	private int reviewRating;
	private String reviewDate;
	private String movieName;
	private int memberId;	// 회원번호
	private int movieId;	// 영화번호
	private String mid;
	public MemberReviewDto() {}
	public MemberReviewDto(int reviewId, String reviewTitle, String reviewContent, int reviewRating, String reviewDate,
			String movieName, int memberId, int movieId) {
		super();
		this.reviewId = reviewId;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewRating = reviewRating;
		this.reviewDate = reviewDate;
		this.movieName = movieName;
		this.memberId = memberId;
		this.movieId = movieId;
	}

	public MemberReviewDto(int reviewId, String reviewTitle, String reviewContent, int reviewRating, String reviewDate,
			String movieName) {
		super();
		this.reviewId = reviewId;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.reviewRating = reviewRating;
		this.reviewDate = reviewDate;
		this.movieName = movieName;
	}
	@Override
	public String toString() {
		return "MemberReviewDto [reviewId=" + reviewId + ", reviewTitle=" + reviewTitle + ", reviewContent="
				+ reviewContent + ", reviewRating=" + reviewRating + ", reviewDate=" + reviewDate + ", movieName="
				+ movieName + ", memberId=" + memberId + ", movieId=" + movieId + "]";
	}
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public int getReviewRating() {
		return reviewRating;
	}
	public void setReviewRating(int reviewRating) {
		this.reviewRating = reviewRating;
	}
	public String getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	
}
