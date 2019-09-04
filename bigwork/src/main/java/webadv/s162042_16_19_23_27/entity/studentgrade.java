package webadv.s162042_16_19_23_27.entity;

public class studentgrade {
	private String s_id;
	private String s_name;
	private int a_sum;
	private int a_absence;
	private double sumgrade;

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_id() {
		return s_id;
	}

	public void setS_id(String s_id) {
		this.s_id = s_id;
	}

	public int getA_sum() {
		return a_sum;
	}

	public void setA_sum(int a_sum) {
		this.a_sum = a_sum;
	}

	public int getA_absence() {
		return a_absence;
	}

	public void setA_absence(int a_absence) {
		this.a_absence = a_absence;
	}

	public double getSumgrade() {
		return sumgrade;
	}

	public void setSumgrade(double sumgrade) {
		this.sumgrade = sumgrade;
	}

	public String[] getStringlistname() {
		String[] x = { "学生学号","学生姓名","总考勤次数","缺勤次数","课程成绩" };
		return x;
	}

	public String[] getStringlist() {
		String[] x = { s_id, s_name, a_sum+"", a_absence+"", sumgrade+"" };
		return x;
	}

}
