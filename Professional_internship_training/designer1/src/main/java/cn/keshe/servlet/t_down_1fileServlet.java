package cn.keshe.servlet;

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

@WebServlet("t_down_1fileServlet")

public class t_down_1fileServlet extends HttpServlet {


    public t_down_1fileServlet() {
        super();
    }

    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name=request.getParameter("name");
        //处理请求
        //读取要下载的文件
        File f = new File("D:/KesheExcel/"+name);
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
        request.getRequestDispatcher("Teacher_downFile.jsp").forward(request,response);

    }



}