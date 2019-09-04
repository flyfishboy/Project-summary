package cn.keshe.servlet;

import cn.keshe.dao.fileDao;
import cn.keshe.entity.Practice_work;
import cn.keshe.entity.Student;
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

@WebServlet( "a_down_s_countServlet")
public class a_down_s_countServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        fileDao fi=new fileDao();

        ArrayList<Practice_work> list1=new ArrayList<>();
        //ArrayList<file> list=new ArrayList<>();
        String SQL="select * from practice_work where s_id=0";
        ResultSet rs = JDBCHelper.query( SQL );
        list1=arraylist(rs);//所有任务

        ArrayList<Student> list0=new ArrayList<>();

        String tit="";
        ResultSet rs1;
        String SQ;

        int i=1,j=0;


        File file = new File("D:/jsl_biao.xls");//生成的表格存储的位置
        String[] str = {"未提交的任务名称", "未提交的学生学号", "布置作业的教师工号"};//标题内容
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

        for(Practice_work m:list1) {
            tit = m.getM_title();
            SQ = "select * from student where s_id not in (select s_id from file where workname=?);";
            rs1 = JDBCHelper.query(SQ, tit);
            list0 = wrap(rs1);//所有某次作业没交的学生信息
            for (Student n : list0) {
                // n.getS_id();
                // m.getM_title();
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
                    //添加数据
                        label = new Label(0, i, m.getM_title());System.out.print( m.getM_title()+"   ");
                        sheet.addCell(label);
                        label = new Label(1, i, n.getS_id());System.out.print( n.getS_id()+"   " );
                        sheet.addCell(label);
                        label = new Label(2, i, m.getT_id());System.out.print(m.getT_id()+"\n");
                        sheet.addCell(label);
                        i++;
                System.out.println(i+"    " +list0.size()+"表格:  "+m.getM_title()+"  "+n.getS_id()+"  "+m.getT_id());
                }
            label = new Label(0, i, "");
            sheet.addCell(label);
            label = new Label(1, i, "");
            sheet.addCell(label);
            label = new Label(2, i, "");
            sheet.addCell(label);
            i++;
                System.out.println("表格生成！");
            }
            workbook.write();//把表格信息写入文件
            workbook.close();//关闭

            } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }

        //处理请求
        //读取要下载的文件
        File f = new File("D:/jsl_biao.xls");
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


        //response.sendRedirect("Admincount.jsp");
        }





    private ArrayList<Student> wrap (ResultSet rs ){
                ArrayList<Student> listp=new ArrayList<>();
                Student E=null;
                if( rs != null ){
                    try {
                        while (rs.next()) {
                            E = new Student();
                            E.setS_id(rs.getString("s_id"));
                            E.setS_name(rs.getString("s_name"));
                            E.setS_password(rs.getString("s_password"));
                            E.setS_sex(rs.getString("s_sex"));
                            E.setS_birthday(rs.getString("s_birthday"));
                            E.setS_class(rs.getString("s_class"));
                            E.setS_profession(rs.getString("s_profession"));
                            E.setS_phone(rs.getString("s_phone"));
                            E.setS_qq(rs.getString("s_qq"));
                            E.setT_id(rs.getString("t_id"));
                            listp.add(E);
                        }

            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return listp ;
    }

    private ArrayList arraylist(ResultSet rs) {
        ArrayList<Practice_work> listp=new ArrayList<>();
        Practice_work E=null;
        if( rs != null ){
            try {
                while (rs.next()) {
                    E = new Practice_work();
                    E.setM_id(rs.getString("m_id"));
                    E.setM_title(rs.getString("m_title"));
                    E.setM_content(rs.getString("m_content"));
                    E.setM_date(rs.getString("m_date"));
                    E.setM_grade(rs.getFloat("m_grade"));
                    E.setS_id(rs.getString("s_id"));
                    E.setT_id(rs.getString("t_id"));
                    listp.add(E);
                }
            }catch( SQLException e){
                e.printStackTrace();
            }
        }
        return listp;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
