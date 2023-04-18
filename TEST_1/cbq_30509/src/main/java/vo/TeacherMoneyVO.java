package vo;

public class TeacherMoneyVO {
	private String teacher_code;
	private String teacher_name;
	private String class_name;
	private int tuition;
	
	public TeacherMoneyVO() {
		// TODO Auto-generated constructor stub
	}

	public TeacherMoneyVO(String teacher_code, String teacher_name, String class_name, int tuition) {
		super();
		this.teacher_code = teacher_code;
		this.teacher_name = teacher_name;
		this.class_name = class_name;
		this.tuition = tuition;
	}

	public String getTeacher_code() {
		return teacher_code;
	}

	public void setTeacher_code(String teacher_code) {
		this.teacher_code = teacher_code;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public int getTuition() {
		return tuition;
	}

	public void setTuition(int tuition) {
		this.tuition = tuition;
	}
}
