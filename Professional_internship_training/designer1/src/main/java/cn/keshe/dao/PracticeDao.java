package cn.keshe.dao;

import cn.keshe.entity.Practice;
import cn.keshe.entity.Student;
import cn.keshe.utils.JDBCHelper;

import javax.servlet.http.HttpServlet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PracticeDao extends HttpServlet {
    String tableName = "practice";
    private ArrayList arraylist(ResultSet rs) {
        ArrayList<Practice> listp=new ArrayList<>();
        Practice E=null;
        if( rs != null ){
            try {
                while (rs.next()) {
                    E = new Practice();
                    E.setP_id(rs.getString("id"));
                    E.setS_id(rs.getString("s_id"));
                    E.setS_name(rs.getString("s_name"));
                    E.setS_sex(rs.getString("s_sex"));
                    E.setT_id(rs.getString("t_id"));
                    E.setP_bdata(rs.getString("p_bdate"));
                    E.setP_edata(rs.getString("p_edate"));
                    E.setP_type(rs.getString("p_type"));
                    E.setP_unit(rs.getString("p_unit"));
                    E.setP_uphone(rs.getString("p_uphone"));
                    listp.add(E);
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return listp;
    }

    /*教师查找自己所带学生的实习信息*/
    public ArrayList select(String t_id){
        ArrayList<Practice> list1=new ArrayList<>();
        String SQL="select * from practice where t_id=?";
        ResultSet rs = JDBCHelper.query( SQL,t_id );
        list1=arraylist(rs);
        return list1;
    }
    /*按姓名查找学生的实习信息*/
    public ArrayList selectone(String s_name){
        ArrayList<Practice> list1=new ArrayList<>();
        String SQL="select * from "+tableName+" where s_name like '%"+s_name+"%'";
        ResultSet rs = JDBCHelper.query( SQL );
        list1=arraylist(rs);
        return list1;
    }
    /*教师添加实习信息*/
    public  boolean  insert(Practice p){
        String SQL = "insert into " +tableName + " values (?,?,?,?,?,?,?,?,?,?) " ;
        boolean b=JDBCHelper.execute( SQL,p.getP_id(),p.getS_id(),p.getS_name(),p.getS_sex(),p.getP_bdata(),p.getP_edata(),p.getP_type(),p.getP_unit(),p.getP_uphone(),p.getT_id()) ;
        return b;
    }
/*删除一条实习信息*/
    public boolean delete(String id) {
        String sql="delete from "+tableName+" where id=? ";
        boolean b=JDBCHelper.execute(sql,id);
        return b;
    }
    /*删除该学生所有实习信息*/
    public boolean deleteS(String id) {
        String sql="delete from "+tableName+" where s_id=? ";
        boolean b=JDBCHelper.execute(sql,id);
        return b;
    }
    /*修改实习信息*/
   public boolean changeS(String s_id,String s_name,String s_sex,String old){
        String SQL="update "+tableName+" set s_id=?, s_name=? , s_sex= ?  where s_id= ?";
        boolean b=JDBCHelper.execute(SQL,s_id,s_name,s_sex,old);
        return b;
    }
    public boolean change(String p_id,String  bdata,String edate,String type,String unit,String uphone){
        String SQL="update "+tableName+" set  p_bdate=? , p_edate=? , p_type= ? , p_unit=? ,p_uphone=?  where id= ?";
        boolean b=JDBCHelper.execute(SQL,bdata,edate,type,unit,uphone,p_id);
        return b;
    }

}
