package cn.keshe.servlet;

import cn.keshe.dao.PracticeDao;
import cn.keshe.dao.Practice_workDao;
import cn.keshe.dao.StudentDao;
import cn.keshe.entity.Practice;
import cn.keshe.entity.Practice_work;
import cn.keshe.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("t_AddWorkServlet")
public class t_AddWorkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=(String)request.getSession().getAttribute("id");
        String s_id=request.getParameter("s_id");//传入学生的学号
        String m_title=request.getParameter("m_title");
        String m_date=request.getParameter("m_date");
        String m_content=request.getParameter("m_content");
        float m_grade=-1;
        Practice_work p=new Practice_work();
        p.setS_id(s_id);
        p.setT_id(id);
        p.setM_title(m_title);
        p.setM_date(m_date);
        p.setM_content(m_content);
        p.setM_grade(m_grade);
        Practice_workDao workDao=new Practice_workDao();
        Boolean b= workDao.insert(p);//传入实习信息，执行
        System.out.println("执行结果："+b+"标题为："+m_title+"内容："+m_content+"时间"+m_date+"分数："+m_grade+"学生Id:"+s_id);
        request.getRequestDispatcher("t_seeWorkServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
