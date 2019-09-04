package cn.keshe.servlet;

import cn.keshe.dao.positionDao;
import cn.keshe.entity.position;
import cn.keshe.utils.JDBCHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("t_see_unitServlet")
public class t_see_unitServlet extends HttpServlet {

    // 这里是起始点                           经度   纬度    ID
    static Point START = new Point(0, 0,0);
    // 记录最短路径（默认是“无限大”表示不可达）
    static double[] minPath = {Double.MAX_VALUE,0,0,0};
    static String [][] xy;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tid=request.getParameter("tid");
        System.out.println("kkksadfsasfdasdfk"+tid);
        positionDao po=new positionDao();

        //教师查看自己学生单位的地址
        String SQL="select * from position where d_name in (select p_unit from practice where s_id in (select s_id from student where t_id=?))";
        ResultSet rs = JDBCHelper.query( SQL ,tid);
        String SQ="select count(*) from position where d_name in (select p_unit from practice where s_id in (select s_id from student where t_id=?))";
        ResultSet r = JDBCHelper.query( SQ ,tid);
        try {
            r.next();
            int changdu = r.getInt(1);
            System.out.println("kkkk" + changdu);
            String[][] xy = new String[changdu][3];

            changdu = 0;
            if (xy.length >= 2) {
            if (rs != null) {
                try {
                    while (rs.next()) {
                        xy[changdu][2] = rs.getString("d_name");
                        xy[changdu][1] = rs.getString("lat");
                        xy[changdu][0] = rs.getString("lon");
                        changdu++;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            for (position p : po.tselectt(tid)) {

                System.out.print(p.getLat()+"    "+p.getLon());
                START = new Point(Double.parseDouble(p.getLat()), Double.parseDouble(p.getLon()), 0);
            }

            double [][] xy1=new double[xy.length][xy[0].length];
            for (int x = 0; x < xy.length; x++)
                for (int y = 0; y < xy[1].length; y++)
                {
                    if(y==2)
                        xy1[x][y]=x;
                        else
                    xy1[x][y]=Float.parseFloat(xy[x][y]);
                    System.out.println(" 一共有：" + xy1[x][y] + "  " + "  ");
                }





                Point[] points = new Point[xy1.length];// 建立点集
                //循环写入点坐标
                for (int i = 0; i < xy1.length; i++) {
                    points[i] = new Point(xy1[i][0], xy1[i][1], xy1[i][2]);
                }
                //执行并输出
                double[] x = rangeAll(points, 0);

                String[] xx=new String[x.length];

                System.out.println("需要：" + x[0] + "米");

                xx[0]=x[0]/1000+"";
                for (int x1 = 1; x1 < 1 + 3 * xy.length; x1++)
                {
                    if (x1%3==0)
                    {
                        int gay=(int) x[x1];
                        xx[x1]=xy[gay][2];
                        System.out.println(gay+"yods      "+xx[x1]);
                    }
                        else
                    xx[x1]=x[x1]+"";
                    System.out.println("yooooo   "+x[x1]);
                }
                request.setAttribute("list", xx);
            }
            else
                {
                    String[] xx = {"-1"};
                    request.setAttribute("list", xx);
                }
            } catch(SQLException e){
                e.printStackTrace();
            }

        request.getRequestDispatcher("TeacherSeeUnit.jsp").forward(request,response);
    }

    /**
     * 用全排列解决此问题
     *
     * @param points
     * @param n
     */
    public  double[] rangeAll(Point[] points, int n) {
        System.out.println("需要："+"lalalalala"+"米");
        if (n == points.length) {
            // 计算这次排列的路径长度
            double []sum=new double[1+3*points.length];//0是长度，1是经度，2是纬度，3是id
            System.out.println("需要："+(1+3*points.length)+"米");
            sum[0] = points[0].getLength(START);
            sum[1]=points[0].px;
            sum[2]=points[0].py;
            sum[3]=points[0].wei;
            for (int i = 1; i < points.length; i++) {
                sum[0] += points[i - 1].getLength(points[i]);
                sum[1+3*i]=points[i].px;
                sum[2+3*i]=points[i].py;
                sum[3+3*i]=points[i].wei;
            }
            // 【千万不要忘了加上回到原点的路径】
            sum[0] += points[points.length - 1].getLength(START);
            // 记录最短长度【其实这里也可以记录下路径详情(也就是这次全排列的顺序)】
            if (minPath[0]>sum[0])
                minPath = sum;
            return minPath;
        }
        // 全排列算法部分
        for (int i = n; i < points.length; i++) {
            swap(points, n, i);
            rangeAll(points, n + 1);
            swap(points, n, i);
        }
        return minPath;
    }
    /**
     * 交换数组的i,j两个值
     *
     * @param points
     * @param i
     * @param j
     */
    public static void swap(Point[] points, int i, int j) {
        if (i == j) {
            return;
        }
        Point temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }






    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}

/**
 * 点类
 */
class Point {
    double px;
    double py;
    double wei;

    public Point(double px, double py,double wei) {
        this.px = px;
        this.py = py;
        this.wei=wei;
    }
    /**
     * 获取与指定点之间的距离
     *
     * @param p
     * @return
     */
    public double getLength(Point p) {
        double radLat1 = px* Math.PI / 180.0;
        double radLat2 = p.px* Math.PI / 180.0;
        double a = radLat1 - radLat2;
        double b = py* Math.PI / 180.0 - p.py* Math.PI / 180.0;
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * 6378.137;
        s = Math.round(s * 10000d) / 10000d;
        s = s * 1000;
        return s;
    }
}