package moviereservation.controller.admin;

import moviereservation.model.dao.admin.AdminInfoDao;
import moviereservation.model.dto.admin.AdminDto;

public class AdminInfoController {
	private  AdminInfoController() {}
	private static AdminInfoController instance = new AdminInfoController();
	public static AdminInfoController getInstance()
	{
		return instance;
	}
	private int loginAno = AdminController.getInstance().getLoginAno();
	
	public void adminLogout() {
		loginAno = 0;
	
	}
	public void adminDelete() {
		AdminInfoDao.getInstance().adminDelete(loginAno);
		loginAno = 0;
		
	}
	public boolean checkPw(AdminDto adminDto) {
		adminDto.setAdminId(loginAno);
		return AdminInfoDao.getInstance().checkPw(adminDto);
	}

	public boolean adminUpdate(AdminDto adminDto) {
		adminDto.setAdminId(loginAno);
		
		boolean result = AdminInfoDao.getInstance().adminUpdate(adminDto);
		return result;
	}
}
