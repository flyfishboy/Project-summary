package cn.keshe.entity;

public class Practice {
    private String p_id;
    private String s_id;
    private String s_name;
    private String s_sex;
    private String t_id;
    private String p_bdata;
    private String p_edata;
    private String p_type;
    private String p_unit;
    private String p_uphone;

    public Practice() {
    }

    public Practice(String p_id, String s_id, String s_name, String s_sex, String t_id, String p_bdata, String p_edata, String p_type, String p_unit, String p_uphone) {
        this.p_id = p_id;
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_sex = s_sex;
        this.t_id = t_id;
        this.p_bdata = p_bdata;
        this.p_edata = p_edata;
        this.p_type = p_type;
        this.p_unit = p_unit;
        this.p_uphone = p_uphone;
    }

    public void setT_id(String t_id) {
        this.t_id = t_id;
    }

    public String getT_id() {
        return t_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
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

    public void setP_bdata(String p_bdata) {
        this.p_bdata = p_bdata;
    }

    public void setP_edata(String p_edata) {
        this.p_edata = p_edata;
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

    public String getP_id() {
        return p_id;
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

    public String getP_bdata() {
        return p_bdata;
    }

    public String getP_edata() {
        return p_edata;
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
