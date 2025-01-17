package moviereservation.model.dto.admin;

public class AdminTheaterDto {
	private int Tid;
	private int Tseat;
	private String Tscreen;

	public AdminTheaterDto() {}
	public AdminTheaterDto(int tid, int tseat, String tscreen) {
		Tid = tid;
		Tseat = tseat;
		Tscreen = tscreen;
	}
	public AdminTheaterDto(int tseat, String tscreen) {
	
		Tseat = tseat;
		Tscreen = tscreen;
	}


	@Override
	public String toString() {
		return "AdminTheaterDto [Tid=" + Tid + ", Tseat=" + Tseat + ", Tscreen=" + Tscreen + "]";
	}

	public int getTid() {
		return Tid;
	}

	public void setTid(int tid) {
		Tid = tid;
	}

	public int getTseat() {
		return Tseat;
	}

	public void setTseat(int tseat) {
		Tseat = tseat;
	}

	public String getTscreen() {
		return Tscreen;
	}

	public void setTscreen(String tscreen) {
		Tscreen = tscreen;
	}
	

}
