package moviereservation.controller.admin;

import java.util.ArrayList;

import moviereservation.model.dao.admin.AdminPrintUserDao;
import moviereservation.model.dto.admin.AdminPrintUserDto;


public class AdminPrintUserController {
	private AdminPrintUserController() {}
	private static AdminPrintUserController instance = new AdminPrintUserController();
	public static AdminPrintUserController getInstance() {
		return instance;
	}
	public ArrayList<AdminPrintUserDto> printUser() {
		ArrayList<AdminPrintUserDto> result = 
				AdminPrintUserDao.getInstance().printUser();
		return result;
	}


}
