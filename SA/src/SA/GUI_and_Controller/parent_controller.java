package SA.GUI_and_Controller;

import SA.Config.Email;
import SA.Config.ROOT_controller;
import SA.database.entity.Pa_info;
import SA.database.entity.Pa_set;
import SA.database.entity.Stu_info;
import SA.database.services.StuService;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;

//父母修改个人信息
public class parent_controller extends ROOT_controller {

    //解锁界面
    @FXML
    private TextField id_unlock;//解锁孩子id
    @FXML
    private Label uwarn;

    //修改家长信息界面
    @FXML
    private TextField parent_id;//家长修改自己账号
    @FXML
    private TextField parent_password;//家长修改自己密码

    //注册孩子信息界面
    @FXML
    private TextField kid_id;
    @FXML
    private TextField kid_password;//注册孩子密码
    @FXML
    private TextField kid_name;//注册孩子姓名
    @FXML
    private TextField kid_grade;//注册孩子年级
    @FXML
    private TextField kid_sex;//注册孩子性别
    @FXML
    private TextField p_id;//注册家长绑定账号
    @FXML
    private TextField p_ad;//注册家长绑定邮箱
    @FXML
    private TextField kid_deg;//注册孩子难度系数
    @FXML
    private Label warn;//注册孩子界面提示框

    //设置孩子信息界面
    @FXML
    private TextField sk_id;//修改的孩子ID
    @FXML
    private TextField cpH;//可游戏时长（时）
    @FXML
    private TextField cpM;//可游戏时长（分）
    @FXML
    private TextField mpH;//最大游戏时长（时）
    @FXML
    private TextField mpM;//最大游戏时长（分）
    @FXML
    private TextField atH;//可游戏时间段（时）
    @FXML
    private TextField atM;//可游戏时间段（分）
    @FXML
    private TextArea showat;//设置孩子信息时显示设置的时间段
    @FXML
    private CheckBox tixing;//是否上线选项

    //修改孩子信息界面
    @FXML
    private TextField ckid_id;//注册孩子账号
    @FXML
    private TextField ckid_password;//注册孩子密码
    @FXML
    private TextField ckid_name;//注册孩子姓名
    @FXML
    private TextField ckid_grade;//注册孩子年级
    @FXML
    private TextField ckid_sex;//注册孩子性别
    @FXML
    private TextField cp_id;//注册家长绑定账号
    @FXML
    private TextField cp_ad;//注册家长绑定邮箱
    @FXML
    private TextField ckid_deg;//注册孩子难度系数
    @FXML
    private Label cwarn;//注册孩子界面提示框

    public void unlockID() throws IOException {
        StuService stuService = new StuService();
        String s_id = id_unlock.getText();
        Stu_info stu_info = stuService.findUserById(s_id);
        String[] parentconfig = get_parentConfig();
        String back = "0";
        Stu_info stu = new Stu_info();
        stu.setBack(back);
        stu.setS_id(s_id);
        if (id_unlock.getText().equals("")) {
            uwarn.setText("请补充id信息");
        } else {
            if (stu_info.getP_id().equals(parentconfig[1])) {
                boolean b = stuService.updatebackMes(stu);
                if (b)
                    uwarn.setText("解锁成功");
                else
                    uwarn.setText("解锁失败");
            } else {
                uwarn.setText("该信息不是你您子女信息");
            }
        }
    }


