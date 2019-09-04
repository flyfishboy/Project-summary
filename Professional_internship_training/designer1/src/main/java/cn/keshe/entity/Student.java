package cn.keshe.entity;

public class Student {
    private String S_id;
    private String S_name;
    private String S_password;
    private String S_sex;
    private String S_birthday;
    private String S_class;
    private String S_profession;
    private String S_phone;
    private String S_qq;
    private String T_id;
    private String T_name;

    public Student() {
    }

    public Student(String s_id, String s_name, String s_password, String s_sex, String s_birthday, String s_class, String s_profession, String s_phone, String s_qq, String t_id, String t_name) {
        S_id = s_id;
        S_name = s_name;
        S_password = s_password;
        S_sex = s_sex;
        S_birthday = s_birthday;
        S_class = s_class;
        S_profession = s_profession;
        S_phone = s_phone;
        S_qq = s_qq;
        T_id = t_id;
        T_name = t_name;
    }

    public void setS_id(String s_id) {
        S_id = s_id;
    }

    public void setS_name(String s_name) {
        S_name = s_name;
    }

    public void setS_password(String s_password) {
        S_password = s_password;
    }

    public void setS_sex(String s_sex) {
        S_sex = s_sex;
    }

    public void setS_birthday(String s_birthday) {
        S_birthday = s_birthday;
    }

    public void setS_class(String s_class) {
        S_class = s_class;
    }

    public void setS_profession(String s_profession) {
        S_profession = s_profession;
    }

    public void setS_phone(String s_phone) {
        S_phone = s_phone;
    }

    public void setS_qq(String s_qq) {
        S_qq = s_qq;
    }

    public void setT_id(String t_id) {
        T_id = t_id;
    }


    public String getS_id() {
        return S_id;
    }

    public String getS_name() {
        return S_name;
    }

    public String getS_password() {
        return S_password;
    }

    public String getS_sex() {
        return S_sex;
    }

    public String getS_birthday() {
        return S_birthday;
    }

    public String getS_class() {
        return S_class;
    }

    public String getS_profession() {
        return S_profession;
    }

    public String getS_phone() {
        return S_phone;
    }

    public String getS_qq() {
        return S_qq;
    }

    public String getT_id() {
        return T_id;
    }

}
