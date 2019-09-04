package cn.keshe.dao;

;
import cn.keshe.entity.S_apply;
import cn.keshe.utils.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class S_applyDao {
    static String tableName = "s_apply";
    /**
     * 插入数据
     * @param
     * @return
     */
    public  boolean  insert(String date,String state,String t_id,String s_id,String s_name,String s_sex,String s_class,String s_profession){
        String SQL = "insert into " +tableName + "(date,state,t_id,s_id,s_name,s_sex,s_class,s_profession,oid) values (?,?,?,?,?,?,?,?,?) " ;
        boolean b=JDBCHelper.execute( SQL,date,state,t_id,s_id,s_name,s_sex,s_class,s_profession) ;
        return b;
    }

    private ArrayList arraylist(ResultSet rs) {
        ArrayList<S_apply> listp=new ArrayList<>();
        S_apply E=null;
        if( rs != null ){
            try {
                while (rs.next()) {
                    E = new S_apply();
                    E.setId(rs.getString("id"));
                    E.setDate(rs.getString("date"));
                    E.setState(rs.getString("state"));
                    E.setT_id(rs.getString("t_id"));
                    E.setS_id(rs.getString(" s_id"));
                    E.setS_name(rs.getString("s_name"));
                    E.setS_sex(rs.getString("s_sex"));
                    E.setS_class(rs.getString("s_class"));
                    E.setS_profession(rs.getString("s_profession"));
                    listp.add(E);
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return listp;
    }

    /*教师查找自己所带学生的信息修改申请*/
    public ArrayList select(String t_id){
        ArrayList<S_apply> list1=new ArrayList<>();
        String SQL="select * from S_apply where t_id=?";
        ResultSet rs = JDBCHelper.query( SQL,t_id );
        list1=arraylist(rs);
        return list1;
    }

    /*删除一条信息修改申请*/
    public boolean delete(String id) {
        String sql="delete from S_apply where id=?";
        boolean b=JDBCHelper.execute(sql,id);
        return b;
    }
}
