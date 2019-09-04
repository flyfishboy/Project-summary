package SA.GUI_and_Controller;

import SA.Config.ROOT_controller;
import SA.Config.getWebTime;
import SA.database.entity.Pa_set;
import SA.database.entity.Stu_info;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.Date;

//学生主页面
public class home_controller extends ROOT_controller {

    @FXML
    private Label timeshow;//显示网络时间
    @FXML
    private Label tip;//消息提示框
    @FXML
    private Label hello;

    private boolean threadlive = true;//离开该页面时关闭时间线程

    //进入该界面首先运行
    @Override
    public void setconfig(SA.Config.config config) {
        this.config = config;//必有
        maketime();//启动网络时间显示
        Stu_info stuInfo=config.getStuInfo();
        hello.setText("欢迎你，"+stuInfo.getS_name()+" 同学");
    }


    //fxml界面函数-进入做题
    public void zuoti() throws IOException {

        //是否有网络
        if (!getWebTime.getWebsiteDatetime(4).equals("NULL")) {
            //终止线程
            threadlive = false;

            //进入选择答题方式界面
            changeGUI("chooseStudy.fxml", 4);
        } else
            tip.setText("您没有网络，无法做题");
    }

    //fxml界面函数-进入游戏
    public void denglujishi() throws IOException {

        //是否有网络
        if (!getWebTime.getWebsiteDatetime(4).equals("NULL")) {

            Date date = new Date();
            int timenow = date.getHours();//当前小时数

            Pa_set paSet=config.getPaSet();
            String[] xianzhi=paSet.getDay_timeran().split("/");
            int uptime = Integer.parseInt(xianzhi[0]);//服务器限制时间上限
            int downtime = Integer.parseInt(xianzhi[1]);//服务器限制时间下限

            //判断是否在正确时间段内
            if (timenow >= uptime && timenow <= downtime) {

                //剩余时间是否足够
                if (config.gettime() > 0) {
                    //                    服务器读取最大游戏时长
                    if (config.getTimesum() < Integer.parseInt(paSet.getDay_maxtime())) {

                        //终止线程
                        threadlive = false;

                        //进入使用电脑界面
                        changeGUI("play.fxml", 2);

                    } else
                        tip.setText("您当日已游戏到达最大时长");

                } else
                    tip.setText("您已经没有剩余时间了");


            } else
                tip.setText("当前为限制时间段，无法游戏");

        } else
            tip.setText("您没有网络，无法游戏");
    }

    //fxml函数-进入成就
    public void getAchievement() throws IOException {
        //终止线程
        threadlive = false;

        //进入成就界面
        changeGUI("ImBangBang.fxml", 6);
    }

    //显示网络时间
    private void maketime() {
        new Thread(() -> {
            try {
                while (threadlive) {
                    Platform.runLater(() -> {
                        //是否有网络
                        if (!getWebTime.getWebsiteDatetime(4).equals("NULL"))
                            timeshow.setText("时间: " + getWebTime.getWebsiteDatetime(4));//刷新当前时间文本框内容
                        else
                            threadlive = false;
                    });
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