    //修改家长个人信息按钮事件
    public void change_parent() throws IOException {
        String[] parentconfig = get_parentConfig();
        StuService stuServices = new StuService();
        if (parent_id.getText().equals("") || parent_password.getText().equals("") || !(parent_id.getText().equals(parentconfig[1])))
            warn.setText("内容不能为空");
        else {
            //存储进本地
            warn.setText("修改成功");
            savelocal(parent_id.getText(), parent_password.getText());

            String p_password = parent_password.getText();
            String p_id = parent_id.getText();
            Pa_info pi = new Pa_info();
            pi.setP_id(p_id);
            pi.setP_password(p_password);
            boolean b = stuServices.alterPaMes(pi);
            if (b) {
                warn.setText("修改成功");
            } else {
                warn.setText("修改失败");
            }
        }
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


    //注册子女信息按钮事件          提交上服务器
    public void change_kid() {
        //提交上服务器
        StuService stuServices = new StuService();
        String s_id = kid_id.getText();
        String s_password = kid_password.getText();
        String s_name = kid_name.getText();
        String s_sex = kid_sex.getText();
        String s_grade = kid_grade.getText();
        String deg = kid_deg.getText();
        String pid = p_id.getText();
        String pad = p_ad.getText();
        if (kid_id.getText().equals("") || kid_name.getText().equals("") || kid_password.getText().equals(""))
            warn.setText("请补充必填信息");
        else {
            boolean isUnique = stuServices.accOnly(s_id);
            if (isUnique) {
                if (isLetterDigit(s_password) == false) {
                    String msg = "密码长度在6到12位之间且同时要有数字和字母";
                    warn.setText(msg);
                } else {
                    Stu_info stu = new Stu_info();
                    stu.setS_id(s_id);
                    stu.setS_password(s_password);
                    stu.setS_name(s_name);
                    stu.setS_sex(s_sex);
                    stu.setS_grade(s_grade);
                    stu.setAn_exp("0");
                    stu.setP_id(pid);
                    stu.setP_ad(pad);
                    stu.setDeg(deg);
                    stu.setBack("0");
                    boolean b = stuServices.userRegister(stu);
                    if (b) {
                        warn.setText("注册成功");
                        Email email = new Email();
                        try {
                            email.setEmail(pad, "您孩子的注册信息", "您孩子的ID是：" + s_id+"\n密码是："+s_password);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //返回主界面
                    } else {
                        warn.setText("出错了，请稍后重试");
                    }
                }
            } else {
                warn.setText("账号已被注册,请修改账号");
            }
        }
    }


    //设置或修改子女学习信息按钮事件          提交上服务器
    public void set_kid() throws IOException {
        //提交上服务器
        StuService stuServices = new StuService();
        Pa_set ps;
        String[] parentconfig = get_parentConfig();
        String s_id = sk_id.getText();
        String p_id = parentconfig[1];
        System.out.println(p_id);
        ps = stuServices.findPsById(s_id);
        if (ps == null) {
            String day_time = cpH.getText() + "/" + cpM.getText();
            String day_maxtime = mpH.getText() + "/" + mpM.getText();
            String day_timeran = atH.getText() + "/" + atM.getText();
            String remind = tixing.getText();
            ps = new Pa_set();
            ps.setP_id(p_id);
            ps.setS_id(s_id);
            ps.setDay_time(day_time);
            ps.setDay_maxtime(day_maxtime);
            ps.setDay_timeran(day_timeran);
            ps.setRemind(remind);
            boolean b = stuServices.insertPs(ps);
            if (b) {
                warn.setText("设置成功");
            } else {
                warn.setText("设置失败");
            }
        } else {
            String day_time = cpH.getText() + "/" + cpM.getText();
            String day_maxtime = mpH.getText() + "/" + mpM.getText();
            String day_timeran = atH.getText() + "/" + atM.getText();
            String remind = tixing.getText();
            ps.setP_id(p_id);
            ps.setS_id(s_id);
            ps.setDay_time(day_time);
            ps.setDay_maxtime(day_maxtime);
            ps.setDay_timeran(day_timeran);
            ps.setRemind(remind);
            boolean b = stuServices.alterPaset(ps);
            if (b) {
                warn.setText("设置成功");
                showat.setText(atH.getText() + " 时  /  " + atM.getText()+" 时");
            } else {
                warn.setText("设置失败");
            }
        }


    }


    //修改孩子基本信息
    public void set_kidMes() {

        //提交上服务器
        StuService stuServices = new StuService();
        String s_id = ckid_id.getText();
        String s_password = ckid_password.getText();
        String s_name = ckid_name.getText();
        String s_sex = ckid_sex.getText();
        String s_grade = ckid_grade.getText();
        String deg = ckid_deg.getText();
        String pid = cp_id.getText();
        String pad = cp_ad.getText();
        if (ckid_id.getText().equals("")) {
            cwarn.setText("请补充学生信息");
        } else {

            if (ckid_name.getText().equals("") || ckid_password.getText().equals(""))
                cwarn.setText("请补充必填信息");
            else {
                if (isLetterDigit(s_password) == false) {
                    String msg = "密码长度在6到12位之间且同时要有数字和字母";
                    cwarn.setText(msg);
                } else {
                    Stu_info stu = new Stu_info();
                    stu.setS_id(s_id);
                    stu.setS_password(s_password);
                    stu.setS_name(s_name);
                    stu.setS_sex(s_sex);
                    stu.setS_grade(s_grade);
                    stu.setAn_exp("0");
                    stu.setP_id(pid);
                    stu.setP_ad(pad);
                    stu.setDeg(deg);
                    stu.setBack("0");
                    boolean b = stuServices.updateStuMes(stu);
                    if (b) {
                        cwarn.setText("修改成功");
                    } else {
                        cwarn.setText("修改失败");
                    }
                }
            }
        }
    }

    public static boolean isLetterDigit(String password) {
        boolean isDigit = false;//定义一个boolean值，用来表示是否包含数字
        boolean isLetter = false;//定义一个boolean值，用来表示是否包含字母
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {   //用char包装类中的判断数字的方法判断每一个字符
                isDigit = true;
            } else if (Character.isLetter(password.charAt(i))) {  //用char包装类中的判断字母的方法判断每一个字符
                isLetter = true;
            }
        }
        String regex = "^[a-zA-Z0-9]{6,12}$";
        boolean isRight = isDigit && isLetter && password.matches(regex);
        return isRight;
    }


    public void savelocal(String a, String b) throws IOException {
        File file = new File("SA_config/parents_config");

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        String line, sb = "";
        while ((line = br.readLine()) != null) {
            sb = sb + line + "\n";
        }
        br.close();
        String[] strarray = sb.split("\n");

        strarray[1] = "\n" + a + "\n";
        strarray[3] = "\n" + b + "\n";

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(strarray[0] + strarray[1] + strarray[2] + strarray[3]);
        bw.close();
    }

    @Override
    public void onButtonClick() {
        System.exit(0);
    }

}
