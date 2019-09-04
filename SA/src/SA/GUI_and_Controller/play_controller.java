package SA.GUI_and_Controller;

import SA.database.entity.Pa_set;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class play_controller {

    public SA.Config.config config;
    @FXML
    public AnchorPane rootpane;

    private Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();

    private static boolean OnlyOneIcon = true;

    private SystemTray tray;
    private TrayIcon trayIcon;
    private java.awt.Image image;
    private boolean threadlive = true;

    private int uptime;//服务器限制时间上限
    private int downtime;//服务器限制时间下限
    private int maxtime;

    //刚进入后初始化函数
    public void setconfig(SA.Config.config config) {

        this.config = config;

        //取得stage
        Stage stage = (Stage) rootpane.getScene().getWindow();

        stage.setMaximized(false);
        //stage.setAlwaysOnTop(false);
        maketime(stage);


        stage.setX((int) screensize.getWidth() + 100);
        stage.setY(0);
        //stage.setY((int)screensize.getHeight());

        createTrayIcon(stage);
        trayIcon.displayMessage("提示信息", "您还剩余 " + config.gettime() / 3600 + " 时 " + config.gettime() / 60 + " 分 " + config.gettime() % 60 + " 秒", TrayIcon.MessageType.INFO);


        Pa_set paSet = config.getPaSet();
        String[] xianzhi = paSet.getDay_timeran().split("/");
        uptime = Integer.parseInt(xianzhi[0]);//服务器限制时间上限
        downtime = Integer.parseInt(xianzhi[1]);//服务器限制时间下限
        maxtime = Integer.parseInt(paSet.getDay_maxtime());
    }

    //右小角,最小化.
    public void createTrayIcon(final Stage stage) {


        if (SystemTray.isSupported()) {
            // get the SystemTray instance
            tray = SystemTray.getSystemTray();
            // load an image

            try {
                image = ImageIO.read(new File("item/idea.png"));
            } catch (IOException ex) {
                System.out.println(ex);
            }


            /*监听关闭事件，不过用不上
            stage.setOnCloseRequest(t -> {
            });*/

            // 给tray icon创建事件监听(关闭监听)
            ActionListener closeListener = e ->
                    Platform.runLater(() ->
                    {


                        threadlive = false;
                        stage.setMaximized(true);


                        try {
                            //changeGUI("home.fxml", 1);

                            //玄学？？
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
                            Parent root = fxmlLoader.load();
                            rootpane.getChildren().setAll(root);
                            home_controller controller1 = fxmlLoader.getController();
                            controller1.setconfig(config);

                            /*关闭弹窗（如果有）（已取消）

                            if(this.tanchuang!=null)
                            {

                                System.out.println("关弹窗了");
                                this.tanchuang.close();
                                tanchuang=null;
                            }
                            */


                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        //System.exit(0);
                    });

            // 给tray icon创建事件监听
            ActionListener showListener = e ->
                    //       Platform.runLater(() ->
            {
                trayIcon.displayMessage("提示信息", "您还剩余 " + config.gettime() / 3600 + " 时 " + config.gettime() / 60 + " 分 " + config.gettime() % 60 + " 秒", TrayIcon.MessageType.INFO);
                //stage.show();
            };//);
            //创建 popup menu
            PopupMenu popup = new PopupMenu();

            //开始添加整合到一起
            MenuItem showItem = new MenuItem("Show Time");
            showItem.addActionListener(showListener);
            popup.add(showItem);

            //开始添加整合到一起
            MenuItem closeItem = new MenuItem("Back To Menu");
            closeItem.addActionListener(closeListener);
            popup.add(closeItem);

            // 创建 TrayIcon
            trayIcon = new TrayIcon(image, "学习监督管理系统", popup);

            //给图标也设置监听
            trayIcon.addActionListener(showListener);
            // ...
            // add the tray image
            try {
                if (OnlyOneIcon) {
                    OnlyOneIcon = false;
                    tray.add(trayIcon);
                }
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }

    //定时提醒与到时退出
    private void maketime(Stage stage) {

        int timefromconfig = config.gettime();

        new Thread(() -> {
            try {
                while (threadlive) {
                    Platform.runLater(() -> {

                        config.setTimesum();
                        config.timeless();

                        //如果可用时间耗尽
                        if ((config.gettime() == 0)) {
                            //                     服务器设置的最大游戏时间（从服务器读取）
                            if (config.getTimesum() >= maxtime) {

                                Date date = new Date();
                                int timenow = date.getHours();//当前小时数


                                //如果不在正确时间段内


                                if (!(timenow >= uptime && timenow <= downtime)) {

                                    threadlive = false;
                                    stage.setMaximized(true);
                                    try {
                                        //changeGUI("home.fxml", 1);

                                        //玄学？？
                                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home.fxml"));
                                        Parent root = fxmlLoader.load();
                                        rootpane.getChildren().setAll(root);
                                        home_controller controller1 = fxmlLoader.getController();
                                        controller1.setconfig(config);
                                    } catch (IOException e1) {
                                        e1.printStackTrace();
                                    }

                                }
                            }
                        } else if (config.gettime() <= 300)
                            trayIcon.displayMessage("结束警告", "你还有不到5分钟", TrayIcon.MessageType.INFO);
                        else if ((timefromconfig - config.gettime()) % 3600 == 0)//每1小时弹窗提醒1次
                        {
                            try {
                                pop();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


    //弹窗提醒保护眼睛
    public void pop() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("popup2.fxml"));
        Parent target = fxmlLoader.load();

        //popup_controller controller1 = fxmlLoader.getController();
        //controller1.setconfig(config);

        Stage stg = new Stage();//创建舞台；

        stg.setAlwaysOnTop(true);
        stg.initStyle(StageStyle.UNDECORATED);
        stg.setX((int) screensize.getWidth() / 2 - 300);
        stg.setY((int) screensize.getHeight() / 4 - 200);
        stg.setScene(new Scene(target)); //将场景载入舞台；
        stg.show(); //显示窗口

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(300000);  //间隔5分钟后运行
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

