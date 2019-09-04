package cn.keshe.servlet;

import cn.keshe.dao.PracticeDao;
import cn.keshe.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("delete_1studentServlet")
public class delete_1studentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");//传入学生的学号

        StudentDao studentDao=new StudentDao();
        studentDao.delete(id);//传入学生学号,密码，出生日期，电话号码，QQ执行
        PracticeDao practiceDao=new PracticeDao();
        practiceDao.deleteS(id);//删除学生实习信息
        request.getRequestDispatcher("t_s_seemsgServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
