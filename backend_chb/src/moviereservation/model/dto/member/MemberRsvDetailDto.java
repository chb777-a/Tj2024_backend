package moviereservation.model.dto.member;

public class MemberRsvDetailDto {
	private int rsvNum;
	private String rsvMovieName;
	private String rsvTheater;
	private String rsvTime;
	private int rsvPerson;
	private int rsvSeat;
	private int movieId;
	private int theaterId;
	private String rsvScreen;
	private String startTime;
	private String finishTime;
	private String movieDate;
	private int totalSeat;
	
	public int getTimepk() {
		return timepk;
	}
	public void setTimepk(int timepk) {
		this.timepk = timepk;
	}


	private int timepk;
	
	public MemberRsvDetailDto() {}
	public MemberRsvDetailDto(int totalSeat, int timepk, String startTime, String finishTime, String movieDate, int theaterId, String rsvScreen, int movieId, int rsvNum, String rsvMovieName, String rsvTheater, String rsvTime, int rsvPerson,
			int rsvSeat) {
		super();
		this.totalSeat = totalSeat;
		this.timepk = timepk;
		this.startTime = startTime;
		this.finishTime = finishTime;
		this.movieDate = movieDate;
		this.theaterId = theaterId;
		this.rsvScreen = rsvScreen;
		this.movieId = movieId;
		this.rsvNum = rsvNum;
		this.rsvMovieName = rsvMovieName;
		this.rsvTheater = rsvTheater;
		this.rsvTime = rsvTime;
		this.rsvPerson = rsvPerson;
		this.rsvSeat = rsvSeat;
	}
	public int getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(int totalSeat) {
		this.totalSeat = totalSeat;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
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
	public String getRsvScreen() {
		return rsvScreen;
	}
	public void setRsvScreen(String rsvScreen) {
		this.rsvScreen = rsvScreen;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getRsvNum() {
		return rsvNum;
	}
	public void setRsvNum(int rsvNum) {
		this.rsvNum = rsvNum;
	}
	public String getRsvMovieName() {
		return rsvMovieName;
	}
	public void setRsvMovieName(String rsvMovieName) {
		this.rsvMovieName = rsvMovieName;
	}
	public String getRsvTheater() {
		return rsvTheater;
	}
	public void setRsvTheater(String rsvTheater) {
		this.rsvTheater = rsvTheater;
	}
	public String getRsvTime() {
		return rsvTime;
	}
	public void setRsvTime(String rsvTime) {
		this.rsvTime = rsvTime;
	}
	public int getRsvPerson() {
		return rsvPerson;
	}
	public void setRsvPerson(int rsvPerson) {
		this.rsvPerson = rsvPerson;
	}
	public int getRsvSeat() {
		return rsvSeat;
	}
	public void setRsvSeat(int rsvSeat) {
		this.rsvSeat = rsvSeat;
	}
	
	
	public MemberRsvDetailDto(String rsvMovieName) {
		super();
		this.rsvMovieName = rsvMovieName;
	}
}