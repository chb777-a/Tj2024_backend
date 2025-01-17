package moviereservation.model.dto.admin;

public class AdminMovieInfoDto {
	private int movieId;
	private String movieName;
	private int runTime;
	private String movieGrade;
	private int genreId;
	private String genreName;
	
	public AdminMovieInfoDto() {}
	public AdminMovieInfoDto(int movieId, String movieName, int runTime, String movieGrade, int genreId, String genreName) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.runTime = runTime;
		this.movieGrade = movieGrade;
		this.genreId = genreId;
		this.genreName = genreName;
	} 
	

	@Override
	public String toString() {
		return "AdminMovieInfoDto [movieId=" + movieId + ", movieName=" + movieName + ", runTime=" + runTime
				+ ", movieGrade=" + movieGrade + ", genreId=" + genreId + ", genreName=" + genreName + "]";
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

	public int getRunTime() {
		return runTime;
	}

	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}

	public String getMovieGrade() {
		return movieGrade;
	}

	public void setMovieGrade(String movieGrade) {
		this.movieGrade = movieGrade;
	}

	public int getGenreId() {
		return genreId;
	}


	public void setGenreId(int genreId) {
		this.genreId = genreId;
	}


	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public AdminMovieInfoDto(String movieName, int runTime, String movieGrade, int genreId) {
		super();
		this.movieName = movieName;
		this.runTime = runTime;
		this.movieGrade = movieGrade;
		this.genreId = genreId;
	}
	
	
	
}
	
