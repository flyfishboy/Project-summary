package SA.Config;

import SA.GUI_and_Controller.*;
import SA.database.entity.Pa_set;
import SA.database.entity.Stu_info;
import SA.database.services.StuService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

//根控制器父类
public abstract class ROOT_controller {

    //学生信息配置
    public SA.Config.config config;

    //布局名
    @FXML
    public AnchorPane rootpane;

    public void setconfig(SA.Config.config config) {
        this.config = config;
    }

    //界面跳转
    public void changeGUI(String fxml, int controller) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = fxmlLoader.load();
        rootpane.getChildren().setAll(root);


        //用来跳转各个界面
        switch (controller) {
            //家长控制界面
            case 0:
                parent_controller controller0 = fxmlLoader.getController();
                controller0.setconfig(config);
                break;

            //学生功能选择主界面
            case 1:
                home_controller controller1 = fxmlLoader.getController();
                controller1.setconfig(config);
                break;

            //学生使用电脑界面
            case 2:
                play_controller controller2 = fxmlLoader.getController();
                controller2.setconfig(config);
                break;

            //学生单人答题界面
            case 3:
                study_controller controller3 = fxmlLoader.getController();
                controller3.setconfig(config);
                break;

            //学生选择答题模式界面
            case 4:
                chooseStudy_controller controller4 = fxmlLoader.getController();
                controller4.setconfig(config);
                break;

            //学生对战答题界面
            case 5:
                studyFight_controller controller5 = fxmlLoader.getController();
                controller5.setconfig(config);
                break;

            //学生查看成就界面
            case 6:
                ImBangBang_controller controller6 = fxmlLoader.getController();
                controller6.setconfig(config);
                break;

            //学生查看答题历史界面
            /*
            case 7:
                FightHistory_controller controller7 = fxmlLoader.getController();
                controller7.setconfig(config);
                break;
*/

            default:
                break;
        }

    }

    //关机并上传服务器 正常退出 值改为0
    public void shutdownWindows() {
        try {

            //此次为服务器操作
            StuService stuServices = new StuService();
            Stu_info stuInfo = config.getStuInfo();
            Pa_set paSet = config.getPaSet();

            paSet.setDay_time(config.gettime() + "");

            stuInfo.setBack("0");
            stuServices.alterPaset(paSet);
            stuServices.updateStuMes(stuInfo);


            Runtime.getRuntime().exec("cmd /c shutdown /s /t 0");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onButtonClick() {
        System.exit(0);
    }


}
