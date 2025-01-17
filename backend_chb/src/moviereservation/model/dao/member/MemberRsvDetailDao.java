package moviereservation.model.dao.member;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import moviereservation.model.dao.Dao;
import moviereservation.model.dto.member.MemberRsvDetailDto;

public class MemberRsvDetailDao extends Dao {
	private static MemberRsvDetailDao instance = new MemberRsvDetailDao();
	private MemberRsvDetailDao() {}
	public static MemberRsvDetailDao getInstance() {return instance;}
	
		public ArrayList<MemberRsvDetailDto> printMovieName( ) {
			ArrayList<MemberRsvDetailDto> list = new ArrayList<>();
			try{String sql = "select movieId, movieName from movie";
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					MemberRsvDetailDto memberRsvDetailDto = new MemberRsvDetailDto();
					memberRsvDetailDto.setMovieId(rs.getInt("movieId"));
					memberRsvDetailDto.setRsvMovieName(rs.getString("movieName"));
					list.add(memberRsvDetailDto);
				}
				}catch(SQLException e) {System.out.println(e);}
			return list;
			}
		
		public MemberRsvDetailDto printTheater(int timepk) {
		      MemberRsvDetailDto memberRsvDetailDto = null;
		      try {
		         // SQL: 상영 시간과 영화 ID에 따라 상영관과 좌석 정보를 가져옴
		         String sql = "SELECT t.movieId, t.theaterId, th.screen, th.seat " + "FROM timeTable t "
		               + "JOIN theater th ON t.theaterId = th.theaterId " + "WHERE t.timepk = ?";

		         PreparedStatement ps = conn.prepareStatement(sql);
		         ps.setInt(1, timepk);
		         ResultSet rs = ps.executeQuery();

		         // 조회된 결과 처리
		         if (rs.next()) {
		            memberRsvDetailDto = new MemberRsvDetailDto();
		            memberRsvDetailDto.setMovieId(rs.getInt("movieId"));
		            memberRsvDetailDto.setTheaterId(rs.getInt("theaterId"));
		            memberRsvDetailDto.setRsvScreen(rs.getString("screen"));
		            memberRsvDetailDto.setRsvSeat(rs.getInt("seat")); // 좌석 정보 추가
		         }
		      } catch (SQLException e) {
		         System.out.println(e);
		      }
		      System.out.println(memberRsvDetailDto.getRsvSeat());
		      return memberRsvDetailDto;
		}
		
		public ArrayList<MemberRsvDetailDto> printTheaterTime(int movieId) {
		      ArrayList<MemberRsvDetailDto> list = new ArrayList<>();
		      try {
		         String sql = "select timepk, movieDate, startTime, finishTime, theaterId from timeTable where movieId = ?";
		         PreparedStatement ps = conn.prepareStatement(sql);
		         // ps.setInt(1, );
		         ps.setInt(1, movieId);
		         ResultSet rs = ps.executeQuery();
		         while (rs.next()) {
		            MemberRsvDetailDto memberRsvDetailDto = new MemberRsvDetailDto();
		            memberRsvDetailDto.setTimepk(rs.getInt("timepk"));
		            memberRsvDetailDto.setMovieDate(rs.getString("movieDate"));
		            memberRsvDetailDto.setStartTime(rs.getString("startTime"));
		            memberRsvDetailDto.setFinishTime(rs.getString("finishTime"));
		            memberRsvDetailDto.setTheaterId(rs.getInt("theaterId"));
		            list.add(memberRsvDetailDto);
		         }
		      } catch (SQLException e) {
		         System.out.println(e);
		      }
		      return list;
		   }
		
		//예매 확인 
		public boolean rsvCheck(int rsvId, int memberId) {
			try{
				String sql = "select * from resv where resvId = ? and memberId = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, rsvId);
				ps.setInt(2, memberId);
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {return true;}
			}catch (Exception e) {System.out.println(e);}
			return false;
		}
		
		// 영화 예매 내역 전체 출력
		public ArrayList<MemberRsvDetailDto> printRsv(int loginMno){
			ArrayList<MemberRsvDetailDto> list = new ArrayList<>();
			
			try{
				System.out.println("DAO received loginMno: " + loginMno);
				String sql = "SELECT *"
						 + " FROM resv"
						 + " JOIN member ON resv.memberId = member.memberId"
						 + " JOIN timeTable ON resv.timepk = timeTable.timepk"
						 +" JOIN movie ON timeTable.movieId = movie.movieId"
						 +" JOIN theater ON timeTable.theaterId = theater.theaterId"
						 +" JOIN resvSeat ON resv.resvId = resvSeat.resvId"
						 +" where resv.memberId = ?"
						 +" ORDER BY resv.resvDate, resv.resvId";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, loginMno);
				ResultSet rs = ps.executeQuery();
				
			
				while(rs.next()) {
				MemberRsvDetailDto memberRsvDetailDto1 = new MemberRsvDetailDto();
				memberRsvDetailDto1.setRsvNum(rs.getInt("resvId")); //resv - resvId
				memberRsvDetailDto1.setRsvMovieName(rs.getString("movieName")); //movie - movieName
				memberRsvDetailDto1.setMovieDate(rs.getString("movieDate")); //timeTable - movieDate
				memberRsvDetailDto1.setStartTime(rs.getString("startTime")); //timeTable - startTime
				memberRsvDetailDto1.setFinishTime(rs.getString("finishTime")); //timeTable - finishTime
				memberRsvDetailDto1.setRsvTheater(rs.getString("theaterId")); //theater - theaterId
				memberRsvDetailDto1.setRsvSeat(rs.getInt("seatNum")); //theater - seat
				memberRsvDetailDto1.setRsvTime(rs.getString("resvDate")); //resv - resvDate
				list.add(memberRsvDetailDto1);
			}
			}catch(SQLException e) {System.out.println(e);}
			return list;
		}
		
		
		
		//예매 취소
		public boolean rsvCan(MemberRsvDetailDto memberRsvDetailDto) {
			try{
				String sql = "delete from resv where resvId = ?";
							PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, memberRsvDetailDto.getRsvNum());
				int count = ps.executeUpdate();
				if(count == 1) {return true;}
			}catch (Exception e) {
				System.out.println(e);
			}
			return false;
			
		}
		
		//영화 예매 내역 출력
		   public ArrayList<MemberRsvDetailDto> getRsvSeat(MemberRsvDetailDto memberRsvDetailDto, int rsvTime) {
			      ArrayList<MemberRsvDetailDto> list = new ArrayList<>();
			      try {
			         String sql = "SELECT t.movieId, m.movieName, t.theaterId, th.screen, th.seat, t.movieDate, t.startTime, t.finishTime, r.resvId, mem.mname, rs.seatNum "
			               + " FROM timeTable t " + "JOIN theater th ON t.theaterId = th.theaterId "
			               + " JOIN movie m ON t.movieId = m.movieId " + "JOIN resv r ON t.timepk = r.timepk "
			               + " JOIN resvSeat rs ON r.resvId = rs.resvId " + "JOIN member mem ON r.memberId = mem.memberId "
			               +" where t.theaterId = ?";
			         PreparedStatement ps = conn.prepareStatement(sql);
			         ps.setInt(1, memberRsvDetailDto.getTheaterId());
			         ResultSet rs = ps.executeQuery();
			         while (rs.next()) {
			            MemberRsvDetailDto seatDetail = new MemberRsvDetailDto();
			            seatDetail.setRsvSeat(rs.getInt("seatNum")); // 좌석 번호를 DTO에 설정
			            list.add(seatDetail); // 리스트에 추가
			         }
			      } catch (SQLException e) {
			         System.out.println(e);
			      }
			   
			      return list; // 좌석 정보 리스트 반환
			   }
			   // 좌석 중복 검사
		   public boolean checkSeat(int rsvSeatNum , int timepk) {
			      try {
			         String sql = "select count(*) from resvSeat inner join resv on resvSeat.resvId = resv.resvId where resvSeat.seatNum = ? and resv.timepk = ?";
			         PreparedStatement ps = conn.prepareStatement(sql);
			         ps.setInt(1, rsvSeatNum);
			         ps.setInt(2, timepk);
			         ResultSet rs = ps.executeQuery();
			         if (rs.next()) {
			             int count = rs.getInt(1);
			             System.out.println("좌석 번호 " + rsvSeatNum + "의 예약된 개수: " + count);
			             return count > 0; // 1개 이상 예약된 경우 true 반환
			         }
			      }catch(Exception e) {System.out.println(e);}
			      return false;
			   }	
			   
			   // 예약 
		public int movieRsvRes(MemberRsvDetailDto memberRsvDetailDto , String nowDate , int loginMno ) {
			
			try {
			String sql ="insert into resv(resvDate,memberId,timepk) values( ? ,? ,?)";
		    PreparedStatement ps = conn.prepareStatement(sql , Statement.RETURN_GENERATED_KEYS );
		    ps.setString( 1 , nowDate );
		    ps.setInt( 2 , loginMno);
		    ps.setInt( 3 ,  memberRsvDetailDto.getTimepk() );
		    
		    
		    	ps.executeUpdate();
		     ResultSet rs = ps.getGeneratedKeys();
		     if( rs.next() ) {
		    	 return rs.getInt(1);
		     }
		    
		      }catch (Exception e) {System.out.println(e);}
		      return 0;
		  
		}
			// 예약 상세는 좌석 수 만큼 반복 
		public boolean movieRsvRes( int resvId  , int rsvSeatNum) {
			try {
				String sql ="insert into resvSeat(seatNum,resvId) values( ? ,? )";
			    PreparedStatement ps = conn.prepareStatement(sql );
			    ps.setInt( 1 , rsvSeatNum );
			    ps.setInt( 2 , resvId);
			    
			    int count = ps.executeUpdate();
			      if(count == 1) {return true;} // 회원가입 성공
			      }catch (Exception e) {System.out.println(e);}
			      return false;
		}
					
}








