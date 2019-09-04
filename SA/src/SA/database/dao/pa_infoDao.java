package SA.database.dao;

import SA.database.entity.Pa_info;
import SA.database.utils.JDBCHelper;

public class pa_infoDao {
    String tablename="pa_info";
    //插入
    public boolean insertPa(Pa_info pa){
        String sql="insert into "+tablename+" values(?,?,?,?,?)";
        boolean b=JDBCHelper.execute(sql,pa.getP_id(),pa.getP_password(),pa.getP_name(),pa.getP_sta(),pa.getP_ad());
        return b;
    }
    //通过账号修改某项数据
    public boolean updateMes(String p_id,String name, String value){
        String sql="update "+tablename+" set "+name+"=? where p_id=?";
        boolean b=JDBCHelper.execute(sql,value,p_id);
        return b;
    }


}
