package SA.GUI_and_Controller;

import SA.Config.ROOT_controller;
import SA.Config.algorithm;
import SA.database.entity.Fight;
import SA.database.entity.Stu_info;
import SA.database.services.StuService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

//选择答题界面（多人或单人）
public class chooseStudy_controller extends ROOT_controller {
    @FXML
    private ProgressIndicator login;//转圈界面
    @FXML
    private AnchorPane jiazai;//加载界面
    @FXML
    private Button kingbutton;//房主按钮
    @FXML
    private Pane joinButtons;//加入按钮

    private Boolean flag = true;//查询服务器线程是否继续
    private static StuService stuService;
    private static Fight fight;
    private static Stu_info si1;


    //点击我要加入后出现等待加载界面
    public void startlogin() {
        jiazai.setVisible(true);
        login.setProgress(-1);
        kingbutton.setVisible(false);


        config.setKing(false);


        flag = true;

        //搜索服务器，如果f_king_ok为0且房主年级对应则抓取，否则返回空
        new Thread(() -> {

            try {

                while (flag) {
                    String[] get;
                    if (mem().length > 0)
                        get = mem();
                    else {
                        get = new String[1];
                        get[0] = new String();
                    }


                    //循环查找服务器是否有合适匹配的对象，如果有
                    if (get[0].length() > 0) {

                        //读取服务器的题目序列
                        config.setKingtimu(get[0].split("/"));

                        //修改服务器的匹配值为1, 匹配上后同时修改房主在服务器上的状态信息
                        boolean b = stuService.updateOK(fight);
                        if (b) {
                            //提示无人匹配，状态修改成功
                        } else {
                            //状态修改失败
                        }

                        //读取对应表ID，方便之后修改查询
                        config.setF_id(Integer.parseInt(get[1]));


                        flag = false;


                        Platform.runLater(() -> {
                            try {
                                chooseStudy_controller.this.changeGUI("studyFight.fxml", 5);
                                System.out.println("嘤嘤嘤");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }).start();


    }


    //自己不是房主时
    public String[] mem() throws SQLException {
        stuService = new StuService();
        ArrayList<Fight> list = stuService.findAll();
        ArrayList<Fight> listt = new ArrayList<>();
        for (int k = 0; k < list.size(); k++) {
            if (list.get(k).getF_king_ok().equals("0")) {
                listt.add(list.get(k));
            }
        }
        ArrayList<Stu_info> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        String s_id = config.getid();//得到自己的s_id
        for (int i = 0; i < listt.size(); i++) {
            list1.add(stuService.findUserById(listt.get(i).getF_king_id()));//得到所有房主的基本信息
        }


        si1 = new Stu_info();
        si1 = stuService.findUserById(s_id);
        String nj = si1.getS_grade();
        for (int i = 0; i < list1.size(); i++) {
            if (nj.equals(stuService.findUserById(listt.get(i).getF_king_id()).getS_grade())) {
                list2.add(stuService.findUserById(list.get(i).getF_king_id()).getS_id());
            }
        }
        int j = (int) (Math.random() * list2.size());//随机匹配
        fight = new Fight();
        fight = stuService.findip(stuService.findUserById(listt.get(j).getF_king_id()).getS_id(), "0");
        String f_king_ip = fight.getF_king_ip();//得到匹配到的房主的题目序号


        String[] get = {f_king_ip, fight.getF_id() + ""};

        return get;
    }


    //点击我是房主后出现等待加载界面
    public void startlogin2() {
        jiazai.setVisible(true);
        login.setProgress(-1);
        joinButtons.setVisible(false);
        config.setKing(true);


        algorithm alg = new algorithm();
        String[] timuhao = alg.ChuTi(config.getNandu(), config.getNianji());//算法生成题目对应文件名号
        String timu = "";
        for (int i = 0; i < timuhao.length; i++) {
            if (i + 1 == timuhao.length)
                timu = timu + timuhao[i];
            else
                timu = timu + timuhao[i] + "/";
        }


        //自己是房主
        fight = new Fight();
        stuService = new StuService();
        String f_king_id = config.getid();
        String f_king_ip = timu;//获取需要上传的题目序列
        String f_king_ok = "0";
        String f_king_p1 = "";
        String f_king_p2 = "";
        fight.setF_king_id(f_king_id);
        fight.setF_king_ip(f_king_ip);
        fight.setF_king_ok(f_king_ok);
        fight.setF_king_p1(f_king_p1);
        fight.setF_king_p2(f_king_p2);
        boolean b = stuService.insertFit(fight);
        if (b) {
            //提示成功
        } else {
            //提示失败
        }


        //在服务器对战表获得自己的ID
        try {
            fight = stuService.findip(config.getid(), "0");
            config.setF_id(fight.getF_id());
            config.setKingtimu(timuhao);

        } catch (SQLException e) {
            e.printStackTrace();
        }


        //使用线程循环查询是否有人匹配
        flag = true;
        new Thread(() -> {

            while (flag) {
                try {


                    //循环查找服务器是否有人匹配,如果有人匹配，直接进
                    if (Integer.parseInt(stuService.findff(config.getF_id())) == 1) {

                        flag = false;
                        Platform.runLater(() -> {
                            try {
                                chooseStudy_controller.this.changeGUI("studyFight.fxml", 5);
                                System.out.println("嘤嘤嘤");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }


                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }).start();

    }


    //停止匹配后返回界面
    public void stoplogin() {
        jiazai.setVisible(false);
        kingbutton.setVisible(true);
        joinButtons.setVisible(true);

        flag = false;

        //如果自己是房主，就把自己上传的表中匹配改为1
        if (config.getKing()) {

            //把自己上传的表中匹配改为1

            fight = new Fight();
            fight.setF_id(config.getF_id());
            //修改服务器的匹配值为1, 匹配上后同时修改房主在服务器上的状态信息
            boolean b = stuService.updateOK(fight);
            if (b) {
                //提示无人匹配，状态修改成功
            } else {
                //状态修改失败
            }


        }

    }

    //进入单人答题
    public void Onestudy() throws IOException {
        changeGUI("study.fxml", 3);
    }


    public void backtohome() throws IOException {

        changeGUI("home.fxml", 1);
    }

}
