package algorithm;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;



public class Try {

    public static void main(String[] args){


        Try.class.getClassLoader().getResource("");
        String f = Try.class.getResource("/").getPath();
        System.out.println(f);

        // Runtime.getRuntime().exec( "cmd.exe /c start D:\\My_Study\\SA\\SA_config\\create_lnk.bat ");


    }



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
}

class InvokeBat4 {
    public void runbat(String batName) {
        String cmd = "cmd /k start D:\\My_Study\\SA\\SA_config\\news.bat";// pass
        try {
            Process ps = Runtime.getRuntime().exec(cmd);
            InputStream in = ps.getInputStream();
            int c;
            while ((c = in.read()) != -1) {
                System.out.print(c);// 如果你不需要看输出，这行可以注销掉
            }
            in.close();
            ps.waitFor();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("child thread donn");
    }

    public static void main(String[] args) {
        InvokeBat4 test1 = new InvokeBat4();
        test1.runbat("news");
        System.out.println("main thread");
    }
}