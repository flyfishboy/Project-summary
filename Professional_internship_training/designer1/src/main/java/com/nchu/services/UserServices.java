package com.nchu.services;

import com.nchu.dao.UserDao;
import com.nchu.entity.User;
import com.nchu.utils.StringHelper;

public class UserServices {
    UserDao userDao=new UserDao();
    public  boolean load(String username, String password){
        User u = userDao.loadByUsername( username ) ;
        if( u != null ){
            // 验证密码
            String userPassword = u.getPassword();
            // 判断两次密码是否相等
            if( userPassword.equals( StringHelper.encrypt( password ) ) ){
                return true ;
            }
        }
        return false ;
    }

    public boolean isUnique( String username ){
        // 拿到 username 去数据库中查询 ，如果有 ，证明 不可以注册， 返回 false
        User u = userDao.loadByUsername( username ) ;
        if( u != null ){
            return false ;
        }
        // 如果没有呢？ 返回 true
        return true ;
    }
    public boolean regist( String username , String password , String nickname ,String userinformation){
        User u = new User() ;
        u.setNickname(nickname);
        u.setPassword(StringHelper.encrypt(password));
        u.setUsername(username);
        u.setId(StringHelper.uuid() );
        u.setUserinformation(userinformation);
        boolean b=userDao.insert( u ) ;
        return b;
    }
}
