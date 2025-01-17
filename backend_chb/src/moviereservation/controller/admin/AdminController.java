package moviereservation.controller.admin;

import moviereservation.model.dao.admin.AdminDao;
import moviereservation.model.dto.admin.AdminDto;

public class AdminController {

	private AdminController() {}
	private static AdminController instance = new AdminController();
	public static AdminController getInstance() {
		return instance;
	}
	public boolean adminSignup(AdminDto adminDto) {
		boolean result = AdminDao.getInstance().adminSignup(adminDto);
		return result;
	}
	private int loginAno = 0;
	public int getLoginAno(){return loginAno;}
	public void setLoginAno(int loginAno) {
	    this.loginAno = loginAno;
	}
	public boolean adminLogin(AdminDto adminDto) {
		int result = AdminDao.getInstance().adminLogin(adminDto);
		if(result > 0) {
			loginAno = result;
			return true;
		}
		else {return false;}
	}
	

}
