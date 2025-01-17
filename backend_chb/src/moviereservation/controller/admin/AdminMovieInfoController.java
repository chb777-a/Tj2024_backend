package moviereservation.controller.admin;

import java.util.ArrayList;

import moviereservation.model.dao.admin.AdminMovieInfoDao;
import moviereservation.model.dto.admin.AdminMovieInfoDto;

public class AdminMovieInfoController {
	private static AdminMovieInfoController instance = new AdminMovieInfoController();
	private AdminMovieInfoController() {}
	public static AdminMovieInfoController getInstance() {
		return instance;
	}
	public ArrayList<AdminMovieInfoDto> movieInfoShow() {
		ArrayList<AdminMovieInfoDto> show = AdminMovieInfoDao.getInstance().movieInfoShow();
		return show;
	}
	public boolean updateByNum(AdminMovieInfoDto adminMovieInfoDto) {
		return AdminMovieInfoDao.getInstance().updateByNum(adminMovieInfoDto);
	}
	public boolean deleteByNum(int movieId) {
		return AdminMovieInfoDao.getInstance().deleteByNum(movieId);
	}
}
