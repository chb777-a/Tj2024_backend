package moviereservation.model.dto.member;

public class MemberDto {
	private int memberId;
	private String mid;
	private String mpw;
	private String mname;
	private String mbirth;
	public MemberDto() {}
	public MemberDto(int memberId, String mid, String mpw, String mname, String mbirth) {
		super();
		this.memberId = memberId;
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mbirth = mbirth;
	}
	
	public MemberDto(String mid, String mpw, String mname, String mbirth) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mbirth = mbirth;
	}
	@Override
	public String toString() {
		return "MemberDto [memberId=" + memberId + ", mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mbirth="
				+ mbirth + "]";
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMbirth() {
		return mbirth;
	}
	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}
	
}
