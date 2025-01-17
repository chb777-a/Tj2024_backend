package moviereservation.model.dao.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import moviereservation.model.dao.Dao;
import moviereservation.model.dto.admin.AdminMovieInfoDto;

public class AdminMovieInfoDao extends Dao {
    private static AdminMovieInfoDao instance = new AdminMovieInfoDao();
    private AdminMovieInfoDao() {}
    public static AdminMovieInfoDao getInstance() {
        return instance;  
    }
    public boolean movieInfoRes(AdminMovieInfoDto adminMovieInfoDto) {
		try {
		String sql = "insert into movie(movieName, runTime, movieGrade, genreId ) values (?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql); 
		ps.setString(1, adminMovieInfoDto.getMovieName());
		ps.setInt(2, adminMovieInfoDto.getRunTime());
		ps.setString(3, adminMovieInfoDto.getMovieGrade());
		ps.setInt(4, adminMovieInfoDto.getGenreId());
		int count = ps.executeUpdate();
		return count > 0;
		} catch(SQLException e) {
			System.out.println(e);
		}
    	return false;
    	 
    }
	public ArrayList<AdminMovieInfoDto> movieInfoShow() {
		ArrayList<AdminMovieInfoDto> list = new ArrayList<AdminMovieInfoDto>();
		try {
			String sql = "select movieId, movieName, runTime, movieGrade, c.genreName as genreName from movie m inner join categorie c on m.genreId = c.genreId order by movieId";
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {	
				AdminMovieInfoDto adminMovieInfoDto = new AdminMovieInfoDto();
				adminMovieInfoDto.setMovieId(rs.getInt("movieId"));
				adminMovieInfoDto.setMovieName(rs.getString("movieName"));
				adminMovieInfoDto.setRunTime(rs.getInt("runTime"));
				adminMovieInfoDto.setMovieGrade(rs.getString("movieGrade"));
				adminMovieInfoDto.setGenreName(rs.getString("genreName"));
				list.add(adminMovieInfoDto);
			}
		} catch(SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	public boolean updateByNum(AdminMovieInfoDto adminMovieInfoDto) {
		String sql = "update movie set movieName = ?, runTime = ?, movieGrade = ?, genreId = ? where movieId = ?";
		try(PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, adminMovieInfoDto.getMovieName());
			ps.setInt(2, adminMovieInfoDto.getRunTime());
			ps.setString(3, adminMovieInfoDto.getMovieGrade());
			ps.setInt(4, adminMovieInfoDto.getGenreId());
			ps.setInt(5, adminMovieInfoDto.getMovieId());
			
			int rowsUpdated = ps.executeUpdate();
			return rowsUpdated > 0;
		} catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
	public boolean deleteByNum(int movieId) {
		try {
			String sql = "delete from movie where movieId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, movieId);
			int result = ps.executeUpdate();
			return result > 0;
		}catch(SQLException e) {
			System.out.println(e);
		}
		return false;
	}
}

