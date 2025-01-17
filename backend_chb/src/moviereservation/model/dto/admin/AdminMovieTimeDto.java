package moviereservation.model.dto.admin;

public class AdminMovieTimeDto {

	private int timepk;
	private String startTime;
	private String finishtime;
	private String movieDate;
	private int theaterId;
	private int movieId;
	private String movieName;
	private int runTime;
	
	
	public AdminMovieTimeDto() {}
	public AdminMovieTimeDto( String startTime, String finishtime, String movieDate, int theaterId, int movieId) {
		super();
		this.startTime = startTime;
		this.finishtime = finishtime;
		this.movieDate = movieDate;
		this.theaterId = theaterId;
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getRunTime() {
		return runTime;
	}

	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}

	public AdminMovieTimeDto(int timepk, String startTime, String finishtime, String movieDate, int theaterId,
			int movieId, String movieName, int runTime) {
		super();
		this.timepk = timepk;
		this.startTime = startTime;
		this.finishtime = finishtime;
		this.movieDate = movieDate;
		this.theaterId = theaterId;
		this.movieId = movieId;
		this.movieName = movieName;
		this.runTime = runTime;
	}

	public AdminMovieTimeDto(int timepk, String startTime, String finishtime, String movieDate, int theaterId,
			int movieId) {
		super();
		this.timepk = timepk;
		this.startTime = startTime;
		this.finishtime = finishtime;
		this.movieDate = movieDate;
		this.theaterId = theaterId;
		this.movieId = movieId;
	}
	
	@Override
	public String toString() {
		return "AdminMovieTimeDto [startTime=" + startTime + ", finishtime=" + finishtime + ", movieDate=" + movieDate
				+ ", theaterId=" + theaterId + ", movieId=" + movieId + "]";
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getFinishtime() {
		return finishtime;
	}

	public void setFinishtime(String finishtime) {
		this.finishtime = finishtime;
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

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}



	public int getTimepk() {
		return timepk;
	}

	public void setTimepk(int timepk) {
		this.timepk = timepk;
	}
	
	
	
	
	
}
