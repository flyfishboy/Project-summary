package com.nchu.entity;

public class Employment {
    private String id;
    private String jobname;
    private String img;
    private String username;
    private String pnumber;
    private String introduction;
    private String salary;

    public String getJobname() {
        return jobname;
    }
    public void setJobname(String jobname) {
        this.jobname = jobname;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String slary) {
        this.salary = slary;
    }
}
