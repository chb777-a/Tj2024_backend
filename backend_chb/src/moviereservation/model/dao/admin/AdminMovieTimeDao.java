package moviereservation.model.dao.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import moviereservation.model.dao.Dao;
import moviereservation.model.dto.admin.AdminMovieTimeDto;

public class AdminMovieTimeDao extends Dao {
		private static AdminMovieTimeDao instance = new AdminMovieTimeDao();
		private AdminMovieTimeDao() {}
		public static AdminMovieTimeDao getInstance() {
			return instance;
		}
		public boolean movieTimeRes(AdminMovieTimeDto adminMovieTimeDto) {
			try {
			String sql = "insert into timeTable(startTime, finishTime, movieDate,theaterId,movieId ) values (?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, adminMovieTimeDto.getStartTime());
			ps.setString(2, adminMovieTimeDto.getFinishtime());
			ps.setString(3, adminMovieTimeDto.getMovieDate());
			ps.setInt(4, adminMovieTimeDto.getTheaterId());
			ps.setInt(5, adminMovieTimeDto.getMovieId());
			int count = ps.executeUpdate();
			return count > 0; // if(count == 1) {return true;} 원래 강사님 설명코드는 이코드인데 어차피 boolean기본값이 트루니까 if 생략함
			} catch(SQLException e) {
				System.out.println(e);
			}
			return false;
		}
		public ArrayList<AdminMovieTimeDto> movieTimeShow() {
			ArrayList<AdminMovieTimeDto> list = new ArrayList<AdminMovieTimeDto>();
			
			try {
				String sql = "select timepk, m.movieName as movieName, startTime, finishTime, movieDate, theaterId, m.runTime as runTime from  timeTable tt inner join movie m on tt.movieId = m.movieId order by timepk";
				PreparedStatement ps;
				ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {					
					AdminMovieTimeDto adminMovieTimeDto = new AdminMovieTimeDto();
					adminMovieTimeDto.setMovieDate(rs.getString("movieDate"));
					adminMovieTimeDto.setFinishtime(rs.getString("finishtime"));
					adminMovieTimeDto.setMovieName(rs.getString("movieName"));
					adminMovieTimeDto.setRunTime(rs.getInt("runtime"));
					adminMovieTimeDto.setStartTime(rs.getString("startTime"));
					adminMovieTimeDto.setTheaterId(rs.getInt("TheaterId"));
					adminMovieTimeDto.setTimepk(rs.getInt("timepk"));;
					list.add(adminMovieTimeDto);
				}
			}catch(SQLException e) {
				System.out.println(e);
			}
			return list;
		}
		public boolean deleteByNum(int timepk) {
			try {
	            String sql = "delete from timeTable where timepk = ?";
	            PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1,timepk );
	            int result = ps.executeUpdate();
	            return result > 0; 
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
			return false;
	    }
		public boolean updateByNum(AdminMovieTimeDto adminMovieTimeDto) {
		    String sql = "update timeTable set startTime = ?, finishTime = ?, movieDate = ?, theaterId = ?, movieId = ? where timepk = ?";
		    try (PreparedStatement ps = conn.prepareStatement(sql)) {
		        ps.setString(1, adminMovieTimeDto.getStartTime());
		        ps.setString(2, adminMovieTimeDto.getFinishtime());
		        ps.setString(3, adminMovieTimeDto.getMovieDate());
		        ps.setInt(4, adminMovieTimeDto.getTheaterId());
		        ps.setInt(5, adminMovieTimeDto.getMovieId());
		        ps.setInt(6, adminMovieTimeDto.getTimepk());
		        
		        int rowsUpdated = ps.executeUpdate();
		        return rowsUpdated > 0;
		    } catch (SQLException e) {
		        System.out.println(e);
		        return false;
		    }
		}
}



