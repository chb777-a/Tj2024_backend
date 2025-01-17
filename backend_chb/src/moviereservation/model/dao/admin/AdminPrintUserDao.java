package moviereservation.model.dao.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import moviereservation.model.dao.Dao;
import moviereservation.model.dto.admin.AdminPrintUserDto;

public class AdminPrintUserDao extends Dao{
	private AdminPrintUserDao() {}
	private static AdminPrintUserDao instance = new AdminPrintUserDao();
	public static AdminPrintUserDao getInstance() {
		return instance;
	}
	public ArrayList<AdminPrintUserDto> printUser() {
		ArrayList<AdminPrintUserDto> list = new ArrayList<>();
		try {
		
		String sql = "SELECT "
				+ "	member.mname,resv.resvId,member.memberId,member.mId,movie.movieName,timeTable.movieDate,theater.theaterId,resvSeat.seatNum,resv.resvDate "
				+ "FROM resv "
				+ "JOIN member ON resv.memberId = member.memberId "
				+ "JOIN timeTable ON resv.timepk = timeTable.timepk "
				+ "JOIN movie ON timeTable.movieId = movie.movieId "
				+ "JOIN theater ON timeTable.theaterId = theater.theaterId "
				+ "JOIN resvSeat ON resv.resvId = resvSeat.resvId "
				+ "ORDER BY resv.resvDate,resv.resvId";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			int memberId = rs.getInt("memberId");
			int resvId = rs.getInt("resvId");
			int theaterId = rs.getInt("theaterId");
			int seatNum = rs.getInt("seatNum");
			String mname = rs.getString("mname");
			String mId = rs.getString("mId");
			String movieName = rs.getString("movieName");
			String movieDate = rs.getString("movieDate");
			String resvDate =rs.getString("resvDate");
			
			AdminPrintUserDto adminPrintUserDto = new AdminPrintUserDto(
					memberId, mId,mname,movieName,movieDate,theaterId,
					seatNum, resvDate, resvId
					);
			list.add(adminPrintUserDto);
		}


		}catch(SQLException e) {
			System.out.println(e);
		}
		return list;
	}


}
