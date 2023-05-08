package vo;

public class testJoinVO {
	private String testno;
	private String name;
	private String jumin;
	private String man;
	private String city;
	private String telno;
	private String testresult;
	
	public testJoinVO() {
		// TODO Auto-generated constructor stub
	}
	
	public testJoinVO(String testno, String name, String jumin, String man, String city, String telno,
			String testresult) {
		super();
		this.testno = testno;
		this.name = name;
		this.jumin = jumin;
		this.man = man;
		this.city = city;
		this.telno = telno;
		this.testresult = testresult;
	}
	
	public String getTestno() {
		return testno;
	}
	public void setTestno(String testno) {
		this.testno = testno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getMan() {
		return man;
	}
	public void setMan(String man) {
		this.man = man;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getTestresult() {
		return testresult;
	}
	public void setTestresult(String testresult) {
		this.testresult = testresult;
	}
	
	
}
