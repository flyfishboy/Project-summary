package cn.keshe.dao;


import cn.keshe.entity.Practice_work;
import cn.keshe.entity.Student;
import cn.keshe.utils.JDBCHelper;
import cn.keshe.utils.StringHelper;

import javax.servlet.http.HttpServlet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao extends HttpServlet {
   static String tableName = "student";

    public boolean alterpassword(String id,String password){

        String SQL="update "+tableName+" set s_password = ? where s_id=?";
        boolean b=JDBCHelper.execute(SQL,password,id);
        return b;
    }

    public Student loadByUsername(String S_id){
        // 利用 jdbc 访问数据库
        String SQL = "select *  from "+tableName+" where s_id=? " ;
        ResultSet rs = JDBCHelper.query( SQL ,S_id ) ;
        Student  s = wrap(rs ) ;
        return s ;
    }

    /**
     * 插入数据
     * @param
     * @return
     */
    public  boolean  insert(Student s){
        String SQL = "insert into " +tableName + " values (?,?,?,?,?,?,?,?,?,?) " ;
        boolean b=JDBCHelper.execute( SQL,s.getS_id(),s.getS_name(),s.getS_password(),s.getS_sex(),s.getS_birthday(),s.getS_class(),s.getS_profession(),s.getS_phone(),s.getS_qq(),s.getT_id()) ;
        return b;
    }

    /**删除学生账号**/
    public boolean delete(String id){
        String SQL="delete from "+tableName+" where s_id= ? ";
        boolean b=JDBCHelper.execute(SQL,id);
        return b;
    }
    /**学生修改个人账号部分信息**///学生学号 密码     出生日期      电话      QQ
    public boolean change(String id,String bir,String tel,String qq){
        String SQL="update "+tableName+" set  s_birthday=? , s_phone=? , s_qq= ?  where s_id= ?";
        boolean b=JDBCHelper.execute(SQL,bir,tel,qq,id);
        return b;
    }
    /**其他人修改学生账号部分信息**/
    //                             学生学号    姓名      密码       性别      出生日期      班级        专业      电话         QQ
    public boolean changemore(String id,String name,String psd,String sex,String bir,String cla,String pro,String tel,String qq,String old){
        String SQL="update "+tableName+" set s_id= ? ,s_name= ? ,s_password= ? ,s_sex= ? , s_birthday= ? ,s_class= ? ,s_profession= ? , s_phone= ? , s_qq= ?   where s_id = ? ";
        boolean b=JDBCHelper.execute(SQL,id, name, psd, sex, bir, cla, pro, tel, qq,old);
        return b;
    }
/*修改学生账号所有信息*/
    public boolean changeall(String id,String name,String psd,String sex,String bir,String cla,String pro,String tel,String qq,String t_id){
        String SQL="update "+tableName+" set s_id= ? ,s_name= ? ,s_password= ? ,s_sex= ? , s_birthday=? ,s_class= ? ,s_profession= ? , s_phone=? , s_qq= ? ,t_id=?   where s_id= ?";
        boolean b=JDBCHelper.execute(SQL,id, name, psd, sex, bir, cla, pro, tel, qq,t_id,id);
        return b;
    }
    private Student wrap (ResultSet rs ){
        Student s = null ;
        if( rs != null ){
            try {
                while (rs.next()) {
                    s = new Student();
                    s.setS_id(rs.getString("s_id"));
                    s.setS_name(rs.getString("s_name"));
                    s.setS_password(rs.getString("s_password"));
                    s.setS_sex(rs.getString("s_sex"));
                    s.setS_birthday(rs.getString("s_birthday"));
                    s.setS_class(rs.getString("s_class"));
                    s.setS_profession(rs.getString("s_profession"));
                    s.setS_phone(rs.getString("s_phone"));
                    s.setS_qq(rs.getString("s_qq"));
                    s.setT_id(rs.getString("t_id"));
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return s ;
    }

    private ArrayList arraylist(ResultSet rs) {
        ArrayList<Student> listp=new ArrayList<>();
        Student s=null;
        if( rs != null ){
            try {
                while (rs.next()) {

                    s = new Student();
                    s.setS_id(rs.getString("s_id"));
                    s.setS_name(rs.getString("s_name"));
                    s.setS_password(rs.getString("s_password"));
                    s.setS_sex(rs.getString("s_sex"));
                    s.setS_birthday(rs.getString("s_birthday"));
                    s.setS_class(rs.getString("s_class"));
                    s.setS_profession(rs.getString("s_profession"));
                    s.setS_phone(rs.getString("s_phone"));
                    s.setS_qq(rs.getString("s_qq"));
                    s.setT_id(rs.getString("t_id"));
                    listp.add(s);
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return listp;
    }

    /*查找学生信息*/
    public ArrayList select(String t_id){
        ArrayList<Student> list1=new ArrayList<>();
        String SQL="select * from "+tableName+" where t_id=?";
        ResultSet rs = JDBCHelper.query( SQL ,t_id);
        list1=arraylist(rs);
        return list1;
    }
}

