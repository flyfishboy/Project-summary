package cn.keshe.servlet;

import cn.keshe.dao.PracticeDao;
import cn.keshe.dao.StudentDao;
import cn.keshe.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("ta_change_studentServlet")
public class ta_change_studentServlet extends HttpServlet {
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

        StudentDao studentDao=new StudentDao();
        studentDao.changeall(id,name,psd,sex,bir,cla,pro,tel,qq,tid);//传入学生信息，执行
        request.getRequestDispatcher("student_msg.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
