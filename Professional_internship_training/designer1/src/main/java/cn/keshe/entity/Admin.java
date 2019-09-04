package cn.keshe.entity;

public class Admin {
    private String  A_id;
    private String  A_name;
    private String  A_password;
    private String  A_sex;

    public Admin() {
    }

    public Admin(String a_id, String a_name, String a_password, String a_sex) {
        A_id = a_id;
        A_name = a_name;
        A_password = a_password;
        A_sex = a_sex;
    }
    public String getA_id() {
        return A_id;
    }

    public String getA_name() {
        return A_name;
    }

    public String getA_password() {
        return A_password;
    }

    public String getA_sex() {
        return A_sex;
    }

    public void setA_id(String a_id) {
        A_id = a_id;
    }

    public void setA_name(String a_name) {
        A_name = a_name;
    }

    public void setA_password(String a_password) {
        A_password = a_password;
    }

    public void setA_sex(String a_sex) {
        A_sex = a_sex;
    }
}
