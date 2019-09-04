package SA;

import SA.Config.config;
import SA.GUI_and_Controller.main_controller;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        //如果使用 Parent root = FXMLLoader.load(...) 静态读取方法，无法获取到Controller的实例对象
        //Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        config config =new config();
        firststage(config);


/*
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.print(config.gettime() + "\n 进程关闭已被监听\n");
               Platform.runLater(() -> {
                System.out.print(config.gettime() + "\n gali");
                    try {
                        Main.this.firststage(config);
                       //Runtime.getRuntime().exec("java -classpath .//bin SA");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }));
*/

    }

    public void firststage(config config) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("GUI_and_Controller/main.fxml"));
        Parent root = fxmlLoader.load();

        Stage first=new Stage();

        first.setTitle("学习监督管理系统");
        first.setScene(new Scene(root, 1, 1));
        first.setMaximized(true);
        first.setAlwaysOnTop(true);
        first.initStyle(StageStyle.UNDECORATED);

        first.show();


        main_controller controller0 = fxmlLoader.getController();
        controller0.setconfig(config);


        first.setOnCloseRequest(event -> {
            try {
                /*保存用户信息*/


                firststage(config);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }






    public static void main(String[] args) {
        launch(args);
    }

}
