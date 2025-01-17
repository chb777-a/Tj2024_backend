package moviereservation.model.dto.admin;

public class AdminPrintUserDto {
	private int memberId;
	private String mId;
	private String mname;
	private String movieName;
	private String movieDate;
	private int theaterId;
	private int seatNum;
	private String resvDate;
	private int resvId;
	public AdminPrintUserDto() {}
	

	public AdminPrintUserDto(int memberId, String mId, String mname, String movieName, String movieDate, int theaterId,
			int seatNum, String resvDate, int resvId) {
	
		this.memberId = memberId;
		this.mId = mId;
		this.mname = mname;
		this.movieName = movieName;
		this.movieDate = movieDate;
		this.theaterId = theaterId;
		this.seatNum = seatNum;
		this.resvDate = resvDate;
		this.resvId = resvId;
	}


	public AdminPrintUserDto(int resvId,String resvDate) {
		this.resvId = resvId;
		this.resvDate = resvDate;
		
	}

	public int getMemberId() {
		return memberId;
	}

	public String getResvDate() {
		return resvDate;
	}

	public void setResvDate(String resvDate) {
		this.resvDate = resvDate;
	}

	public int getResvId() {
		return resvId;
	}

	public void setResvId(int resvId) {
		this.resvId = resvId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(String movieDate) {
		this.movieDate = movieDate;
	}

	public int getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public String getRevDate() {
		return resvDate;
	}

	public void setRevDate(String revDate) {
		this.resvDate = revDate;
	}

	@Override
	public String toString() {
		return "AdminPrintUserDto [memberId=" + memberId + ", mId=" + mId + ", mname=" + mname + ", movieName="
				+ movieName + ", movieDate=" + movieDate + ", theaterId=" + theaterId + ", seatNum=" + seatNum
				+ ", resvDate=" + resvDate + ", resvId=" + resvId + "]";
	}



	

	

}
