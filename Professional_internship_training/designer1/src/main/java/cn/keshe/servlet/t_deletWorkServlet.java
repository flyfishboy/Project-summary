package cn.keshe.servlet;

import cn.keshe.dao.PracticeDao;
import cn.keshe.dao.Practice_workDao;
import cn.keshe.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("t_deletWorkServlet")
public class t_deletWorkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p_id=request.getParameter("m_id");//传入实习编号
        Practice_workDao workDao=new Practice_workDao();
       boolean b= workDao.delete(p_id);
        request.getRequestDispatcher("t_seeWorkServlet").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
