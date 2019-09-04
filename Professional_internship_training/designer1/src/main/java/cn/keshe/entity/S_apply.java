package cn.keshe.entity;

public class S_apply {
    private String id;
    private String date;
    private String state;
    private String t_id;
    private String s_id;
    private String s_name;
    private String s_sex;
    private String s_class;
    private String s_profession;

    public S_apply() {
    }

    public S_apply(String id, String date, String state, String t_id, String s_id, String s_name, String s_sex, String s_class, String s_profession) {
        this.id = id;
        this.date = date;
        this.state = state;
        this.t_id = t_id;
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_sex = s_sex;
        this.s_class = s_class;
        this.s_profession = s_profession;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public void setS_class(String s_class) {
        this.s_class = s_class;
    }

    public void setS_profession(String s_profession) {
        this.s_profession = s_profession;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getState() {
        return state;
    }

    public String getT_id() {
        return t_id;
    }

    public String getS_id() {
        return s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public String getS_sex() {
        return s_sex;
    }

    public String getS_class() {
        return s_class;
    }

    public String getS_profession() {
        return s_profession;
    }
}
