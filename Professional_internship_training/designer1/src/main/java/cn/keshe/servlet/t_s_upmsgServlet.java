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

@WebServlet("t_s_upmsgServlet")

/**
 * 传入学生学号，可修改学生部分信息
 */
public class t_s_upmsgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String old=request.getParameter("old");
        String id=request.getParameter("id");//传入学生的学号
        String name=request.getParameter("n");
        String sex=request.getParameter("sex");
        String clas=request.getParameter("c");
        String pro=request.getParameter("pro");
        String psd=request.getParameter("psd");//传入学生更改后的密码
        String bir=request.getParameter("birth");//传入学生更改后的出生日期
        String tel=request.getParameter("tel");//传入学生更改后的电话号码
        String qq=request.getParameter("q");//传入学生更改后的QQ号码

        StudentDao studentDao=new StudentDao();
        boolean b=studentDao.changemore(id,name,psd,sex,bir,clas,pro,tel,qq,old);
        PracticeDao practiceDao=new PracticeDao();
        practiceDao.changeS(old,name,sex,id);
        System.out.println("old："+old);
        request.getRequestDispatcher("t_s_seemsgServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
