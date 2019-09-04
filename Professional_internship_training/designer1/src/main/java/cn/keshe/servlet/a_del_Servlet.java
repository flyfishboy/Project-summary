package cn.keshe.servlet;

import cn.keshe.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("a_del_Servlet")
public class a_del_Servlet extends HttpServlet {
    private AdminDao del = new AdminDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     request.setCharacterEncoding("UTF-8");
        String a_id = request.getParameter("a_id");
        boolean b = del.delete(a_id);
        request.getRequestDispatcher("a_find_Servlet").forward(request,response);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

     doPost(request,response);
    }
}
