package cn.keshe.servlet;

import cn.keshe.utils.JDBCHelper;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("a_down_unitServlet")
public class a_down_unitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*教师查找自己所带学生的实习信息*/

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
        int i=1,j=0;

        File file = new File("D:/jsl_unitbiao.xls");//生成的表格存储的位置
        String[] str = {"单位名称","实习学生人数"};//标题内容
        try {
            if (!file.exists()) {//判断文件是否存在
                file.createNewFile();//创建新的文件
            }
            //创建工作簿
            WritableWorkbook workbook = Workbook.createWorkbook(file);
            //创建sheet对象
            WritableSheet sheet = workbook.createSheet("sheet1", 0);
            //行对象
            Label label = null;
        for(String li:list1)
        {

            String SQ="select count(s_id) from practice where p_unit=?";
            ResultSet r = JDBCHelper.query( SQ,li );
            if (j==0)
                //添加标题
                for (int k = 0; k < str.length; k++) {
                    /**
                     * Label(i,j,String);
                     * i:列
                     * j:行
                     * String:表示内容
                     */
                    label = new Label(k, 0, str[k]);
                    sheet.addCell(label);
                }
            j++;
            r.next();
            //添加数据
            label = new Label(0, i,li);
            sheet.addCell(label);
            label = new Label(1, i, ""+r.getInt(1));
            sheet.addCell(label);
            i++;
        }
            System.out.println("表格生成！");
            workbook.write();//把表格信息写入文件
            workbook.close();//关闭

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }

        //处理请求
        //读取要下载的文件
        File f = new File("D:/jsl_unitbiao.xls");
        if(f.exists()){
            FileInputStream fis = new FileInputStream(f);
            String filename=URLEncoder.encode(f.getName(),"utf-8"); //解决中文文件名下载后乱码的问题
            byte[] b = new byte[fis.available()];
            fis.read(b);
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Disposition","attachment; filename="+filename+"");
            //获取响应报文输出流对象
            ServletOutputStream out =response.getOutputStream();
            //输出
            out.write(b);
            out.flush();
            out.close();
        }



      //  response.sendRedirect("Admincount.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
