package cn.keshe.services;

import cn.keshe.dao.TeacherDao;
import cn.keshe.entity.Teacher;
import cn.keshe.utils.StringHelper;

public class TeacherServices {
    static TeacherDao teacherDao=new TeacherDao();
    public static boolean load(String T_id, String T_password){
        Teacher t = teacherDao.loadByUsername( T_id ) ;
        if( t != null ){
            // 验证密码
            String userPassword = t.getT_password();
            // 判断两次密码是否相等
            System.out.println("getT_password:"+userPassword);
            System.out.println("ServicesID为："+T_id+"Services密码为："+T_password);
            if( userPassword.equals(T_password) ){// StringHelper.encrypt( S_password )
                return true ;
            }
        }
        return false ;
    }

}

