package vo;

public class depListVO {
	private String dept_code;
	private String dept_name;
	private String location;
	private String sum;
	private String salary;
	private String subang;
	private String allSUM;
	
	public depListVO() {
		// TODO Auto-generated constructor stub
	}

	public depListVO(String dept_code, String dept_name, String location, String sum, String salary, String subang,
			String allSUM) {
		super();
		this.dept_code = dept_code;
		this.dept_name = dept_name;
		this.location = location;
		this.sum = sum;
		this.salary = salary;
		this.subang = subang;
		this.allSUM = allSUM;
	}

	public String getDept_code() {
		return dept_code;
	}

	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getSubang() {
		return subang;
	}

	public void setSubang(String subang) {
		this.subang = subang;
	}

	public String getAllSUM() {
		return allSUM;
	}

	public void setAllSUM(String allSUM) {
		this.allSUM = allSUM;
	}
}
