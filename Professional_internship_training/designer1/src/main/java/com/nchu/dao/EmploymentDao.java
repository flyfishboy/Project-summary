package com.nchu.dao;

import com.nchu.entity.Employment;
import com.nchu.entity.User;
import com.nchu.utils.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmploymentDao {
    String tableName=" t_employment ";

    public boolean  insert(Employment E ){
        String SQL = "insert into " +tableName + " values (?,?,?,?,?,?,?) " ;
        boolean b=JDBCHelper.execute( SQL , E.getId()  ,E.getJobname() , E.getImg(),E.getUsername(),E.getPnumber(),E.getIntroduction(),E.getSalary() ) ;
        return b;
    }


    public boolean alter(Employment E){
        String SQL="update"+tableName+"set jobname=?,img=?,pnumber=?,introduction=?,salary=?  where id=?";
        boolean b=JDBCHelper.execute(SQL,E.getJobname(),E.getImg(),E.getPnumber(),E.getIntroduction(),E.getSalary(),E.getId());
        return b;
    }


    public boolean delete(String id){
        String SQL="delete from"+tableName+"where id=?";
        boolean b=JDBCHelper.execute(SQL,id);
        return b;
    }

    public ArrayList select(String select){
        ArrayList<Employment> list=new ArrayList<>();
        String SQL="select id ,jobname, img , username , pnumber ,introduction,salary from"+tableName+"where introduction like '%"+select+"%'";
        ResultSet rs = JDBCHelper.query( SQL ) ;
        list=arraylist(rs);
        return list;
    }

    public ArrayList load_mine(String username){
        ArrayList<Employment> list=new ArrayList<>();
        String SQL="select id ,jobname, img , username , pnumber ,introduction,salary from"+tableName+"where username=?";
        ResultSet rs = JDBCHelper.query( SQL,username ) ;
        list=arraylist(rs);
        return list;
    }

    public ArrayList load_employment() {
        ArrayList<Employment> listall=new ArrayList<>();
        String SQL="select id ,jobname, img , username , pnumber ,introduction,salary from"+tableName;
        ResultSet rs = JDBCHelper.query( SQL ) ;
        listall=arraylist(rs);
        return listall;
    }


    private ArrayList arraylist(ResultSet rs) {
        ArrayList<Employment> listall=new ArrayList<>();
        Employment E=null;
        if( rs != null ){
            try {
                while (rs.next()) {
                    E = new Employment();
                    E.setId(rs.getString("id"));
                    E.setJobname(rs.getString("jobname"));
                    E.setUsername(rs.getString("username"));
                    E.setImg(rs.getString("img"));
                    E.setPnumber(rs.getString("pnumber"));
                    E.setIntroduction(rs.getString("introduction"));
                    E.setSalary(rs.getString("salary"));
                    listall.add(E);
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return listall;
    }
}
