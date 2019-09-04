package cn.keshe.servlet;

import cn.keshe.dao.StudentDao;
import cn.keshe.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("add_s_msgServlet")
public class add_s_msgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");//传入学生的学号
        String name=request.getParameter("name");//传入学生的姓名
        String psd=request.getParameter("psd");//传入学生的初始密码
        String sex=request.getParameter("sex");//传入学生的性别
        String bir=request.getParameter("bir");//传入学生的出生日期
        String cla=request.getParameter("cla");//传入学生的班级
        String pro=request.getParameter("pro");//传入学生的专业
        String tel=request.getParameter("tel");//传入学生的电话号码
        String qq=request.getParameter("qq");//传入学生的QQ号码
        String tid=request.getParameter("tid");//传入教师工号
        String tname=request.getParameter("tname");//传入教师姓名

        Student s=new Student();
        s.setS_id(id);
        s.setS_name(name);
        s.setS_password(psd);
        s.setS_sex(sex);
        s.setS_birthday(bir);
        s.setS_class(cla);
        s.setS_profession(pro);
        s.setS_phone(tel);
        s.setS_qq(qq);
        s.setT_id(tid);
        StudentDao studentDao=new StudentDao();
        studentDao.insert(s);//传入学生信息，执行

        request.getRequestDispatcher("student_msg.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
