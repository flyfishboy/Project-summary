package cn.keshe.entity;

public class Practice_work {
    private String m_id;
    private String m_title;
    private String m_content;
    private String m_date;
    private float m_grade;
    private String s_id;
    private  String t_id;
    public Practice_work() {
    }

    public Practice_work(String m_id, String m_title, String m_content, String m_date, float m_grade, String s_id, String t_id) {
        this.m_id = m_id;
        this.m_title = m_title;
        this.m_content = m_content;
        this.m_date = m_date;
        this.m_grade = m_grade;
        this.s_id = s_id;
        this.t_id = t_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getS_id() {
        return s_id;
    }

    public String getT_id() {
        return t_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public void setM_title(String m_title) {
        this.m_title = m_title;
    }

    public void setM_content(String m_content) {
        this.m_content = m_content;
    }

    public void setM_date(String m_date) {
        this.m_date = m_date;
    }

    public void setM_grade(float m_grade) {
        this.m_grade = m_grade;
    }

    public String getM_id() {
        return m_id;
    }

    public String getM_title() {
        return m_title;
    }

    public String getM_content() {
        return m_content;
    }

    public String getM_date() {
        return m_date;
    }

    public float getM_grade() {
        return m_grade;
    }
}
