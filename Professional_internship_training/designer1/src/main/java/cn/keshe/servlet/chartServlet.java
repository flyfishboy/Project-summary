package cn.keshe.servlet;

import cn.keshe.utils.JDBCHelper;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.TextAnchor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("chartServlet")
public class chartServlet extends HttpServlet {

        /**
         *
         * Module: BarServlet.java
         * Description: 条形图用java代码来书写
         * Company:
         * Asiainfo Author: pantaipeng
         * Date: Dec 15, 2011
         */

//C:\Users\Administrator\AppData\Local\Temp

            private static final long serialVersionUID = 1L;
            // 访问此servlet的url为：http://localhost:8080/JFreeChart/BarServlet?num=2
            public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
                //获得回话的session对象,ServletUtilities类的saveChartAsPNG方法需要用时把session放进去
                //HttpSession session = request.getSession();
                /**解决servlet输出的中文乱码问题，这里的乱码和条形图中的乱码可是两种不同的乱码
                 * 如果使用response.getWriter()方法获得对象，则setContentType方法必须放在获得out对象之前
                 * 如果使用response.getOutputStream()方法获得对象，则setContentType方法放在获得out对象之前或之后都可以
                 * */
                response.setContentType("text/html; charset=GBK");
                PrintWriter out = response.getWriter();
                //ServletOutputStream out = response.getOutputStream();

                //response.setCharacterEncoding("GBK");

              //  String num = request.getParameter("num");//获得请求url的参数，用来判断是显示第几个条形图示例

                /*
                 * 为了少新建文件，也为了少配置web.xml文件，把条形图的介绍都放在一个servlet中了，
                 * 每个if分支都是独立的，调用四个不同的方法，实现四个不同效果的条形图，从1到4，功能依次增强
                 */
                String filename ="";//定义一个公共变量，保存生成的名称

              //  if (num.equals("1")) {
                    out.print("<b>第一种情况，一个简单的条形图</b><br><h1></h1>");
                    filename = bar1();
                    System.out.println(filename);
               /* } else if (num.equals("2")) {
                    out.print("<b>第二种情况，各种不同颜色的条形图</b><br><h1></h1>");
                    filename = bar2();
                } else if (num.equals("3")) {
                    out.print("<b>第三种情况，多个条形图对比</b><br><h1></h1>");
                    filename = bar3();
                } else if (num.equals("4")) {
                    out.print("<b>第四种情况，多个条形图对比并且每个条形图上面加上数字</b><br><h1></h1>");
                    filename = bar4();
                } else {
                    out.println("<b>输入的url不对，请输入1、2、3、4 来查看不同的条形图</b><br><h1></h1>");
                }*/

                /*
                String graphURL = request.getContextPath() + "/DisplayChart?filename="
                        + filename;// 调用jfreechart的处理类
                */
                String graphURL ="image" + "/DisplayChart?filename=" + filename;


                System.out.println("asdfa       "+graphURL);


                /*

                // 条形图的输出
                //---------------start---------------
                out.println("<html>");
                out.println("<body>");
                out.println("<img src=" + graphURL + ""  + filename + "/>");
                out.println("</body>");
                out.println("</html>");
                //---------------end---------------
                out.flush();//刷新该流的缓冲
                out.close();//关闭该流并释放与之关联的所有系统资源
                */

                File startFile = new File("C:/Users/Administrator/AppData/Local/Temp/"+filename);
                File tmpFile = new File("E:/大三上学期作业/综合课设/designer1/src/main/webapp/image/");//获取文件夹路径

                System.out.println("C:/Users/Administrator/AppData/Local/Temp"+filename);
                System.out.println("D:/My_Study/JAVA学习/FinallyKeShe/designer1/src/main/webapp/image" + filename);

                startFile.renameTo(new File("E:/大三上学期作业/综合课设/designer1/src/main/webapp/image/" + filename));
                    System.out.println("File is moved successful!");

