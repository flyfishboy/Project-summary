package SA.database.services;

import SA.database.dao.*;
import SA.database.entity.*;
import SA.database.utils.JDBCHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StuService {
    Stu_infoDao sif=new Stu_infoDao();
    pa_infoDao pif=new pa_infoDao();
    pa_setDao psd=new pa_setDao();
    HistoryDao hd=new HistoryDao();
    FightDao fd=new FightDao();

    //学生登录
    public boolean stuLogin(String s_id,String password){
        Stu_info stu=sif.findUserById(s_id);
        if(stu!=null){
            if(stu.getS_password().equals(password)){
                return true;
            }else{
                return false;
            }
        }else
            return false;
    }
    //查找一个学生的所有信息
    public Stu_info findUserById(String s_id){
        Stu_info stu=sif.findUserById(s_id);
        return stu;
    }

    //修改学生信息
    public boolean updateStuMes(Stu_info si){
       String s_id=si.getS_id();
       String s_password=si.getS_password();
       String s_name=si.getS_name();
       String s_sex=si.getS_name();
       String s_grade=si.getS_grade();
       String p_id=si.getP_id();
       String p_ad=si.getP_ad();
       String deg=si.getDeg();
       String back=si.getBack();
       boolean b1=sif.updateOne(s_id,"s_password",s_password);
       boolean b2=sif.updateOne(s_id,"s_name",s_name);
       boolean b3=sif.updateOne(s_id,"s_sex",s_sex);
       boolean b4=sif.updateOne(s_id,"s_grade",s_grade);
       boolean b5=sif.updateOne(s_id,"s_password",s_password);
       boolean b6=sif.updateOne(s_id,"p_id",p_id);
       boolean b7=sif.updateOne(s_id,"p_ad",p_ad);
       boolean b8=sif.updateOne(s_id,"deg",deg);
       boolean b9=sif.updateOne(s_id,"back",back);
        if(b1&&b2&&b3&&b4&&b5&&b6&&b7&&b8&&b9){
            return true;
        }else
            return false;
    }
    //解锁孩子账号
    public  boolean updatebackMes(Stu_info si){
        String s_id=si.getS_id();
        String back=si.getBack();

        boolean b=sif.updateOne(s_id,"back",back);
        if(b)
            return true;
        else
            return false;
    }


    //检测注册的账号是否唯一
    public boolean accOnly(String s_id){
        Stu_info stu=sif.findUserById(s_id);
        if(stu==null)
            return true;
        else
            return false;
    }
    //账号注册
    public boolean userRegister(Stu_info stu){
        boolean b=sif.insertStu(stu);
        return b;
    }
    //修改家长密码
    public boolean alterPaMes(Pa_info pi){
        String p_id=pi.getP_id();
        String p_password=pi.getP_password();
        boolean a=pif.updateMes(p_id,"p_password",p_password);
        if(a){
            return true;
        }else
            return false;
    }
    //插入设置信息
    public boolean insertPs(Pa_set ps){
        boolean b=psd.insertPs(ps);
        return b;
    }

    //根据s_id查询一个某个孩子的学习设置信息
    public Pa_set findPsById(String s_id){
        Pa_set ps=psd.findPsById(s_id);
        return ps;
    }
    //修改设置信息
    public boolean alterPaset(Pa_set ps) {
        String s_id=ps.getS_id();
        String p_id = ps.getP_id();
        String day_time = ps.getDay_time();
        String day_maxtime = ps.getDay_maxtime();
        String day_timeran = ps.getDay_timeran();
        String remind=ps.getRemind();
        boolean a = psd.updateOnePs(p_id,s_id, "day_time", day_time);
        boolean b = psd.updateOnePs(p_id, s_id,"day_maxtime", day_maxtime);
        boolean c = psd.updateOnePs(p_id, s_id,"day_timeran", day_timeran);
        boolean d=  psd.updateOnePs(p_id, s_id,"remind", remind);
        if(a&&b&&c&&d){
            return true;
        }else
            return false;
    }
    //插入学生学习记录
    public boolean insertHis(History his){
        boolean b=hd.insertHis(his);
        return b;
    }
    //查找学生学习历史记录
    public ArrayList<History> findsomehis(String s_id){
        ArrayList<History> list=hd.findsomehis(s_id);
        return list;
    }
    //插入房主信息
    public boolean insertFit(Fight fight){
        boolean b=fd.insertFit(fight);
        return b;
    }
    //删除房主信息
    public boolean deletefi(String f_king_id){
        boolean b=fd.deletefi(f_king_id);
        return b;
    }
    //查找表中所有房主信息
    public ArrayList<Fight> findAll() throws SQLException {
        ArrayList<Fight> list=fd.findAll();
        return list;
    }
    //根据s_id查找ip
    public  Fight findip(String f_king_id,String f_king_ok) throws SQLException {
        Fight fight=fd.findip(f_king_id,f_king_ok);
        return fight;
    }

    //根据f_id查找
    public  String findff(int f_id) throws SQLException {
        Fight fight=fd.findff(f_id);
        return fight.getF_king_ok();
    }

    //根据f_id查找
    public  String findffp1(int f_id) throws SQLException {
        Fight fight=fd.findff(f_id);
        return fight.getF_king_p1();
    }

    //根据f_id查找
    public  String findffp2(int f_id) throws SQLException {
        Fight fight=fd.findff(f_id);
        return fight.getF_king_p2();
    }


//修改房主状态
    public boolean updateOK(Fight fight){
        int f_id=fight.getF_id();
        String f_king_ok="1";
        boolean b=fd.updateOK(f_id,"f_king_ok",f_king_ok);
        if(b)
            return true;
        else
            return false;
    }

    //对战后上传P1_p2成绩
    public boolean updatap1(Fight fight){
        int f_id=fight.getF_id();
        String f_king_p1=fight.getF_king_p1();

        boolean b=fd.updateOK(f_id,"f_king_p1",f_king_p1);

        if(b){
            return true;
        }
        else
            return false;


    }

    //对战后上传P1_p2成绩
    public boolean updatap2(Fight fight){
        int f_id=fight.getF_id();

        String f_king_p2=fight.getF_king_p2();

        boolean b1=fd.updateOK(f_id,"f_king_p2",f_king_p2);
        if(b1){
            return true;
        }
        else
            return false;


    }


}
