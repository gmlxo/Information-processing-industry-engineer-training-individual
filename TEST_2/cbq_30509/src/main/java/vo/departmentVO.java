package vo;

public class departmentVO {
	private String dept_code;
	private String dept_name;
	private String location;

	public departmentVO() {
		// TODO Auto-generated constructor stub
	}

	public departmentVO(String dept_code, String dept_name, String location) {
		super();
		this.dept_code = dept_code;
		this.dept_name = dept_name;
		this.location = location;
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
}
