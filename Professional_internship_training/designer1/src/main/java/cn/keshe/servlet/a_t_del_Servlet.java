package cn.keshe.servlet;

import cn.keshe.dao.TeacherDao;
import cn.keshe.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("a_t_del_Servlet")
public class a_t_del_Servlet extends HttpServlet {
    private TeacherDao del = new TeacherDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String t_id = request.getParameter("t_id");
        boolean b = del.delete(t_id);
        System.out.println(""+b);
        request.getRequestDispatcher("a_t_find_Servlet").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
