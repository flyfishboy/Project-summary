package cn.keshe.servlet;

import cn.keshe.dao.StudentDao;
import cn.keshe.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("s_change_msgServlet")

/**
 * 传入学生学号，可修改学生部分信息
 */
public class s_change_msgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id=request.getParameter("id");//传入学生的学号

        String psd=request.getParameter("psd");//传入学生更改后的密码
        String bir=request.getParameter("bir");//传入学生更改后的出生日期
        String tel=request.getParameter("tel");//传入学生更改后的电话号码
        String qq=request.getParameter("qq");//传入学生更改后的QQ号码

        StudentDao studentDao=new StudentDao();
        studentDao.change(id,bir,tel,qq);//传入学生学号,密码，出生日期，电话号码，QQ执行
        request.getRequestDispatcher("s_see_msgServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
