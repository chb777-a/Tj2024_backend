package moviereservation.controller.admin;

import java.util.ArrayList;

import moviereservation.model.dao.admin.AdminMovieTimeDao;
import moviereservation.model.dto.admin.AdminMovieTimeDto;

public class AdminMovieTimeController {
	private static AdminMovieTimeController instance = new AdminMovieTimeController();
	private AdminMovieTimeController() {}
	public static AdminMovieTimeController getInstance() {return instance;}
	public ArrayList<AdminMovieTimeDto> movieTimeShow() {
		ArrayList<AdminMovieTimeDto> show = AdminMovieTimeDao.getInstance().movieTimeShow();
		return show;
	}
	public boolean deleteByNum(int timepk) {
		return AdminMovieTimeDao.getInstance().deleteByNum(timepk);
	}
	public boolean updateByNum(AdminMovieTimeDto adminMovieTimeDto) {
	    return AdminMovieTimeDao.getInstance().updateByNum(adminMovieTimeDto);
	}
	
}
