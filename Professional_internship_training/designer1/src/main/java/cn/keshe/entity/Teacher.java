package cn.keshe.entity;

public class Teacher {
   private String  T_id;
  private String T_name;
  private  String T_password;
  private String T_sex;
  private  String T_birthday ;
  private  String T_profession;
  private String T_phone;
  private String  T_qq;

    public Teacher() {
    }

    public Teacher(String t_id, String t_name, String t_password, String t_sex, String t_birthday, String t_profession, String t_phone, String t_qq) {
        T_id = t_id;
        T_name = t_name;
        T_password = t_password;
        T_sex = t_sex;
        T_birthday = t_birthday;
        T_profession = t_profession;
        T_phone = t_phone;
        T_qq = t_qq;
    }

    public void setT_id(String t_id) {
        T_id = t_id;
    }

    public void setT_name(String t_name) {
        T_name = t_name;
    }

    public void setT_password(String t_password) {
        T_password = t_password;
    }

    public void setT_sex(String t_sex) {
        T_sex = t_sex;
    }

    public void setT_birthday(String t_birthday) {
        T_birthday = t_birthday;
    }

    public void setT_profession(String t_profession) {
        T_profession = t_profession;
    }

    public void setT_phone(String t_phone) {
        T_phone = t_phone;
    }

    public void setT_qq(String t_qq) {
        T_qq = t_qq;
    }

    public String getT_id() {
        return T_id;
    }

    public String getT_name() {
        return T_name;
    }

    public String getT_password() {
        return T_password;
    }

    public String getT_sex() {
        return T_sex;
    }

    public String getT_birthday() {
        return T_birthday;
    }

    public String getT_profession() {
        return T_profession;
    }

    public String getT_phone() {
        return T_phone;
    }

    public String getT_qq() {
        return T_qq;
    }
}
