package webadv.s162042_16_19_23_27.entity;

public class grade_27 {
	private String s_id;
	private String c_id;
	private String sumgrade;
	private String c_name;
	private String t_name;
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getSumgrade() {
		return sumgrade;
	}
	public void setSumgrade(String sumgrade) {
		this.sumgrade = sumgrade;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	
	public String[] getStringlistname() {
		String[] x= {"课程名称","教师","成绩"};
		return x;
	}
	public String[] getStringlist() {
		String[] x= {c_name,t_name,sumgrade};
		return x;
	}
	
}
