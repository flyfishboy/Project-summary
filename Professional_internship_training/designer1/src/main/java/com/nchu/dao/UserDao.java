package com.nchu.dao;

import com.nchu.entity.User;
import com.nchu.utils.JDBCHelper;
import com.nchu.utils.StringHelper;

import javax.servlet.http.HttpServlet;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends HttpServlet {
    String tableName = " t_user " ;

    public boolean alterpassword(String username,String password){
        password=StringHelper.encrypt(password);
        String SQL="update"+tableName+"set password= ? where username= ?";
        boolean b=JDBCHelper.execute(SQL,password,username);
        return b;
    }

    public User loadByUsername(String username ){
        // 利用 jdbc 访问数据库
        String SQL = "select id , username , password , nickname ,userinformation from"+tableName+"where username = ? " ;
        ResultSet rs = JDBCHelper.query( SQL , username ) ;
        User  u = wrap(rs ) ;
        return u ;
    }

    /**
     * 插入数据
     * @param
     * @return
     */

    public boolean  insert( User u ){
        String SQL = "insert into " +tableName + " values (?,?,?,?,?) " ;
        boolean b=JDBCHelper.execute( SQL , u.getId()  ,u.getUsername() , u.getPassword() , u.getNickname(), u.getUserinformation() ) ;
        return b;
    }

    private User wrap ( ResultSet rs ){
        User u = null ;
        if( rs != null ){
            try {
                while (rs.next()) {
                    u = new User();
                    u.setId(rs.getString("id"));
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                    u.setNickname(rs.getString("nickname"));
                    u.setUserinformation(rs.getString("userinformation"));
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return u ;
    }
}
