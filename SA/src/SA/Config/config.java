package SA.Config;

import SA.database.entity.Pa_set;
import SA.database.entity.Stu_info;

//界面之间的数据传输
public class config {
    private int time = 0;  //剩余可游戏时间
    private int timesum=0;  //当前累计游戏时间
    private Pa_set paSet;//学生上机设置信息
    private Stu_info stuInfo;//学生个人信息

    private String id = "";  //登录学生对应的数据库id（方便查询数据库）

    private double nandu;//难度系数
    private String nianji;//年级

    private int rightnum = 0;  //选择正确的数量

    private int rightnumsum=0;//累计答对正确的数量

    private int[] answer = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};  //study中返回的选项ABCD(1,2,3,4)
    private int[] rightanswer = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};  //服务器中返回的正确选项ABCD(1,2,3,4)

    private Boolean isKing;//是否是房主

    private int f_id;        //对战表ID  方便查找修改
    private String[] Kingtimu=new String[0] ;//房主的题目序列

    private int rightnum2=0; //对方玩家选择正确的数量

    //初始化
    public config() {
        this.rightnumsum=0;
    }

    //设置学生ID
    public void setid(String id) {
        this.id = id;
    }

    //返回学生ID
    public String getid() {
        return this.id;
    }

    //设置剩余时间
    public void settime(int time) {
        this.time = time;
    }

    //返回剩余时间
    public int gettime() {
        return this.time;
    }


    //输入第几题n，选项t，存入config
    public void setanswer(int n, int t) {
        this.answer[n] = t;
    }

    //返回对应题号t的已选择答案（如未选返回0）
    public int getanswer(int t) {
        return this.answer[t];
    }

    //返回是否从服务器读取了答案或者是否已经提交（如未选返回0）
    public boolean getrightanswer() {
        if (this.rightanswer[0] != 0)
            return true;
        else
            return false;
    }

    //设置正确答案数组
    public void setrightanswer(int[] t) {
        this.rightanswer = t;
    }

    //交卷检测正确题数并保存
    public void check() {
        this.rightnum = 0;
        for (int b = 0; b < 10; b++) {
            if (this.rightanswer[b] == this.answer[b] && this.answer[b] != 0) {
                this.rightnum++;
            }

            this.answer[b] = 0;
            this.rightanswer[b] = 0;
        }
        this.rightnumsum+=this.rightnum;
    }

    //返回答对题的数量
    public int getrightnum() {
        return this.rightnum;
    }


    public void setrightnum2(int a){
        this.rightnum2=a;
    }

    //返回对方答对题的数量
    public int getrightnum2() {
        return this.rightnum2;
    }

    //时间减少一秒
    public void timeless() {
        this.time--;
    }

    //增加剩余时间
    public void addtime(int time) {
        this.time += time;
    }

    //减少剩余时间
    public void minuetime(int time) {
        this.time -= time;
    }

    public void setKing(Boolean king) {
        isKing = king;
    }

    public Boolean getKing() {
        return isKing;
    }

    public String[] getKingtimu() {
        return Kingtimu;
    }

    public void setKingtimu(String[] kingtimu) {
        Kingtimu = kingtimu;
    }

    public String getNianji() {
        return nianji;
    }

    public void setNianji(String nianji) {
        this.nianji = nianji;
    }

    public double getNandu() {
        return nandu;
    }

    public void setNandu(double nandu) {
        this.nandu = nandu;
    }

    public int getTimesum() {
        return timesum;
    }

    //累计时间+1
    public void setTimesum() {
        this.timesum ++;
    }

    public Pa_set getPaSet() {
        return paSet;
    }

    public void setPaSet(Pa_set paSet) {
        this.paSet = paSet;
    }

    public Stu_info getStuInfo() {
        return stuInfo;
    }

    public void setStuInfo(Stu_info stuInfo) {
        this.stuInfo = stuInfo;
    }

    public int getRightnumsum() {
        return rightnumsum;
    }

    public int getF_id() {
        return f_id;
    }

    public void setF_id(int f_id) {
        this.f_id = f_id;
    }
}
