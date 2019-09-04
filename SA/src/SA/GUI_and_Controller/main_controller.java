package SA.GUI_and_Controller;

import SA.Config.ROOT_controller;
import SA.Config.getWebTime;
import SA.database.entity.Pa_set;
import SA.database.entity.Stu_info;
import SA.database.services.StuService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;

public class main_controller extends ROOT_controller {
    @FXML
    private TextField login_name; //输入的登录账号
    @FXML
    private PasswordField login_password; //输入的登录密码
    @FXML
    private Label rest1;//信息提示栏
    @FXML
    private MenuButton choosebutton;

    private int[] choose = {0, 0};
    private StuService stuServices;


    // 写入快捷方式 是否自启动，快捷方式的名称，注意后缀是lnk
    private boolean setAutoStart(boolean yesAutoStart, String lnk) {
        File f = new File(lnk);
        String p = f.getAbsolutePath();
        String startFolder = "";
        String osName = System.getProperty("os.name");
        String str = System.getProperty("user.home");
        if (osName.equals("Windows 7") || osName.equals("Windows 8") || osName.equals("Windows 10")
                || osName.equals("Windows Server 2012 R2") || osName.equals("Windows Server 2014 R2")
                || osName.equals("Windows Server 2016")) {
            startFolder = System.getProperty("user.home")
                    + "\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup";
        }
        if (osName.endsWith("Windows XP")) {
            startFolder = System.getProperty("user.home") + "\\「开始」菜单\\程序\\启动";
        }
        if (setRunBySys(yesAutoStart, p, startFolder, lnk)) {
            return true;
        }
        return false;
    }

    // 设置是否随系统启动
    private boolean setRunBySys(boolean b, String path, String path2, String lnk) {
        File file = new File(path2 + "\\" + lnk);
        Runtime run = Runtime.getRuntime();
        File f = new File(lnk);

        // 复制
        try {
            if (b) {
                // 写入
                // 判断是否隐藏，注意用系统copy布置为何隐藏文件不生效
                if (f.isHidden()) {
                    // 取消隐藏
                    try {
                        Runtime.getRuntime().exec("attrib -H \"" + path + "\"");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (!file.exists()) {
                    run.exec("cmd /c copy " + formatPath(path) + " " + formatPath(path2));
                }
                // 延迟0.5秒防止复制需要时间
                Thread.sleep(500);
            } else {
                // 删除
                if (file.exists()) {
                    if (file.isHidden()) {
                        // 取消隐藏
                        try {
                            Runtime.getRuntime().exec("attrib -H \"" + file.getAbsolutePath() + "\"");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Thread.sleep(500);
                    }
                    run.exec("cmd /c del " + formatPath(file.getAbsolutePath()));
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 解决路径中空格问题
    private String formatPath(String path) {
        if (path == null) {
            return "";
        }
        return path.replaceAll(" ", "\" \"");
    }


    //登录按钮事件
    public void login() throws IOException {


        setAutoStart(true, "SA_config/学习监督管理系统.lnk");


        String[] parentconfig = get_parentConfig();

        if (choose[0] == 0 && choose[1] == 0)
            rest1.setText("请选择登录用户");
        else if (choose[1] == 1)  //家长密码
        {
            if (login_name.getText().equals(parentconfig[1]) && login_password.getText().equals(parentconfig[3])) {
                changeGUI("parent.fxml", 0);
            } else
                rest1.setText("密码错误");
        }

        //学生模式
        else {

            //是否有网络
            if (!getWebTime.getWebsiteDatetime(4).equals("NULL")) {

                //调用函数查找id对应密码和信息，存入config
                stuServices = new StuService();


                String s_id = login_name.getText();
                String password = login_password.getText();

                boolean b = stuServices.stuLogin(s_id, password);  //原登录
                //检查有没有该账号


                //如果选择学生登录
                if (b && choose[0] == 1) {

                    config.setPaSet(stuServices.findPsById(s_id));
                    config.setStuInfo(stuServices.findUserById(s_id));

                    Pa_set paSet = config.getPaSet();
                    Stu_info stuInfo = config.getStuInfo();

                    //查询是否是正常登录，如上次非法退出将锁死（默认正常退出为0，不正常为1）

                    if (stuInfo.getBack().equals("1")) {
                        rest1.setText("该用户账号异常，请联系家长或管理员解锁（上次未正常退出）");
                    } else {


                        //从服务器读取账号剩余时间
                        config.settime(Integer.parseInt(paSet.getDay_time())); //单位（秒）

                        //从服务器读取学生账号
                        config.setid(s_id);

                        //从服务器读取学生年级
                        config.setNianji(stuInfo.getS_grade());

                        //从服务器读取学生难度系数
                        config.setNandu(Double.parseDouble(stuInfo.getDeg()));

                        System.out.println(stuInfo.getDeg());


                        //设置服务器中退出值为 1
                        stuInfo.setBack("1");
                        stuServices.updateStuMes(stuInfo);

                        //进入学生主界面
                        changeGUI("home.fxml", 1);
                    }

                } else
                    rest1.setText("用户名或密码错误");
            } else
                rest1.setText("当前无网络连接");
        }
    }

    //fxml界面函数
    public void c_s() {
        this.choose[0] = 1;
        this.choose[1] = 0;
        this.choosebutton.setText("学生");
    }

    //fxml界面函数
    public void c_f() {
        this.choose[1] = 1;
        this.choose[0] = 0;
        this.choosebutton.setText("家长");
    }

    //读取本地家长账号密码
    private String[] get_parentConfig() throws IOException {
        File file = new File("SA_config/parents_config");


        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line, sb = "";
        while ((line = br.readLine()) != null) {
            sb = sb + line + "\n";
        }
        br.close();
        String[] strarray = sb.split("\n");

        return strarray;
    }

    @Override
    public void shutdownWindows() {
        try {
            Runtime.getRuntime().exec("cmd /c shutdown /s /t 0");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

