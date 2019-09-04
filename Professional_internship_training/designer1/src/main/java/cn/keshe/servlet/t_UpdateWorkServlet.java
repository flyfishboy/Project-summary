package cn.keshe.servlet;

import cn.keshe.dao.PracticeDao;
import cn.keshe.dao.Practice_workDao;
import cn.keshe.dao.StudentDao;
import cn.keshe.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("t_UpdateWorkServlet")

/**
 * 传入学生学号，可修改学生部分信息
 */
public class t_UpdateWorkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String m_id=request.getParameter("m_id");
        String m_grade=request.getParameter("m_grade");

        Practice_workDao workDao=new Practice_workDao();
        boolean b=workDao.update(m_id,m_grade);
        System.out.println("执行Boolean值为："+b+"m_id:"+m_id);
        request.getRequestDispatcher("t_seeWorkServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
