package SA.Config;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class getWebTime {


    private static List<String> webUrlList = new ArrayList<>();
    static{
        webUrlList.add("http://www.bjtime.cn");         //[bjtime]
        webUrlList.add("http://www.baidu.com");         //[百度]
        webUrlList.add("http://www.taobao.com");        //[淘宝]
        webUrlList.add("http://www.ntsc.ac.cn");        //[中国科学院国家授时中心]
        webUrlList.add("http://www.360.cn");            //[360安全卫士]
        webUrlList.add("http://www.beijing-time.org");  //[beijing-time]
    }

    /**
     * 获取指定网站的日期时间
     *
     * @param
     * @return
     * @author SHANHY
     * @date   2015年11月27日
     */
    public static String getWebsiteDatetime(int web_num){
        String webUrl=webUrlList.get(web_num);
        try {
            URL url = new URL(webUrl);// 取得资源对象
            URLConnection uc = url.openConnection();// 生成连接对象
            uc.connect();// 发出连接
            long ld = uc.getDate();// 读取网站日期时间
            Date date = new Date(ld);// 转换为标准时间对象
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);// 输出北京时间
            return sdf.format(date);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "NULL";
    }
}
