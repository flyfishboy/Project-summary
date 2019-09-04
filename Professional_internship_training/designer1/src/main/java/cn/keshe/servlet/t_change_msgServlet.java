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

@WebServlet("t_change_msgServlet")

/**
 * 传入学生学号，可修改学生部分信息
 */
public class t_change_msgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id=request.getParameter("id");//传入教师的学号
        String bir=request.getParameter("bir");//传入教师更改后的出生日期
        String tel=request.getParameter("tel");//传入教师更改后的电话号码
        String pro=request.getParameter("profess");//传入教师更改后的专业
        String qq=request.getParameter("qq");//传入教师更改后的QQ号码
        TeacherDao teacherDao=new TeacherDao();
        boolean b=teacherDao.Tupdatemsg(id,bir,pro,tel,qq);//传入教师学号,密码，出生日期，电话号码，QQ执行
        System.out.println("change获取的id："+id+"执行结果："+b+"bir:"+bir);
        request.getSession().setAttribute("id",id);
        request.getRequestDispatcher("t_see_msgSerlvet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
