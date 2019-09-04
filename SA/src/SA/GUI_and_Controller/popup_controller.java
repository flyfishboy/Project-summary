package SA.GUI_and_Controller;

import SA.Config.ROOT_controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class popup_controller extends ROOT_controller {
    @FXML
    private Label grade;
    @FXML
    private Label gettime;

    @Override
    public void setconfig(SA.Config.config config)
    {
        this.config = config;
        grade.setText("你的成绩为： "+config.getrightnum()*10+" 分");
        gettime.setText("你的所获时长为： "+config.getrightnum()+" 分钟");
    }

}
