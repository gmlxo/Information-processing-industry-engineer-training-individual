package vo;

public class userVO {
	private String regist_month;
	private String c_no;
	private String c_name;
	private String class_name;
	private String teacher_name;
	private String class_area;
	private int tuition;
	
	public userVO() {
		// TODO Auto-generated constructor stub
	}

	public userVO(String regist_month, String c_no, String c_name, String class_name, String teacher_name,
			String class_area, int tuition) {
		super();
		this.regist_month = regist_month;
		this.c_no = c_no;
		this.c_name = c_name;
		this.class_name = class_name;
		this.teacher_name = teacher_name;
		this.class_area = class_area;
		this.tuition = tuition;
	}

	public String getRegist_month() {
		return regist_month;
	}

	public void setRegist_month(String regist_month) {
		this.regist_month = regist_month;
	}

	public String getC_no() {
		return c_no;
	}

	public void setC_no(String c_no) {
		this.c_no = c_no;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getClass_area() {
		return class_area;
	}

	public void setClass_area(String class_area) {
		this.class_area = class_area;
	}

	public int getTuition() {
		return tuition;
	}

	public void setTuition(int tuition) {
		this.tuition = tuition;
	}
}
