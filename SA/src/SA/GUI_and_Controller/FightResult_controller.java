package SA.GUI_and_Controller;

import SA.Config.ROOT_controller;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

//对战成绩显示界面
public class FightResult_controller extends ROOT_controller {
    @FXML
    private Label grade;
    @FXML
    private Label gettime;

    @Override
    public void setconfig(SA.Config.config config)
    {
        this.config = config;

        System.out.println(config.getrightnum()+" 结果 : "+config.getrightnum2());


        if(config.getrightnum()>config.getrightnum2()) {
            //加时算法和增加时间（当前为增加对题数*120秒）
            config.addtime(config.getrightnum() * 120);


            grade.setText("你赢了\n你的成绩为： "+config.getrightnum()*10+" 分");
            gettime.setText("你增加的时长为： "+2*config.getrightnum()+" 分钟");

        }else if(config.getrightnum()<config.getrightnum2()) {
            //减时算法和减少时间（当前为减少错题数*120秒）
            config.minuetime(10*120-config.getrightnum() * 120);

            grade.setText("你输了\n你的成绩为： "+config.getrightnum()*10+" 分");
            gettime.setText("你减少的时长为： "+(10-config.getrightnum())*2+" 分钟");

        }else{
            //加时算法和增加时间（当前为增加对题数*60秒）
            config.addtime(config.getrightnum() * 60);

            grade.setText("平局\n你的成绩为： "+config.getrightnum()*10+" 分");
            gettime.setText("你增加的时长为： "+config.getrightnum()+" 分钟");
        }

    }

}
