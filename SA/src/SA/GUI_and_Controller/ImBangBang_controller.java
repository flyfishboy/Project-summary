package SA.GUI_and_Controller;

import SA.Config.ROOT_controller;
import SA.database.entity.Pa_set;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.*;

public class ImBangBang_controller extends ROOT_controller {
    @FXML
    private GridPane gridPane1;//任务网格
    @FXML
    private GridPane gridPane2;//成就网格

    @Override
    public void setconfig(SA.Config.config config) {
        this.config = config;

        try {

            String[] mission = get_MissionConfig();
            String[] achievement = get_AchievementConfig();

            String writeback = "";

            //任务
            for (int i = 1; i < mission.length; i++) {
                String[] m = mission[i].split("\n");


                if (i == 1 && m[3].contains("未完")) {
                    if (config.getRightnumsum() >= 50)//累计答对50题
                    {
                        m[3] = "已完成";
                        config.settime(config.gettime() + 600);
                    }
                } else if (i == 2 && m[3].contains("未完")) {
                    if (config.getKingtimu().length > 1)//对战一次
                    {
                        m[3] = "已完成";
                        config.settime(config.gettime() + 600);
                    }
                }


                writeback = writeback + "bangbang\n" + m[1] + "\n" + m[2] + "\n" + m[3] + "\n";


                gridPane1.addRow(i, new Text(m[1]), new Text(m[2]), new Text(m[3]));
            }

            set_MissionConfig(writeback);

            writeback = "";

            Pa_set paSet = config.getPaSet();
            System.out.println("对了   嘤嘤嘤" + config.getrightnum());
            for (int i = 1; i < achievement.length; i++) {
                System.out.println(" 卧槽 ");
                String[] m = achievement[i].split("\n");


                if (i == 1 && m[4].contains("未完")) {
                    if (config.getrightnum() == 10)//最后答对10题
                    {
                        m[4] = "已完成";
                        config.settime(config.gettime() + 900);
                    }
                } else if (i == 2 && m[4].contains("未完")) {
                    if (config.getTimesum() == Integer.parseInt(paSet.getDay_maxtime()))//到达最大限制时间
                    {
                        m[4] = "已完成";
                        config.settime(config.gettime() - 600);
                    }
                } else if (i == 3 && m[4].contains("未完")) {
                    if (config.getrightnum() >= 4 && config.getrightnum() <= 6)//40-60分之间
                    {
                        System.out.println("答错了呢嘤嘤嘤");
                        m[4] = "已完成";
                        config.settime(config.gettime() - 1800);
                    }
                } else if (i == 4 && m[4].contains("未完")) {
                    if (config.getNandu() > 9.5)//难度大于9.5
                    {
                        m[4] = "已完成";
                        config.settime(config.gettime() + 1800);
                    }
                }

                writeback = writeback + "yeyeye\n" + m[1] + "\n" + m[2] + "\n" + m[3] + "\n" + m[4] + "\n";

                gridPane2.addRow(i, new Text(m[1]), new Text(m[2]), new Text(m[3]), new Text(m[4]));
            }
            set_AchievementConfig(writeback);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backtohome() throws IOException {
        changeGUI("home.fxml", 1);
    }

    //读取本地任务
    private String[] get_MissionConfig() throws IOException {
        File file = new File("SA_config/mission_config");


        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line, sb = "";
        while ((line = br.readLine()) != null) {
            sb = sb + line + "\n";
        }
        br.close();

        String[] strarray = sb.split("bangbang");

        return strarray;
    }

    private void set_MissionConfig(String writein) {
        File file = new File("SA_config/mission_config");

        try {
            Writer out = new FileWriter(file);
            out.write(writein);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void set_AchievementConfig(String writein) {
        File file = new File("SA_config/achievement_config");

        try {
            Writer out = new FileWriter(file);
            out.write(writein);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //读取本地成就
    private String[] get_AchievementConfig() throws IOException {
        File file = new File("SA_config/achievement_config");


        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line, sb = "";
        while ((line = br.readLine()) != null) {
            sb = sb + line + "\n";
        }
        br.close();


        String[] strarray = sb.split("yeyeye");

        return strarray;
    }

}
