package cn.keshe.servlet;

import cn.keshe.dao.StudentDao;
import cn.keshe.entity.Student;
import cn.keshe.utils.JDBCHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("t_s_see1msgServlet")

/**
 * 传入学生的学号，传出学生一切可视信息
 */
public class t_s_see1msgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao studentDao=new StudentDao();
        String id= (String) request.getParameter("id");
        String type= (String) request.getParameter("type");
        //String type= (String) request.getSession().getAttribute("type");

        Student s=studentDao.loadByUsername(id);//输入学生学号
        String n=s.getS_name();
        String psd=s.getS_password();
        String sex=s.getS_sex();
        String d=s.getS_birthday();
        String tel=s.getS_phone();
        String q=s.getS_qq();
        String c=s.getS_class();
        String p=s.getS_profession();
        String teaid=s.getT_id();
        System.out.println("收到的学生id为："+id+"类型为："+type+"性别："+sex);
        //传出数据  不想查什么删哪条就行
        request.getSession().setAttribute("s_id",id);//学号
        request.getSession().setAttribute("s_n",n);//姓名
        request.getSession().setAttribute("s_psd",psd);//密码
        request.getSession().setAttribute("s_sex",sex);//性别
        request.getSession().setAttribute("s_d",d);//出生日期
        request.getSession().setAttribute("s_c",c);//班级
        request.getSession().setAttribute("s_p",p);//专业
        request.getSession().setAttribute("s_tel",tel);//电话
        request.getSession().setAttribute("s_q",q);//QQ
        request.setAttribute("teaid",teaid);//老师工号
        //带回去
        request.getRequestDispatcher("TeacherupSmsg.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
