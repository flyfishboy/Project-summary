package SA.database.dao;

import SA.database.entity.Stu_info;
import SA.database.utils.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Stu_infoDao {
    String tablename="stu_info";
    //插入
    public boolean insertStu(Stu_info stu){
        String sql="insert into "+tablename+" values (?,?,?,?,?,?,?,?,?,?)";
        boolean b=JDBCHelper.execute(sql,stu.getS_id(),stu.getS_password(),stu.getS_name(),stu.getS_sex(),stu.getS_grade(),stu.getAn_exp(),stu.getP_id(),stu.getP_ad(),stu.getDeg(),stu.getBack());
        return b;
    }
    //修改密码
    public boolean alterPassword(String s_id,String newPassword){
        String sql="update "+tablename+" set s_password=? where s_id=?";
        boolean b=JDBCHelper.execute(sql,newPassword,s_id);
        return b;
    }
    //通过id修改某些数据
    public boolean updateOne(String s_id,String name, String value){
        String sql="update "+tablename+" set "+name+"=? where s_id=?";
        boolean b=JDBCHelper.execute(sql,value,s_id);
        return b;
    }


    //根据s_id查询一个用户信息
    public Stu_info findUserById(String s_id){
        String sql="select * from "+tablename+" where s_id=?";
        ResultSet rs= JDBCHelper.query(sql,s_id);
        Stu_info stu=wrap(rs);
        return stu;
    }
    //将单个用户信息封装起来
    private Stu_info wrap(ResultSet rs){
        Stu_info stu = null ;
        if( rs != null ){
            try {
                while (rs.next()) {
                    stu = new Stu_info();
                    stu.setS_id(rs.getString("s_id"));
                    stu.setS_password(rs.getString("s_password"));
                    stu.setS_name(rs.getString("s_name"));
                    stu.setS_sex(rs.getString("s_sex"));
                    stu.setS_grade(rs.getString("s_grade"));
                    stu.setAn_exp(rs.getString("an_exp"));
                    stu.setP_id(rs.getString("p_id"));
                    stu.setP_ad(rs.getString("p_ad"));
                    stu.setDeg(rs.getString("deg"));
                    stu.setBack(rs.getString("back"));

                }
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return stu ;
    }

}
