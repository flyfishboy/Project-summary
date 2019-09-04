package cn.keshe.entity;

public class P_apply {
    private String id;
    private String s_id;
    private String s_name;
    private String date;
    private String state;
    private String t_id;
    private String p_bdate;
    private String p_edate;
    private String p_type;
    private String p_unit;
    private String p_uphone;
    private  String s_sex;
    public P_apply() {
    }

    public P_apply(String id, String s_id, String s_name, String s_sex,String date, String state, String t_id, String p_bdate, String p_edate, String p_type, String p_unit, String p_uphone) {
        this.id = id;
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_sex=s_sex;
        this.date = date;
        this.state = state;
        this.t_id = t_id;
        this.p_bdate = p_bdate;
        this.p_edate = p_edate;
        this.p_type = p_type;
        this.p_unit = p_unit;
        this.p_uphone = p_uphone;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
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

    public void setP_bdate(String p_bdate) {
        this.p_bdate = p_bdate;
    }

    public void setP_edate(String p_edate) {
        this.p_edate = p_edate;
    }

    public void setP_type(String p_type) {
        this.p_type = p_type;
    }

    public void setP_unit(String p_unit) {
        this.p_unit = p_unit;
    }

    public void setP_uphone(String p_uphone) {
        this.p_uphone = p_uphone;
    }

    public String getId() {
        return id;
    }

    public String getS_id() {
        return s_id;
    }

    public String getS_name() {
        return s_name;
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

    public String getP_bdate() {
        return p_bdate;
    }

    public String getP_edate() {
        return p_edate;
    }

    public String getP_type() {
        return p_type;
    }

    public String getP_unit() {
        return p_unit;
    }

    public String getP_uphone() {
        return p_uphone;
    }
}
