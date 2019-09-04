package cn.keshe.servlet;

import cn.keshe.dao.AdminDao;
import cn.keshe.entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("a_add_Servlet")    //管理员添加//
public class a_add_Servlet extends HttpServlet {
    private AdminDao dd = new AdminDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String a_id = request.getParameter("a_id");
        String a_name = request.getParameter("a_name");
        String a_password = request.getParameter("a_password");
        String a_sex = request.getParameter("a_sex");

        Admin a= new Admin();
        a.setA_id(a_id);
        a.setA_name(a_name);
        a.setA_password(a_password);
        a.setA_sex(a_sex);

        boolean d = dd.insert(a);
        request.getRequestDispatcher("a_find_Servlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doPost(request,response);
    }
}
