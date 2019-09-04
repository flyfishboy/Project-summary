package SA.database.dao;

import SA.database.entity.Pa_set;
import SA.database.entity.Stu_info;
import SA.database.utils.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class pa_setDao {
    String tablename="pa_set";
    //插入
    public boolean insertPs(Pa_set ps){
        String sql="insert into "+tablename+"(p_id,s_id,day_time,day_maxtime,day_timeran,remind) values (?,?,?,?,?,?)";
        boolean b=JDBCHelper.execute(sql,ps.getP_id(),ps.getS_id(),ps.getDay_time(),ps.getDay_maxtime(),ps.getDay_timeran(),ps.getRemind());
        return b;
    }
    //通过家长账号及学生账号修改某项数据
    public boolean updateOnePs(String p_id,String s_id,String name, String value){
        String sql="update "+tablename+" set "+name+"=? where p_id=? and s_id=?";
        boolean b=JDBCHelper.execute(sql,value,p_id,s_id);
        return b;
    }
    //根据s_id查询一个某个孩子的学习设置信息
    public Pa_set findPsById(String s_id){
        String sql="select * from "+tablename+" where s_id=?";
        ResultSet rs= JDBCHelper.query(sql,s_id);
        Pa_set ps=wrap(rs);
        return ps;
    }
    //将单个用户信息封装起来
    private Pa_set wrap(ResultSet rs){
        Pa_set ps = null ;
        if( rs != null ){
            try {
                while (rs.next()) {
                    ps = new Pa_set();
                    ps.setId(rs.getInt("id"));
                    ps.setP_id(rs.getString("p_id"));
                    ps.setS_id(rs.getString("s_id"));
                    ps.setDay_time(rs.getString("day_time"));
                    ps.setDay_maxtime(rs.getString("day_maxtime"));
                    ps.setDay_timeran(rs.getString("day_timeran"));
                    ps.setRemind(rs.getString("remind"));

                }
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return ps ;
    }


}
