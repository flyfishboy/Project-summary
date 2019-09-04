package SA.database.services;

import SA.database.entity.Fight;
import SA.database.entity.Stu_info;

import java.sql.SQLException;
import java.util.ArrayList;

public class Demo1 {
    private static SA.Config.config config;
    private static StuService stuService;
    private static String localip;
    private static Fight fight;
    private static Stu_info si;
    private static Stu_info si1;
    public static void main(String[] args){
        //自己是房主
        fight=new Fight();
        stuService=new StuService();
        String f_king_id=config.getid();
        String f_king_ip="";//获取需要上传的题目序列
        String f_king_ok="0";
        String f_king_p1="";
        String f_king_p2="";
        fight.setF_king_id(f_king_id);
        fight.setF_king_ip(f_king_ip);
        fight.setF_king_ok(f_king_ok);
        fight.setF_king_p1(f_king_p1);
        fight.setF_king_p2(f_king_p2);
        boolean b =stuService.insertFit(fight);
        if(b)
        {
            //提示成功
        }
        else{
            //提示失败
        }
    }
public void upda() throws SQLException {

    //隔了一段时间后没人匹配自动将转台修改为“1”
    fight=new Fight();
    stuService=new StuService();
    String f_king_id=config.getid();
    String f_king_ok="0";
    fight=stuService.findip(f_king_id,f_king_ok);
    boolean b=stuService.updateOK(fight);
    if(b){
        //提示无人匹配，状态修改成功
    }else{
        //状态修改失败

    }
}

//自己不是房主时
    public String  mem() throws SQLException {
        stuService=new StuService();
        ArrayList<Fight> list =stuService.findAll();
        ArrayList<Stu_info> list1=new ArrayList<>();
        ArrayList<String> list2=new ArrayList<>();
        String s_id=config.getid();//得到自己的s_id
        for(int i=0;i<list.size();i++){
            list1.add(stuService.findUserById(list.get(i).getF_king_id()));//得到所有房主的基本信息
        }
        si1=new Stu_info();
        si1=stuService.findUserById(s_id);
        String nj=si1.getS_grade();
        for(int i=0;i<list1.size();i++){
            if(nj.equals(stuService.findUserById(list.get(i).getF_king_id()).getS_grade())){
                list2.add(stuService.findUserById(list.get(i).getF_king_id()).getS_id());
            }
        }
        int j= (int) (Math.random()*list2.size());//随机匹配
        fight=new Fight();
        fight=stuService.findip(stuService.findUserById(list.get(j).getF_king_id()).getS_id(),"0");
        String f_king_ip=fight.getF_king_ip();//得到匹配到的房主的题目序号

        //匹配上后同时修改房主在服务器上的状态信息
        boolean b=stuService.updateOK(fight);
        if(b){
            //提示无人匹配，状态修改成功
        }else{
            //状态修改失败

        }

        return f_king_ip;
    }


}
