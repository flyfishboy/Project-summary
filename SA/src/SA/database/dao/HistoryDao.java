package SA.database.dao;

import SA.database.entity.History;
import SA.database.utils.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HistoryDao {
    String tablename="history";
//插入
    public boolean insertHis(History his){
        String sql="insert into "+tablename+"(s_id,his_bg_time,his_num,his_acc,his_spend,his_deg,his_type) values(?,?,?,?,?,?,?)";
        boolean b=JDBCHelper.execute(sql,his.getS_id(),his.getHis_bg_time(),his.getHis_num(),his.getHis_acc(),his.getHis_spend(),his.getHis_deg(),his.getHis_type());
        return b;
    }
//根据学生账号查询多条历史记录
    public ArrayList<History> findsomehis(String s_id){
        String sql="select * from "+tablename+" where s_id=?";
        ResultSet rs=JDBCHelper.query(sql,s_id);
        ArrayList<History> list=arrayList(rs);
        return list;
    }
    //将多个历史记录封装起来
    private ArrayList<History> arrayList(ResultSet rs){
        ArrayList<History> list=new ArrayList<>();
        History his = null ;
        if( rs != null ){
            try {
                while (rs.next()) {
                    his = new History();
                    his.setHis_id(rs.getInt("his_id"));
                    his.setS_id(rs.getString("s_id"));
                    his.setHis_bg_time(rs.getString("his_bg_time"));
                    his.setHis_num(rs.getInt("his_num"));
                    his.setHis_spend(rs.getString("his_spend"));
                    his.setHis_deg(rs.getString("his_deg"));
                    his.setHis_type(rs.getString("his_type"));
                    list.add(his);
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return list;
    }

}
