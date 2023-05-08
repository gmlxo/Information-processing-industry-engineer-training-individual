package vo;

public class bshopJoinVO {
	private String telno;
	private String visitdate;
	private String vissittime;
	private String site;
	private String shopname;
	private String shoptelno;
	
	public bshopJoinVO() {
		// TODO Auto-generated constructor stub
	}

	public bshopJoinVO(String visitdate, String vissittime, String site, String shopname, String shoptelno) {
		super();
		this.visitdate = visitdate;
		this.vissittime = vissittime;
		this.site = site;
		this.shopname = shopname;
		this.shoptelno = shoptelno;
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

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getShoptelno() {
		return shoptelno;
	}

	public void setShoptelno(String shoptelno) {
		this.shoptelno = shoptelno;
	}
}
