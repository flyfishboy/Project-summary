package com.nchu.servlet;

import com.nchu.dao.UserDao;
import com.nchu.entity.User;
import com.nchu.services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userlogin")
public class UserLoginServlet extends HttpServlet {
    UserServices userServices = new UserServices() ;
    UserDao userDao=new UserDao();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username") ;
        String password = request.getParameter("password") ;
        User u = userDao.loadByUsername( username ) ;
        boolean b = userServices.load( username , password ) ;
        if(b){
            request.getSession().setAttribute("username" , username );
            request.getSession().setAttribute("nickname" , u.getNickname() );
            request.getRequestDispatcher("/main.jsp").forward(request , response );
        }
        else{
            String msg = "账号或密码错误 ";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
