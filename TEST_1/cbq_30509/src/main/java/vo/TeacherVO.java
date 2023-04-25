package vo;

public class TeacherVO {
	private String teacher_code;
	private String class_name;
	private String teacher_name;
	private Integer class_price;
	private String teach_regist_date;
	
	public TeacherVO() {
		// TODO Auto-generated constructor stub
	}

	public TeacherVO(String teacher_code, String class_name, String teacher_name, Integer class_price,
			String teach_regist_date) {
		super();
		this.teacher_code = teacher_code;
		this.class_name = class_name;
		this.teacher_name = teacher_name;
		this.class_price = class_price;
		this.teach_regist_date = teach_regist_date;
	}

	public String getTeacher_code() {
		return teacher_code;
	}

	public void setTeacher_code(String teacher_code) {
		this.teacher_code = teacher_code;
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

	public Integer getClass_price() {
		return class_price;
	}

	public void setClass_price(Integer class_price) {
		this.class_price = class_price;
	}

	public String getTeach_regist_date() {
		return teach_regist_date;
	}

	public void setTeach_regist_date(String teach_regist_date) {
		this.teach_regist_date = teach_regist_date;
	}
}