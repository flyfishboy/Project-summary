package cn.keshe.servlet;

import cn.keshe.dao.StudentDao;
import cn.keshe.dao.TeacherDao;
import cn.keshe.entity.Student;
import cn.keshe.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("t_change_passServlet")

/**
 * 传入学生学号，可修改学生部分信息
 */
public class t_change_passServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");//传入教师的工号
        String oldpassword=request.getParameter("oldpassword");
        String pass=request.getParameter("password");//传入教师密码
        String npassword=request.getParameter("npassword");//传入教师更改后密码
        System.out.println("t_change_passServlet接收的密码为"+oldpassword+"原密码"+pass+"新密码"+npassword);
        if(pass.equals(oldpassword)){
            if(npassword.equals(pass)){
                String msg = "修改后的密码不能与原密码一致！ ";
                request.setAttribute("fmsg", msg);
                request.getRequestDispatcher("Teacheruppassword.jsp").forward(request, response);
            } else{
                TeacherDao teacherDao=new TeacherDao();
                boolean b=teacherDao.Tupdatepass(id,npassword);//传入教师学号,密码，出生日期，电话号码，QQ执行
                System.out.println("密码change获取的id："+id+"执行结果："+b);
                request.getSession().setAttribute("id",id);
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }else{
            String msg = "密码错误，请输入正确原密码 ";
            request.setAttribute("fmsg", msg);
            request.getRequestDispatcher("Teacheruppassword.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
