
package cn.keshe.services;

        import cn.keshe.dao.AdminDao;
        import cn.keshe.entity.Admin;
        import cn.keshe.utils.StringHelper;

public class AdminServices {
    static AdminDao adminDao=new AdminDao();
    public static boolean load(String A_id, String A_password){
        Admin t = adminDao.loadByUsername( A_id ) ;
        if( t != null ){
            // 验证密码
            String userPassword = t.getA_password();
            // 判断两次密码是否相等
            System.out.println("getA_password:"+userPassword);
            System.out.println("ServicesID为："+A_id+"Services密码为："+A_password);
            if( userPassword.equals(A_password) ){// StringHelper.encrypt( S_password )
                return true ;
            }
        }
        return false ;
    }

}

