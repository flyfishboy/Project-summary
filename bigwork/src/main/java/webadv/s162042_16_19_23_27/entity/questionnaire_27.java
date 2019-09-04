package webadv.s162042_16_19_23_27.entity;

import java.security.KeyStore.PrivateKeyEntry;

import javax.management.loading.PrivateMLet;

public class questionnaire_27 {
	private String s_id;
	private String c_id;
	private String t_id;
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	private String q_time;
	private String q_content1;
	private String q_answer1;
	private String q_content2;
	private String q_answer2;
	private String q_content3;
	private String q_answer3;
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
	public String getQ_time() {
		return q_time;
	}
	public void setQ_time(String q_time) {
		this.q_time = q_time;
	}
	public String getQ_content1() {
		return q_content1;
	}
	public void setQ_content1(String q_content1) {
		this.q_content1 = q_content1;
	}
	public String getQ_answer1() {
		return q_answer1;
	}
	public void setQ_answer1(String q_answer1) {
		this.q_answer1 = q_answer1;
	}
	public String getQ_content2() {
		return q_content2;
	}
	public void setQ_content2(String q_content2) {
		this.q_content2 = q_content2;
	}
	public String getQ_answer2() {
		return q_answer2;
	}
	public void setQ_answer2(String q_answer2) {
		this.q_answer2 = q_answer2;
	}
	public String getQ_content3() {
		return q_content3;
	}
	public void setQ_content3(String q_content3) {
		this.q_content3 = q_content3;
	}
	public String getQ_answer3() {
		return q_answer3;
	}
	public void setQ_answer3(String q_answer3) {
		this.q_answer3 = q_answer3;
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
		String[] x= {"问卷课程名称","问卷问题1","问卷回答1","问卷问题2","问卷回答2","问卷问题3","问卷回答3","问卷发布时间","答卷人学号"};
		return x;
	}
	public String[] getStringlist() {
		String[] x= {c_name,q_content1,q_answer1,q_content2,q_answer2,q_content3,q_answer3,q_time,s_id};
		return x;
	}
	
}
