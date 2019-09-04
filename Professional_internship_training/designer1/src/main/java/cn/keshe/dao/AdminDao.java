package cn.keshe.dao;

import cn.keshe.entity.Admin;
import cn.keshe.utils.JDBCHelper;
import cn.keshe.utils.StringHelper;

import javax.servlet.http.HttpServlet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDao extends HttpServlet {
    String tableName = "t_admin";

    public boolean alterpassword(String username,String password){
        password=StringHelper.encrypt(password);
        String SQL="update"+tableName+"set password= ? where A_id= ?";
        boolean b=JDBCHelper.execute(SQL,password,username);
        return b;
    }


    public Admin loadByUsername(String A_id ){
        // 利用 jdbc 访问数据库
        String SQL = "select *  from "+tableName+" where A_id=? " ;
        ResultSet rs = JDBCHelper.query( SQL , A_id ) ;
        Admin  a = wrap(rs ) ;
        return a ;
    }
    /**
     * 插入数据
     * @param
     * @return
     */
    //管理员添加语句//
    public static boolean  insert(Admin a){
        String tableName = "t_admin";
        String SQL = "insert into " +tableName + " values (?,?,?,?) " ;
        boolean b=JDBCHelper.execute( SQL ,a.getA_id(),a.getA_name(),a.getA_password(),a.getA_sex()) ;
        return b;
    }
    //管理员删除数据//
    public boolean delete(String a_id){
        String SQL="DELETE from "+tableName+ " where a_id=?";
        boolean b=JDBCHelper.execute(SQL,a_id);
        return b;
    }
    //管理员修改姓名和性别数据//
    public boolean update(String a_id,String na_name, String na_sex) {
        String sql="UPDATE "+tableName+" SET a_name =? ,a_sex=?  WHERE a_id =?";
        boolean b=JDBCHelper.execute(sql,na_name,na_sex,a_id);
        return b;
    }

    //管理员修改个人密码//
    public boolean update1(String a_id,String na_password) {
        String sql="UPDATE "+tableName+" SET  a_password =?   WHERE a_id =?";
        boolean b=JDBCHelper.execute(sql,na_password,a_id);
        return b;
    }

    //超级管理员修改管理员信息//
    public boolean update2(String a_id,String na_id,String na_name,String na_password,String na_sex ) {
        String sql="UPDATE "+tableName+" SET  a_id =? ,a_name =?,a_password =? , a_sex =?  WHERE a_id =?";
        boolean b=JDBCHelper.execute(sql,na_id,na_name,na_password,na_sex,a_id);
        return b;
    }

    private Admin wrap (ResultSet rs ){
        Admin t = null ;
        if( rs != null ){
            try {
                while (rs.next()) {
                    t = new Admin();
                    t.setA_id(rs.getString("a_id"));
                    t.setA_name(rs.getString("a_name"));
                    t.setA_password(rs.getString("a_password"));
                    t.setA_sex(rs.getString("a_sex"));
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return t;
    }
}