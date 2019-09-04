package cn.keshe.services;


import cn.keshe.dao.StudentDao;
import cn.keshe.entity.Student;
import cn.keshe.utils.StringHelper;
import com.nchu.entity.User;

public class StudentServices {
     static StudentDao studentDao=new StudentDao();
    public static boolean load(String S_id, String S_password){
        Student s = studentDao.loadByUsername( S_id ) ;
        if( s != null ){
            // 验证密码
            String userPassword = s.getS_password();
            // 判断两次密码是否相等
            System.out.println("getS_password:"+userPassword);
            System.out.println("ServicesID为："+S_id+"Services密码为："+S_password);
            if( userPassword.equals(S_password) ){// StringHelper.encrypt( S_password )
                return true ;
            }
        }
        return false ;
    }

}
