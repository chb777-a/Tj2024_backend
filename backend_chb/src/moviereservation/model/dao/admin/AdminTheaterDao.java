package moviereservation.model.dao.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import moviereservation.model.dao.Dao;
import moviereservation.model.dto.admin.AdminTheaterDto;

public class AdminTheaterDao extends Dao{
	private AdminTheaterDao() {}
	private static AdminTheaterDao instance = new AdminTheaterDao();
	public static AdminTheaterDao getInstance() {
		return instance;
	}
	public boolean checkTheaterId(AdminTheaterDto adminTheaterDto) {
		try {
			String sql = "select * from Theater where theaterId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,adminTheaterDto.getTid());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("theaterid");
				return id==adminTheaterDto.getTid();
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public boolean addTheater(AdminTheaterDto adminTheaterDto) {
		try {
		String sql = "insert into theater(theaterId,seat,screen) "
				+ "values( '"+adminTheaterDto.getTid()+"' ,'"+adminTheaterDto.getTseat()+"','"+adminTheaterDto.getTscreen()+"' )";
		PreparedStatement ps = conn.prepareStatement(sql);
		int count = ps.executeUpdate();
		if(count==1) {return true;}
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public ArrayList<AdminTheaterDto> printBasicTheater() {
		ArrayList<AdminTheaterDto> list = new ArrayList<>();
		try {
			String sql = "select * from theater";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int tid = rs.getInt("theaterId");
				int tseat = rs.getInt("seat");
				String tscreen = rs.getString("screen");
	
				AdminTheaterDto adminTheaterDto = new AdminTheaterDto(tid,tseat,tscreen);
				list.add(adminTheaterDto);
			} // w e
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
	
	public AdminTheaterDto findPrintDetailTheater(int tid) {
		try {
	        String sql = "select * from Theater where theaterid = ? ";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, tid);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	         
	        	AdminTheaterDto adminTheaterDto = new AdminTheaterDto(
	        		rs.getInt("theaterId"),
	                rs.getInt("seat"),
	                rs.getString("screen")
	            );
	            return adminTheaterDto;  // 조회된 관 객체 반환
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return null;
	}
	
	public AdminTheaterDto printDetailTheater(AdminTheaterDto adminTheaterDto) {
		try {
			String sql = "select * from theater where theaterId= ?";
			PreparedStatement ps = conn.prepareStatement( sql );
			ps.setInt(1, adminTheaterDto.getTid());
			ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	         
	        	adminTheaterDto = new AdminTheaterDto(
	        		rs.getInt("theaterId"),
	                rs.getInt("seat"),
	                rs.getString("screen")
	               
	            );
				 return adminTheaterDto;
		}
		}catch(Exception e) {System.out.println(e);}	
		return null;
	}
	
	public boolean updateTheater(AdminTheaterDto adminTheaterDto) {
		try {
			//[1] SQL 작성한다.
			String sql = "update Theater set seat = ? , screen = ? where theaterid = ? ";
			//[2] DB와 연동된 곳에 SQL 기재한다.
			PreparedStatement ps = conn.prepareStatement( sql );
			//[*] 기재된 SQL에 매개변수 값 대입한다.
			ps.setInt(1, adminTheaterDto.getTseat());
			ps.setString(2, adminTheaterDto.getTscreen());
			ps.setInt(3,adminTheaterDto.getTid());
			//[3] 기재된 SQL 실행하고 결과를 받는다.
			int count = ps.executeUpdate();
			//[4] 결과에 따른 처리 및 변환을 한다.
			if(count==1) {return true;}
		}catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public AdminTheaterDto deleteTheater(AdminTheaterDto adminTheaterDto) {
		try {
			String sql = "delete from Theater where  theaterid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, adminTheaterDto.getTid());
			int count = ps.executeUpdate();
		}catch(Exception e) {System.out.println(e);}	
		return adminTheaterDto;
	}

	
	public AdminTheaterDto findupdateTheater(int tid) {
		try {
	        String sql = "select * from Theater where  theaterid = ? ";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, tid);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	         
	        	AdminTheaterDto adminTheaterDto = new AdminTheaterDto(
	                rs.getInt("seat"),
	                rs.getString("screen")
	            );
	            return adminTheaterDto;  // 조회된 관 객체 반환
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return null;
	}
	
	public AdminTheaterDto finddeleteTheater(int tid) {
		try {
	        String sql = "select * from Theater where theaterid = ? ";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, tid);
	        ResultSet rs = ps.executeQuery();
	        
	        if (rs.next()) {
	         
	        	AdminTheaterDto adminTheaterDto = new AdminTheaterDto(
	        		rs.getInt("theaterId"),
	                rs.getInt("seat"),
	                rs.getString("screen")
	            );
	            return adminTheaterDto;  // 조회된 관 객체 반환
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return null;
	}
	

}