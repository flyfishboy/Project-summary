package SA.GUI_and_Controller;

import SA.Config.ROOT_controller;
import SA.Config.algorithm;
import SA.Config.getWebTime;
import SA.database.entity.History;
import SA.database.entity.Stu_info;
import SA.database.services.StuService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//单机答题控制类
public class study_controller extends ROOT_controller {
    @FXML
    private TextArea question;
    @FXML
    private Text no;
    @FXML
    private Label rest1;
    @FXML
    private Label per;
    @FXML
    private Label timeshow;
    @FXML
    private RadioButton r1;
    @FXML
    private RadioButton r2;
    @FXML
    private RadioButton r3;
    @FXML
    private RadioButton r4;

    private int choose = 0;
    private int now = 0;
    private boolean threadlive = true;
    private String[] q;  //算法生成题目对应文件名号
    private boolean timestart = false;
    private int endtime = 300;
    private double nandu;  //该学生适应的难度
    private String nianji;  //该学生当前年级

    @Override
    public void setconfig(SA.Config.config config) {
        this.config = config;
        maketime();
    }

    private void maketime() {

        new Thread(() -> {
            try {
                while (threadlive) {
                    Platform.runLater(() -> {
                        timeshow.setText("时间: " + getWebTime.getWebsiteDatetime(4));//刷新当前时间文本框内容
                        if (timestart) {
                            endtime--;
                            if (endtime == 0) {
                                try {
                                    threadlive = false;
                                    handin();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else if (endtime >= 0)
                                rest1.setText("答题剩余时间: " + endtime);
                        }
                    });
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    /**
     * @Description: 点击进入下一题，并保存选择的答案（如果有）
     * @Params: []
     * @Returns: void
     * @Author: SHILISHAN
     * @Date: 16:19 2018/11/22
     */
    public void next() throws IOException {
        if (config.getrightanswer()) {
            if (r1.isSelected())
                this.choose = 1;
            else if (r2.isSelected())
                this.choose = 2;
            else if (r3.isSelected())
                this.choose = 3;
            else if (r4.isSelected())
                this.choose = 4;
            config.setanswer(this.now, this.choose);
            now++;
            if (this.now <= 9)
                jumpto(now);
            else
                now = 9;
        }
    }

    /**
     * @Description: 点击按钮开始答题，从服务器获取答题题号数组和对应正确答案数组
     * @Params: []
     * @Returns: void
     * @Author: SHILISHAN
     * @Date: 0:00 2018/11/23
     */
    public void begin() throws IOException {

        algorithm alg = new algorithm();

        // {"3-1.1-4.txt","4-1.2-1.txt","10-1.8-3.txt","11-1.9-4.txt","12-2.0-1.txt","14-2.2-3.txt","23-3.1-4.txt","24-3.2-1.txt","29-3.7-2.txt","31-3.9-4.txt"};  //题目驱动模块

        nandu = config.getNandu();
        nianji = config.getNianji();

        this.q = alg.ChuTi(nandu, nianji);//算法生成题目对应文件名号

        //int[] a= {1,2,3,4,1,2,3,4,1,2};  //本地储存对应正确答案

        config.setrightanswer(alg.RealDaAn(this.q));

        openlocal(q[0], nianji);

        per.setText("正确率：");
        timestart = true;
        endtime = 300;

        r1.setSelected(false);
        r2.setSelected(false);
        r3.setSelected(false);
        r4.setSelected(false);

        jumpto(0);

    }

    //fxml界面函数-提交
    public void handin() throws IOException {
        timestart = false;
        if (config.getrightanswer()) {
            config.check();

            Stu_info stuInfo = config.getStuInfo();

            if (config.getrightnum() > 5) {
                if (Double.parseDouble(stuInfo.getDeg()) + 0.5 > 0 && Double.parseDouble(stuInfo.getDeg()) + 0.5 <= 10) {
                    stuInfo.setDeg((Double.parseDouble(stuInfo.getDeg()) + 0.5) + "");
                    System.out.println("改难度嘤嘤嘤");
                }
            } else {
                if (Double.parseDouble(stuInfo.getDeg()) - 0.5 > 0 && Double.parseDouble(stuInfo.getDeg()) - 0.5 <= 10) {
                    stuInfo.setDeg((Double.parseDouble(stuInfo.getDeg()) - 0.5) + "");
                    System.out.println("少难度嘤嘤嘤");
                }
            }

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);// 输出北京时间


            History history = new History(stuInfo.getS_id(), sdf.format(date), 10, config.getrightnum() + "/10", (300 - endtime) + "", stuInfo.getDeg(), "单人答题");
            StuService stuService = new StuService();
            stuService.insertHis(history);

            //加时算法和增加时间（当前为增加对题数*60秒）
            config.addtime(config.getrightnum() * 60);

            per.setText("正确率： " + config.getrightnum() * 10 + "%");

            balala();
        } else
            per.setText("你还没有开始新一轮答题");
    }


    /**
     * @Description: 输入题号（数字），打开并显示对应题目
     * @Params: [questionnum]
     * @Returns: void
     * @Author: SHILISHAN
     * @Date: 23:59 2018/11/22
     */
    public void openlocal(String a2, String a1) throws IOException {
        String b = "../SA/question_bank/" + a1 + "/" + a2;
        File file = new File(b);


        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line, sb = "";
        while ((line = br.readLine()) != null) {
            sb = sb + line + "\n";
        }
        br.close();

        question.setText(sb.toString());
    }

    /**
     * @Description: 返回home界面
     * @Params: []
     * @Returns: void
     * @Author: SHILISHAN
     * @Date: 16:35 2018/11/22
     */
    public void denglujishi() throws IOException {

        threadlive = false;
        /* 1:home_controller
           2:play_controller
           3:study_controller
           4:
           */

        changeGUI("home.fxml", 1);
    }

    /**
     * @Description: 选题之间的跳转
     * @Params: []
     * @Returns: void
     * @Author: SHILISHAN
     * @Date: 16:35 2018/11/22
     */
    public void jump1() throws IOException {
        if (config.getrightanswer())
            jumpto(0);
    }

    public void jump2() throws IOException {
        if (config.getrightanswer())
            jumpto(1);
    }

    public void jump3() throws IOException {
        if (config.getrightanswer())
            jumpto(2);
    }

    public void jump4() throws IOException {
        if (config.getrightanswer())
            jumpto(3);
    }

    public void jump5() throws IOException {
        if (config.getrightanswer())
            jumpto(4);
    }

    public void jump6() throws IOException {
        if (config.getrightanswer())
            jumpto(5);
    }

    public void jump7() throws IOException {
        if (config.getrightanswer())
            jumpto(6);
    }

    public void jump8() throws IOException {
        if (config.getrightanswer())
            jumpto(7);
    }

    public void jump9() throws IOException {
        if (config.getrightanswer())
            jumpto(8);
    }

    public void jump10() throws IOException {
        if (config.getrightanswer())
            jumpto(9);
    }


    /**
     * @Description: 输入整数a，转到第a个界面并显示是否填写了答案
     * @Params: [a]
     * @Returns: void
     * @Author: SHILISHAN
     * @Date: 21:17 2018/11/22
     */
    private void jumpto(int a) throws IOException {

        openlocal(this.q[a], nianji);

        this.now = a;
        this.no.setText("第 " + (a + 1) + " 题");
        this.choose = config.getanswer(a);
        switch (config.getanswer(a)) {
            case 1:
                r1.setSelected(true);
                break;
            case 2:
                r2.setSelected(true);
                break;
            case 3:
                r3.setSelected(true);
                break;
            case 4:
                r4.setSelected(true);
                break;
            default:
                r1.setSelected(false);
                r2.setSelected(false);
                r3.setSelected(false);
                r4.setSelected(false);
                this.choose = 0;
                break;
        }
    }

    //显示成绩弹窗
    private void balala() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("popup.fxml"));
        Parent target = fxmlLoader.load();

        popup_controller controller1 = fxmlLoader.getController();
        controller1.setconfig(config);

        Stage stg = new Stage();//创建舞台；
        stg.setAlwaysOnTop(true);
        stg.setResizable(false);
        stg.setScene(new Scene(target)); //将场景载入舞台；
        stg.show(); //显示窗口

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000);
                if (stg.isShowing()) {
                    Platform.runLater(() -> {
                        stg.close();
                    });
                }
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();
    }


}

