package vo;

public class empVO {
	private String emp_no;
	private String emp_name;
	private String dept_code;
	private String hire_date;
	private String job;
	private int salary;
	
	public empVO() {
		// TODO Auto-generated constructor stub
	}

	public empVO(String emp_no, String emp_name, String dept_code, String hire_date, String job, int salary) {
		super();
		this.emp_no = emp_no;
		this.emp_name = emp_name;
		this.dept_code = dept_code;
		this.hire_date = hire_date;
		this.job = job;
		this.salary = salary;
	}

	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getDept_code() {
		return dept_code;
	}

	public void setDept_code(String dept_code) {
		this.dept_code = dept_code;
	}

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
