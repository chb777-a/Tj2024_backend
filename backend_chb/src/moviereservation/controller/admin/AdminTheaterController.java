package moviereservation.controller.admin;

import java.util.ArrayList;

import moviereservation.model.dao.admin.AdminTheaterDao;
import moviereservation.model.dto.admin.AdminTheaterDto;

public class AdminTheaterController {
	private AdminTheaterController() {}
	private static AdminTheaterController instance = new AdminTheaterController();
	public static AdminTheaterController getInstance() {
		return instance;
	}
	public boolean addTheater(AdminTheaterDto adminTheaterDto) {
		boolean result = AdminTheaterDao.getInstance().addTheater(adminTheaterDto);
		return result;
	}
	
	public ArrayList<AdminTheaterDto> printBasicTheater() {
		ArrayList<AdminTheaterDto> result=AdminTheaterDao.getInstance().printBasicTheater();
		return result;
	}
	public AdminTheaterDto printDetailTheater(AdminTheaterDto adminTheaterDto) {
		AdminTheaterDto result = AdminTheaterDao.getInstance().printDetailTheater(adminTheaterDto);
		return result;
	}

	
	public boolean updateTheater(AdminTheaterDto adminTheaterDto) {
		boolean result = AdminTheaterDao.getInstance().updateTheater(adminTheaterDto);
		return result;
	}
	public AdminTheaterDto deleteTheater(AdminTheaterDto adminTheaterDto) {
		AdminTheaterDto result = AdminTheaterDao.getInstance().deleteTheater(adminTheaterDto);
		return result;
	}

	public AdminTheaterDto findupdateTheater(int tid) {
		AdminTheaterDto adminTheaterDto = AdminTheaterDao.getInstance().findupdateTheater(tid);
		return adminTheaterDto;
	}
	public AdminTheaterDto finddeleteTheater(int tid) {
		AdminTheaterDto adminTheaterDto = AdminTheaterDao.getInstance().finddeleteTheater(tid);
		return adminTheaterDto;
	}
	public AdminTheaterDto findPrintDetailTheater(int tid) {
		AdminTheaterDto adminTheaterDto = AdminTheaterDao.getInstance().findPrintDetailTheater(tid);
		return adminTheaterDto;
	}

}
