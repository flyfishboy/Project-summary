package cn.keshe.dao;

import cn.keshe.entity.Practice_work;
import cn.keshe.utils.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Practice_workDao {
    String tableName = "practice_work";
    private ArrayList arraylist(ResultSet rs) {
        ArrayList<Practice_work> listp=new ArrayList<>();
        Practice_work E=null;
        if( rs != null ){
            try {
                while (rs.next()) {

                    E = new Practice_work();
                    E.setM_id(rs.getString("m_id"));
                    E.setM_title(rs.getString("m_title"));
                    E.setM_content(rs.getString("m_content"));
                    E.setM_date(rs.getString("m_date"));
                    E.setM_grade(rs.getFloat("m_grade"));
                    E.setS_id(rs.getString("s_id"));
                    E.setT_id(rs.getString("t_id"));
                    listp.add(E);

                }
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return listp;
    }

    /*学生上传实习任务内容*/
    public boolean upcontent(String m_title,String m_content,String m_date,String m_grade,String s_id,String t_id){
        String sql="insert into Practice_work (m_title,m_content,m_date,m_grade,s_id,t_id) values(?,?,?,?,?,?)";
        boolean b=JDBCHelper.execute(sql,m_title,m_content,m_date,m_grade,s_id,t_id);
        return b;
    }

    /*学生查找自己的实习任务*/
    public ArrayList<Practice_work> sselect(String t_id){
        ArrayList<Practice_work> list1=new ArrayList<>();
        String SQL="select * from practice_work where t_id= ? and s_id=0";
        ResultSet rs = JDBCHelper.query( SQL ,t_id);
        list1=arraylist(rs);
        return list1;
    }


    /*教师查找自己所带学生的实习任务*/
    public ArrayList select(String t_id){
        ArrayList<Practice_work> list1=new ArrayList<>();
        String SQL="select * from "+tableName+" where t_id=?";
        ResultSet rs = JDBCHelper.query( SQL ,t_id);
        list1=arraylist(rs);
        return list1;
    }
/*按作业标题查找*/
public ArrayList selectWNumber(String m_title){
    ArrayList<Practice_work> list1=new ArrayList<>();
    String SQL="select * from "+tableName+" where m_title like '%"+m_title+"%' ";
    ResultSet rs = JDBCHelper.query( SQL);
    list1=arraylist(rs);
    return list1;
}
    /*删除一条实习任务*/
    public boolean delete(String id) {
        String sql="delete from "+tableName+" where m_id=?";
        boolean b=JDBCHelper.execute(sql,id);
        return b;
    }
    /*批阅周记*/
    public boolean update(String m_id,String m_grade) {
        String sql="UPDATE "+tableName+" SET m_grade=?  WHERE m_id =?";
        boolean b=JDBCHelper.execute(sql,m_grade,m_id);
        return b;
    }
    /*发布任务*/
    public  boolean  insert(Practice_work p){
        String SQL = " insert into "+tableName+"(m_title,m_content,m_date,m_grade,s_id,t_id) values (?,?,?,?,?,?)" ;
        boolean b=JDBCHelper.execute( SQL,p.getM_title(),p.getM_content(),p.getM_date(),p.getM_grade(),p.getS_id(),p.getT_id()) ;
        return b;
    }
}
