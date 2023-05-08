package vo;

public class bshopJoinListVO2 {
	private String shopno;
	private String shopname;
	private int num;
	
	public bshopJoinListVO2() {
		// TODO Auto-generated constructor stub
	}

	public bshopJoinListVO2(String shopno, String shopname, int num) {
		super();
		this.shopno = shopno;
		this.shopname = shopname;
		this.num = num;
	}

	public String getShopno() {
		return shopno;
	}

	public void setShopno(String shopno) {
		this.shopno = shopno;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
