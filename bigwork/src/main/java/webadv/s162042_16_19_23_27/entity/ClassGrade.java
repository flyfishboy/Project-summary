package webadv.s162042_16_19_23_27.entity;

public class ClassGrade {
	private String s_class;
	private double sum_class_grade;
	private int sum_class_student;
	public String getS_class() {
		return s_class;
	}
	public void setS_class(String s_class) {
		this.s_class = s_class;
	}
	public double getSum_class_grade() {
		return sum_class_grade;
	}
	public void setSum_class_grade(double sum_class_grade) {
		this.sum_class_grade = sum_class_grade;
	}
	public int getSum_class_student() {
		return sum_class_student;
	}
	public void setSum_class_student(int sum_class_student) {
		this.sum_class_student = sum_class_student;
	}
	
	public String[] getStringlistname() {
		String[] x = { "班级号","班级总人数","班级平均分" };
		return x;
	}

	public String[] getStringlist() {
		String[] x = { s_class, sum_class_grade+"", sum_class_student+""};
		return x;
	}
	
}
