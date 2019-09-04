package cn.keshe.dao;

import cn.keshe.entity.P_apply;
import cn.keshe.entity.Practice;
import cn.keshe.utils.JDBCHelper;

import javax.servlet.http.HttpServlet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class P_applyDao extends HttpServlet {
    String tableName = "p_apply";
    private ArrayList arraylist(ResultSet rs) {
        ArrayList<P_apply> listp=new ArrayList<>();
        P_apply E=null;
        if( rs != null ){
            try {
                while (rs.next()) {
                    E = new P_apply();
                    E.setId(rs.getString("id"));
                    E.setS_id(rs.getString("s_id"));
                    E.setS_name(rs.getString("s_name"));
                    E.setS_sex(rs.getString("s_sex"));
                    E.setDate(rs.getString("date"));
                    E.setState(rs.getString("state"));
                    E.setT_id(rs.getString("t_id"));
                    E.setP_bdate(rs.getString("p_bdate"));
                    E.setP_edate(rs.getString("p_edate"));
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
    /*标记已通过审核*/
    public boolean changeS(String id,String state){
        String SQL="update "+tableName+" set state= ?  where id= ?";
        boolean b=JDBCHelper.execute(SQL,state,id);
        return b;
    }
    /*教师查找自己所带学生的实习申请信息*/
    public ArrayList select(String t_id){
        ArrayList<Practice> list1=new ArrayList<>();
        String SQL="select * from p_apply where t_id=?";
        ResultSet rs = JDBCHelper.query( SQL,t_id );
        list1=arraylist(rs);
        return list1;
    }
    /*按id查找自己所带学生的实习申请信息*/
    public ArrayList selectone(String s_id){
        ArrayList<Practice> list1=new ArrayList<>();
        String SQL="select * from "+tableName+" where s_id like '%"+s_id+"%'";
        ResultSet rs = JDBCHelper.query( SQL );
        list1=arraylist(rs);
        return list1;
    }
    /*删除一条实习申请信息*/
    public boolean delete(String id) {
        String sql="delete from p_apply where id=?";
        boolean b=JDBCHelper.execute(sql,id);
        return b;
    }
      /*申请实习*/
    public static boolean  insert(P_apply a){

        String SQL = "insert into p_apply ( s_id,s_name,date,state,t_id,p_bdate,p_edate,p_type,p_unit,p_uphone,s_sex ) values ( ?,?,?,?,?,?,?,?,?,? ,?)";
        boolean b=JDBCHelper.execute( SQL ,a.getS_id(),a.getS_name(),a.getDate(),a.getState(),a.getT_id(),
                a.getP_bdate(),a.getP_edate(),a.getP_type(),a.getP_unit(),a.getP_uphone(),a.getS_sex()) ;
        return b;
    }

}
