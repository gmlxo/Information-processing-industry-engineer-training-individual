package vo;

public class workVO {
	private String emp_no;
	private int absence;
	private int night;
	private int holiday;
	private int business_trip;
	
	public workVO() {
		// TODO Auto-generated constructor stub
	}

	public workVO(String emp_no, int absence, int night, int holiday, int business_trip) {
		super();
		this.emp_no = emp_no;
		this.absence = absence;
		this.night = night;
		this.holiday = holiday;
		this.business_trip = business_trip;
	}

	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}

	public int getAbsence() {
		return absence;
	}

	public void setAbsence(int absence) {
		this.absence = absence;
	}

	public int getNight() {
		return night;
	}

	public void setNight(int night) {
		this.night = night;
	}

	public int getHoliday() {
		return holiday;
	}

	public void setHoliday(int holiday) {
		this.holiday = holiday;
	}

	public int getBusiness_trip() {
		return business_trip;
	}

	public void setBusiness_trip(int business_trip) {
		this.business_trip = business_trip;
	}
}
