package SA.database.dao;

import SA.database.entity.Fight;
import SA.database.utils.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FightDao {
    String tablename="fight";
    //插入
    public boolean insertFit(Fight fight){
        String sql="insert into "+tablename+"(f_king_id,f_king_ip,f_king_ok,f_king_p1,f_king_p2) values(?,?,?,?,?)";
        boolean b=JDBCHelper.execute(sql,fight.getF_king_id(),fight.getF_king_ip(),fight.getF_king_ok(),fight.getF_king_p1(),fight.getF_king_p2());
        return b;
    }
    //查询表中所有信息
    public ArrayList<Fight> findAll() throws SQLException {
        String sql="select * from "+tablename;
        ResultSet rs=JDBCHelper.query(sql);
        ArrayList<Fight> list=arraylist(rs);
        return list;
    }
    //根据f_king_id和f_king_ok查询房主信息
    public Fight findip(String f_king_id,String f_king_ok) throws SQLException {
        String sql="select * from "+tablename+" where f_king_id=? and f_king_ok=?";
        ResultSet rs=JDBCHelper.query(sql,f_king_id,f_king_ok);
        Fight fight=wrap(rs);
        return fight;
    }
    //根据f_id查询房主信息
    public Fight findff(int f_id) throws SQLException {
        String sql="select * from "+tablename+" where f_id=?";
        ResultSet rs=JDBCHelper.query(sql,f_id);
        Fight fight=wrap(rs);
        return fight;
    }
    public Fight wrap(ResultSet rs) throws SQLException {
        Fight fight=null;
        if(rs!=null){
            while(rs.next()){
                fight=new Fight();
                fight.setF_id(rs.getInt("f_id"));
                fight.setF_king_id(rs.getString("f_king_id"));
                fight.setF_king_ip(rs.getString("f_king_ip"));
                fight.setF_king_ok(rs.getString("f_king_ok"));
                fight.setF_king_p1(rs.getString("f_king_p1"));
                fight.setF_king_p2(rs.getString("f_king_p2"));
            }
        }
        return fight;
    }

    //封装
    private ArrayList<Fight> arraylist(ResultSet rs) throws SQLException {
        ArrayList<Fight> list=new ArrayList<>();
        Fight fight=null;
        if(rs!=null){
            while(rs.next()){
                fight=new Fight();
                fight.setF_id(rs.getInt("f_id"));
                fight.setF_king_id(rs.getString("f_king_id"));
                fight.setF_king_ip(rs.getString("f_king_ip"));
                fight.setF_king_ok(rs.getString("f_king_ok"));
                fight.setF_king_p1(rs.getString("f_king_p1"));
                fight.setF_king_p2(rs.getString("f_king_p2"));
                list.add(fight);
            }
        }
        return list;
    }

    //删除
    public boolean deletefi(String f_king_id){
        String sql="delete from "+tablename+" where f_king_id=?";
        boolean b=JDBCHelper.execute(sql,f_king_id);
        return b;
    }
//通过id修改某些数据
public boolean updateOK(int f_id,String name, String value){
    String sql="update "+tablename+" set "+name+"=? where f_id=?";
    boolean b=JDBCHelper.execute(sql,value,f_id);
    return b;
}

}
