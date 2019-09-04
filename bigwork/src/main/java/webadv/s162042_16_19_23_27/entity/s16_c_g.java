package webadv.s162042_16_19_23_27.entity;

public class s16_c_g {
	private String t_id;
	private String c_id;
	private String c_name;
	private String avg_grade;
	private String g_qn;
	
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getAvg_grade() {
		return avg_grade;
	}
	public void setAvg_grade(String avg_grade) {
		this.avg_grade = avg_grade;
	}
	public String getG_qn() {
		return g_qn;
	}
	public void setG_qn(String g_qn) {
		this.g_qn = g_qn;
	}

	public String[] getStringlistname() {
		String[] x= {"教师工号","题号","课程号","课程名称","平均分"};
		return x;
	}
	public String[] getStringlist() {
		String[] x= {t_id,g_qn,c_id,c_name,avg_grade};
		return x;
	}
	
}
