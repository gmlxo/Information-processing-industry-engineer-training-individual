package vo;

public class visitVO {
	private String telno;
	private String visitdate;
	private String vissittime;
	private String shopno;
	
	public visitVO() {
		// TODO Auto-generated constructor stub
	}

	public visitVO(String telno, String visitdate, String vissittime, String shopno) {
		super();
		this.telno = telno;
		this.visitdate = visitdate;
		this.vissittime = vissittime;
		this.shopno = shopno;
	}

	public String getTelno() {
		return telno;
	}

	public void setTelno(String telno) {
		this.telno = telno;
	}

	public String getVisitdate() {
		return visitdate;
	}

	public void setVisitdate(String visitdate) {
		this.visitdate = visitdate;
	}

	public String getVissittime() {
		return vissittime;
	}

	public void setVissittime(String vissittime) {
		this.vissittime = vissittime;
	}

	public String getShopno() {
		return shopno;
	}

	public void setShopno(String shopno) {
		this.shopno = shopno;
	}
}
