package cn.keshe.dao;

import cn.keshe.entity.Teacher;
import cn.keshe.utils.JDBCHelper;
import cn.keshe.utils.StringHelper;

import javax.servlet.http.HttpServlet;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDao extends HttpServlet {
    String tableName = "teacher";

    public boolean alterpassword(String username,String password){
        password=StringHelper.encrypt(password);
        String SQL="update"+tableName+"set password= ? where T_id= ?";
        boolean b=JDBCHelper.execute(SQL,password,username);
        return b;
    }

    public Teacher loadByUsername(String S_id ){
        // 利用 jdbc 访问数据库
        String SQL = "select *  from "+tableName+" where t_id=? " ;
        ResultSet rs = JDBCHelper.query( SQL , S_id ) ;
        Teacher  t = wrap(rs ) ;
        return t ;
    }

    /*教师修改个人信息*/
    public boolean Tupdatemsg(String id,String nbird,String nprof,String npho,String nqq ) {
        String sql="UPDATE "+tableName+" SET t_birthday =?, t_profession =?,t_phone=? ,t_qq =? WHERE t_id =?";
        boolean b=JDBCHelper.execute(sql,nbird,nprof,npho,nqq,id);
        return b;
    }
    /*教师修改密码*/
    public boolean Tupdatepass(String id,String npasd) {
        String sql="UPDATE "+tableName+" SET  t_password =?  WHERE t_id =?";
        boolean b=JDBCHelper.execute(sql,npasd,id);
        return b;
    }
    /**
     * 插入数据
     * @param
     * @return
     */
//管理员添加教师数据//
    public static boolean  insert(Teacher t){
        String tableName = "teacher";
        String SQL = "insert into " +tableName + " values (?,?,?,?,?,?,?,?) " ;
        boolean b=JDBCHelper.execute( SQL ,t.getT_id(),t.getT_name(),t.getT_password(),t.getT_sex(),t.getT_birthday(),t.getT_profession(),t.getT_phone(),t.getT_qq()) ;
        return b;
    }

    //管理员Excel添加教师数据//
    public static boolean  insertExcel(String value){
        String tableName = "teacher";
        String SQL = "insert into " +tableName + " values ("+value+")" ;
        boolean b=JDBCHelper.execute( SQL ) ;
        return b;
    }

    //管理员删除教师数据//
    public boolean delete(String t_id){
        String SQL="delete from "+tableName+" where t_id=?";
        boolean b=JDBCHelper.execute(SQL,t_id);
        return b;
    }

    //管理员修改教师数据//
    public boolean update(String id,String nid,String nname,String npasd, String nsex,String nbird,String nprof,String npho,String nqq ) {
        String sql="UPDATE "+tableName+" SET t_id =?, t_name =?, t_password =? ,t_sex =? ,t_birthday =?, t_profession =?,t_phone=? ,t_qq =? WHERE t_id =?";
        boolean b=JDBCHelper.execute(sql,nid,nname,npasd,nsex,nbird,nprof,npho,nqq,id);
        return b;
    }
    private Teacher wrap (ResultSet rs ){
        Teacher t = null ;
        if( rs != null ){
            try {
                while (rs.next()) {
                    t = new Teacher();
                    t.setT_id(rs.getString("t_id"));
                    t.setT_name(rs.getString("t_name"));
                    t.setT_password(rs.getString("t_password"));
                    t.setT_sex(rs.getString("t_sex"));
                    t.setT_birthday(rs.getString("t_birthday"));
                    t.setT_profession(rs.getString("t_profession"));
                    t.setT_phone(rs.getString("t_phone"));
                    t.setT_qq(rs.getString("t_qq"));
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return t;
    }
}