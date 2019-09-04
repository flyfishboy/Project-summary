package cn.keshe.dao;

import cn.keshe.entity.file;
import cn.keshe.entity.position;
import cn.keshe.utils.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class positionDao {

    static String tableName = "position";

    private ArrayList arraylist(ResultSet rs) {
        ArrayList<position> listp=new ArrayList<>();
        position E=null;
        if( rs != null ){
            try {
                while (rs.next()) {
                    E = new position();
                    E.setN_id(rs.getString("n_id"));
                    E.setT_id(rs.getString("t_id"));
                    E.setD_name(rs.getString("d_name"));
                    E.setLon(rs.getString("lon"));
                    E.setLat(rs.getString("lat"));
                    listp.add(E);
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return listp;
    }


    /**老师查看自己的位置*/
    public ArrayList<position> tselectt(String t_id){
        ArrayList<position> list1=new ArrayList<>();
        String SQL="select * from position where t_id= ?";
        ResultSet rs = JDBCHelper.query( SQL ,t_id);
        list1=arraylist(rs);
        return list1;
    }

    /**老师查看自己的学生的单位*/
    public ArrayList<position> tselectu(String t_id){
        ArrayList<position> list1=new ArrayList<>();
        String SQL="select * from position where d_name= ?";
        ResultSet rs = JDBCHelper.query( SQL ,t_id);
        list1=arraylist(rs);
        return list1;
    }

    /**
     * 插入数据
     * @param
     * @return
     */
    public  boolean  insert(String w,String si,String ti){
        String SQL = " insert into position (d_name,lon,lat) values (?,?,?)";
        boolean b=JDBCHelper.execute( SQL,w,si,ti) ;
        return b;
    }

    public  boolean  insert1(String t,String si,String ti){
        String SQL = " insert into position (t_id,lon,lat) values (?,?,?)";
        boolean b=JDBCHelper.execute( SQL,t,si,ti) ;
        return b;
    }
    /**删除一条单位数据**/
    public boolean deleteu(String id){
        String SQL="delete from "+tableName+" where d_name= ? ";
        boolean b=JDBCHelper.execute(SQL,id);
        return b;
    }

    /**删除一条老师数据**/
    public boolean deletet(String id){
        String SQL="delete from "+tableName+" where t_id= ? ";
        boolean b=JDBCHelper.execute(SQL,id);
        return b;
    }
}