                request.setAttribute("graphURL",filename);
                request.getRequestDispatcher("Admincount.jsp").forward(request,response);
            }
            //加上接受post请求的处理方法，实质也还是调用doGet方法来处理
            public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
                this.doPost(request, response);
            }
            //条形图示例1 一个简单的条形图
            public String bar1() throws IOException{
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                // 设置填充数据





                ArrayList<String> list1=new ArrayList<>();
                String SQL="select distinct p_unit from practice ";
                ResultSet rs = JDBCHelper.query( SQL );

                if( rs != null ){
                    try {
                        while (rs.next()) {
                            list1.add(rs.getString("p_unit"));
                        }
                    }catch( SQLException e){
                        e.printStackTrace();
                    }
                }


                try {
                for(String li:list1)
                {

                    String SQ="select count(s_id) from practice where p_unit=?";
                    ResultSet r = JDBCHelper.query( SQ,li );

                    r.next();
                    //添加数据
                    dataset.addValue(r.getInt(1), li, li);

                }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

/*
                dataset.addValue(25, "襄阳", "襄城");
                dataset.addValue(20, "襄阳", "樊城");
                dataset.addValue(15, "襄阳", "襄州");
                dataset.addValue(10, "襄阳", "东津");
                dataset.addValue(5, "襄阳", "鱼梁州");

*/

                /**
                 * ChartFactory类的createBarChart3D方法参数介绍：
                 * createBarChart3D
                 * (
                 * String title, 图表标题
                 * String categoryAxisLabel, 统计种类轴标题，可以理解为X轴标题
                 * String valueAxisLabel,统计值轴标题，可以理解为y轴标题
                 * CategoryDataset dataset, 绘图数据集
                 * PlotOrientation orientation, 用于设置柱形图的绘制方向，PlotOrientation.VERTICAL（垂直），PlotOrientation.HORIZONTAL（水平）
                 * boolean legend, 用于设定是否显示图例
                 * boolean tooltips, 用于设定是否采用标准生成器
                 * boolean urls 用于设置定否包生成链接
                 * )
                 */
                JFreeChart chart = ChartFactory.createBarChart3D("公司实习人数图", "公司名称",
                        "人数(单位：个)", dataset, PlotOrientation.VERTICAL, true,
                        false, false);

                // 设置主标题指定字体，解决中文乱码
                Font font = new Font("宋体", Font.BOLD, 20);
                TextTitle title = new TextTitle("公司实习人数图", font);
                chart.setTitle(title);
                /* 以上三句和下面的一句效果是一样的 */
                // chart.setTitle(new TextTitle("襄阳城区人口统计(主标题)",new
                // Font("宋体",Font.BOLD,20)));
                CategoryPlot plot = chart.getCategoryPlot();
                //获得横轴对象，并设置相关的绘图属性
                CategoryAxis domainAxis = plot.getDomainAxis();
                domainAxis.setAxisLineStroke(new BasicStroke(1.6f));  // 设置轴线粗细
                domainAxis.setAxisLinePaint(Color.BLACK);             //设置轴线颜色
                domainAxis.setCategoryLabelPositionOffset(5);         //设置统计种类与轴线的颜色
                domainAxis.setLabelPaint(Color.BLACK);                //设置坐标轴标题颜色
                domainAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);// 设置坐标轴标题旋转角度
                /*------设置X轴坐标上的文字,解决中文乱码-----------*/
                /* 本例指的是襄城、樊城、襄州、东津、鱼梁州这些字 */
                domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 15));
                /*------设置X轴的标题文字,解决中文乱码------------*/
                /* 本例指的是"地区"两个字 */
                domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 15));

                //获得纵轴对象，并设置相关的绘图属性
                ValueAxis rangeAxis = plot.getRangeAxis();
                rangeAxis.setAxisLineStroke(new BasicStroke(1.0f));       //设置轴线粗细
                rangeAxis.setAxisLinePaint(Color.RED);                    // 设置轴线颜色
                rangeAxis.setUpperBound(30.0f);                           // 设置坐标最大值
                rangeAxis.setTickMarkStroke(new BasicStroke(1.6f));       //设置坐标标记大小
                rangeAxis.setTickMarkPaint(Color.BLACK);                  // 设置坐标标记颜色
                rangeAxis.setLabelPaint(Color.BLACK);                     //设置坐标轴标题颜色
                rangeAxis.setLabelAngle(Math.PI / 2);                     //设置坐标轴标题旋转角度
                rangeAxis.setLabelFont(new Font("黑体", Font.PLAIN, 15)); //设置Y轴的标题文字,解决中文乱码
                rangeAxis.setUpperMargin(0.15);                           //设置最高一个柱与图片顶端的距离
                rangeAxis.setLowerMargin(0.15);                           //设置最低的一个柱与图片底端的距离

                //也可以通过NumberAxis的方法解决y轴中文乱码问题
                /*------设置Y轴的标题文字,解决中文乱码------------*/
                // 本例中指的是"销量"两个字
                //NumberAxis numberaxis = (NumberAxis) plot.getRangeAxis();
                //numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 15));
                /*------设置Y轴坐标上的文字,解决中文乱码------------*/
                /* 本例中指的是"0,25,50..."这些值,因为本来这些就是数值，所以有没有此句都可以 */
                // numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN,
                // 15));

                /*------解决底部汉字乱码的问题，如过程序没有底部，下面的一行代码如果释放的话会报空指针的错误-----------*/
                chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 15));//显示的是dataset.addValue中的值"襄阳"
                /**
                 * ServletUtilities类的saveChartAsPNG方法参数介绍：
                 * saveChartAsPNG(
                 * JFreeChart chart, chart对象
                 * int width, 图片的宽度
                 * int height, 图片的高度
                 * ChartRenderingInfo info,info对象，可以为null
                 * HttpSession session session对象，可以为null
                 * )
                 */

                String filename = ServletUtilities.saveChartAsPNG(chart, 400, 250, null);
                /**
                 * 使用writeImageMap方法输出图片 <?暂时还有问题，后期会修改?>
                 ChartRenderingInfo info=new ChartRenderingInfo(new StandardEntityCollection());
                 ChartUtilities.writeImageMap(out, filename, info, true);
                 */
                return filename;
            }
            //条形图示例2 一个不同颜色的条形图
            public String bar2() throws IOException {
                double[][] data = new double[][] { {25},{ 20 }, { 15 }, { 10 }, { 5 } };
                String[] rowKeys = { "襄城", "樊城", "襄州", "东津","鱼梁州" };
                String[] columnKeys = { "" };
                CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
                        rowKeys, columnKeys, data);
                JFreeChart chart = ChartFactory.createBarChart3D("襄阳城区人口统计", "地区", "人口", dataset, PlotOrientation.VERTICAL, true, false, false);
                //设置主标题指定字体，解决中文乱码
                Font font = new Font("宋体", Font.BOLD, 16);
                TextTitle title = new TextTitle("襄阳城区人口统计(主标题)", font);
                chart.setTitle(title);

                CategoryPlot plot = chart.getCategoryPlot();
                NumberAxis numberaxis = (NumberAxis) plot.getRangeAxis();
                CategoryAxis domainAxis = plot.getDomainAxis();
                /*------设置X轴坐标上的文字-----------*/
                //domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
                /*------设置X轴的标题文字------------*/
                domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
                /*------设置Y轴坐标上的文字-----------*/
                //numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
                /*------设置Y轴的标题文字------------*/
                numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));

                /*------解决底部汉字乱码的问题-----------*/
                chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));
                String filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, null);
                return filename;
            }

            //条形图示例3 多个条形图对比
            public String bar3() throws IOException {
                double[][] data = new double[][] { { 1310, 1220, 1110, 1000 ,666},
                        { 720, 700, 680, 640 ,777}, { 1130, 1020, 980, 800 ,888},
                        { 440, 400, 360, 300 ,999} ,{400,400,400,400,555}};

                String[] rowKeys = { "猪肉", "牛肉", "鸡肉", "鱼肉","羊肉" };
                String[] columnKeys = { "襄城", "樊城", "襄州", "东津","鱼梁州" };
                CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
                        rowKeys, columnKeys, data);
                JFreeChart chart = ChartFactory
                        .createBarChart3D("襄阳各区肉类销量统计图", "地区", "销量", dataset,
                                PlotOrientation.VERTICAL, true, false, false);
                //设置主标题指定字体，解决中文乱码
                Font font = new Font("宋体", Font.BOLD, 16);
                TextTitle title = new TextTitle("肉类销量统计图(主标题)", font);
                chart.setTitle(title);

                CategoryPlot plot = chart.getCategoryPlot();
                NumberAxis numberaxis = (NumberAxis) plot.getRangeAxis();
                CategoryAxis domainAxis = plot.getDomainAxis();
                /*------设置X轴坐标上的文字-----------*/
                domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
                /*------设置X轴的标题文字------------*/
                domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
                /*------设置Y轴坐标上的文字-----------*/
                //numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
                /*------设置Y轴的标题文字------------*/
                numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));

                /*------解决底部汉字乱码的问题-----------*/
                chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));
                String filename = ServletUtilities
                        .saveChartAsPNG(chart, 500, 300, null);
                return filename;
            }

            //条形图示例4 多个条形图对比并且每个条形图上面加上数字
            public String bar4() throws IOException {
                double[][] data = new double[][] { { 1310, 1220, 1110, 1000 ,666},
                        { 720, 700, 680, 640 ,777}, { 1130, 1020, 980, 800,888 },
                        { 440, 400, 360, 300 ,999} ,{400,400,400,400,555}};

                String[] rowKeys = { "猪肉", "牛肉", "鸡肉", "鱼肉" ,"羊肉"};
                String[] columnKeys = { "襄城", "樊城", "襄州", "东津","鱼梁州" };
                CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
                        rowKeys, columnKeys, data);
                JFreeChart chart = ChartFactory.createBarChart3D("襄阳各区肉类销量统计图", "地区",
                        "销量", dataset, PlotOrientation.VERTICAL, true, true, false);

                CategoryPlot plot = chart.getCategoryPlot();

                //设置网格背景颜色
                plot.setBackgroundPaint(Color.white);
                //设置网络竖线颜色
                plot.setDomainGridlinePaint(Color.pink);
                //显示每个柱的数值，并修改该数字的字体属性
                BarRenderer3D renderer = new BarRenderer3D();
                renderer
                        .setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
                renderer.setBaseItemLabelsVisible(true);
                //默认的数字显示在柱子中，通过以下两句调整数字的显示
                //注意，此句很关键，若无此句，那数字的显示会覆盖，给人数字没有显示出来的问题
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
                        ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
                renderer.setItemLabelAnchorOffset(10D);
                //设置每个地区所包含的平行柱的之间的距离
                //renderer.setItemMargin(0.3);
                plot.setRenderer(renderer);

                //设置地区、销量的显示位置
                //将下方的“肉类”放到上方
                plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
                //将默认的左边的“销量”放到右方
                plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
                NumberAxis numberaxis = (NumberAxis) plot.getRangeAxis();
                CategoryAxis domainAxis = plot.getDomainAxis();
                //图表标题以及副标题乱码
                Font font = new Font("宋体", Font.BOLD, 16);
                TextTitle title = new TextTitle("襄阳", font);//副标题
                TextTitle subtitle = new TextTitle("肉类销量统计图", new Font("黑体", Font.BOLD,
                        12));
                chart.addSubtitle(subtitle);//子标题
                chart.setTitle(title); //标题

                //X轴乱码
                //X轴坐标上的文字：
                domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));
                //X轴坐标标题（肉类）
                domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));
                //Y轴坐标上的文字
                numberaxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));
                //Y轴坐标标题（销量）：
                numberaxis.setLabelFont(new Font("黑体", Font.PLAIN, 12));
                //图表底部乱码（猪肉等文字）
                chart.getLegend().setItemFont(new Font("黑体", Font.PLAIN, 12));
                String filename = ServletUtilities
                        .saveChartAsPNG(chart, 700, 400, null);
                return filename;
            }

    }

