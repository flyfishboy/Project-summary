package cn.keshe.servlet;

import cn.keshe.dao.StudentDao;
import cn.keshe.dao.TeacherDao;
import cn.keshe.entity.Student;
import cn.keshe.entity.Teacher;
import cn.keshe.utils.JDBCHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("s_see_msgServlet")

/**
 * 传入学生的学号，传出学生一切可视信息
 */
public class s_see_msgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao studentDao=new StudentDao();
        String id= (String) request.getSession().getAttribute("id");
        String type= (String) request.getSession().getAttribute("type");
        System.out.println("收到的学生id为："+id);
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
        String tea=null;
        if(teaid==null){
            tea=null;
        }else{
            TeacherDao teacherDao=new TeacherDao();
            Teacher teacher=teacherDao.loadByUsername(teaid);
            tea=teacher.getT_name() ;
        }


        //传出数据  不想查什么删哪条就行
        request.getSession().setAttribute("id",id);//学号
        request.getSession().setAttribute("n",n);//姓名
        request.getSession().setAttribute("psd",psd);//密码
        request.getSession().setAttribute("sex",sex);//性别
        request.setAttribute("d",d);//出生日期
        request.setAttribute("c",c);//班级
        request.setAttribute("p",p);//专业
        request.setAttribute("tel",tel);//电话
        request.setAttribute("q",q);//QQ
        request.setAttribute("teaid",teaid);//老师工号
        if(tea.equals(null)){
            request.setAttribute("tea",null);
            request.getSession().setAttribute("tea",null);//老师姓名
        }else{
            request.setAttribute("tea",tea);
            request.getSession().setAttribute("tea",tea);//老师姓名
        }

        //带回去
        System.out.println("老师工号："+id+"姓名:"+tea);
        request.getRequestDispatcher("StudentMessage.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
