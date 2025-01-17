package moviereservation.model.dao.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import moviereservation.model.dao.Dao;
import moviereservation.model.dto.admin.AdminDto;



public class AdminInfoDao extends Dao{
	private AdminInfoDao() {}
	private static AdminInfoDao instance = new AdminInfoDao();
	public static AdminInfoDao getInstance(){
		return instance;
	}
	 public boolean checkPw(AdminDto adminDto) {
		   try {
		   String sql = "select apw from admin where adminId = ?";
		   PreparedStatement ps = conn.prepareStatement(sql);
		   ps.setInt(1, adminDto.getAdminId());
		   ResultSet rs = ps.executeQuery();
		   if(rs.next()) {
			   String pw = rs.getString("apw");
			   
			   return pw.equals(adminDto.getApw());
		   	}
		   }catch (Exception e) {System.out.println(e);}
		   return false;
	   }
	 public boolean adminUpdate(AdminDto adminDto) {
		   try {
			   String sql = "update admin set apw = ?, aname = ? where adminId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
		   ps.setString(1, adminDto.getApw());
		   ps.setString(2, adminDto.getAname());
		   ps.setInt(3, adminDto.getAdminId());
		   int count = ps.executeUpdate();
		   if(count == 1) {return true;}
		   }catch (Exception e) {System.out.println(e);}
		   return false;
		   
		   }
	  public void adminDelete(int loginAno) {
		   try {
		   String sql = "delete from admin where adminId = ?";
		   PreparedStatement ps = conn.prepareStatement(sql);
		   ps.setInt(1, loginAno);
		   int count = ps.executeUpdate();
		   if(count > 0) {
			   System.out.println("회원 탈퇴 성공");
		   }
		   else {
			   System.out.println("회원탈퇴 실패");
		   }
		   }catch (Exception e) {System.out.println(e);}
		   return;
	   }


}
