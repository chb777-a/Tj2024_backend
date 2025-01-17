package moviereservation.model.dao.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import moviereservation.model.dao.Dao;
import moviereservation.model.dto.admin.AdminDto;

public class AdminDao extends Dao {
	private static AdminDao instance = new AdminDao();
	private AdminDao() {}
	public static AdminDao getInstance() {
		return instance;
	}
	public boolean adminSignup(AdminDto adminDto) {
		if(checkId(adminDto)){
	         return false;
	      }
	      try {
	      String sql = "insert into admin(aid, apw, aname) values('"+adminDto.getAid()+"', '"+adminDto.getApw()+"', '"+adminDto.getAname()+"')";
	      PreparedStatement ps = conn.prepareStatement(sql);
	      int count = ps.executeUpdate();
	      if(count == 1) {return true;} // 회원가입 성공
	      }catch (Exception e) {System.out.println(e);}
	      return false;
	   }
	
	public boolean checkId(AdminDto adminDto) {
    try {
    String sql = "select count(*) from admin where aid = ?";
    PreparedStatement ps = conn.prepareStatement(sql);
    ps.setString(1, adminDto.getAid());
    ResultSet rs = ps.executeQuery();
    if(rs.next() && rs.getInt(1) > 0) {
       return true;	// 아이디가 이미 존재
    }
    }catch (Exception e) {System.out.println(e);}
    return false;		// 아이디가 존재하지 않음
 }
	public int adminLogin(AdminDto adminDto) {
		 try {
			   String sql = "select adminId from admin where aid = ? and apw = ?";
			   PreparedStatement ps = conn.prepareStatement(sql);
			   ps.setString(1, adminDto.getAid());
			   ps.setString(2, adminDto.getApw());
			   ResultSet rs = ps.executeQuery();
			   if(rs.next()) {
				   int adminId = rs.getInt("adminId");
				   return adminId;
			   }
			   }catch (Exception e) {System.out.println(e);}
			   return 0;
		   }
	
	
}
