package cn.keshe.servlet;

import cn.keshe.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("a_update_Servlet")       //管理员修改个人信息//
public class a_update_Servlet extends HttpServlet {
   private AdminDao up = new AdminDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String a_id = request.getParameter("a_id");

        String na_name = request.getParameter("na_name");
        String na_sex = request.getParameter("na_sex");

        boolean b = up.update(a_id,na_name,na_sex);
        System.out.println("a"+a_id+"a"+na_name+"修改布尔值："+b);
        response.sendRedirect("a_see_msgSerlvet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
