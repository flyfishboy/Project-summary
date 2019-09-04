package cn.keshe.servlet;

import cn.keshe.dao.AdminDao;
import cn.keshe.entity.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("a_see_msgSerlvet")


public class a_see_msgServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDao adminDao=new AdminDao();
        String id= (String) request.getSession().getAttribute("id");
        System.out.println("管理员servlet收到的id为："+id);
        Admin a=adminDao.loadByUsername(id);//输入管理员账号
        String n=a.getA_name();
        String passd=a.getA_password();
        String sex=a.getA_sex();


        //传出数据  不想查什么删哪条就行
        request.getSession().setAttribute("id",id);//账号
        request.getSession().setAttribute("name",n);//姓名
        request.setAttribute("passd",passd);//密码
        request.getSession().setAttribute("asex",sex);//性别
        //带回去
        request.getRequestDispatcher("AdminMessahe.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
