package moviereservation.model.dto.admin;

public class AdminDto {
	private int adminId;
	private String aid;
	private String apw;
	private String aname;
	
	public AdminDto() {}
	
	public AdminDto(int adminId, String aid, String apw, String aname) {
		this.adminId = adminId;
		this.aid = aid;
		this.apw = apw;
		this.aname = aname;
	}
	public AdminDto(String aid, String apw, String aname) {
		this.aid = aid;
		this.apw = apw;
		this.aname = aname;
	}

	@Override
	public String toString() {
		return "AdminDto [adminId=" + adminId + ", aid=" + aid + ", apw=" + apw + ", aname=" + aname + "]";
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getApw() {
		return apw;
	}

	public void setApw(String apw) {
		this.apw = apw;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}
	
	
	

}
