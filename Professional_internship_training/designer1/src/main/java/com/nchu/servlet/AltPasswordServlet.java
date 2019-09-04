package com.nchu.servlet;

import com.nchu.dao.EmploymentDao;
import com.nchu.dao.UserDao;
import com.nchu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/altpassword")
public class AltPasswordServlet extends HttpServlet {
    UserDao u=new UserDao();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username= (String) request.getSession().getAttribute("username");
        String password=request.getParameter("password");
        String confirmPassword=request.getParameter("confirmPassword");

        if (password.trim().length()<6||username.trim().length()>18){
            String msg = "密码的长度在6到18位之间 ";
            request.setAttribute("password_msg", msg);
            request.getRequestDispatcher("/altpassword.jsp").forward(request, response);
        }
        else
        {
            if (password.equals(confirmPassword)) {
                // 证明可以修改
                boolean b=u.alterpassword(username,password);
                if (b) {
                    // 修改成功
                    request.getSession().invalidate();
                    response.setContentType("text/html;charset=UTF-8");
                    response.getWriter().print("<h1>修改密码成功，2秒之后自动回到登录</h1>");
                    response.setHeader("refresh", "2;url=/login.jsp");
                } else {
                    // 修改失败
                    String msg = "出错了，请稍后重试 ";
                    request.setAttribute("msg", msg);
                    request.getRequestDispatcher("/altpassword.jsp").forward(request, response);
                }
            } else {
                // 友好提示
                // 能进入到这里，证明 用户名已经存在
                String msg = "两次密码不相等";
                request.setAttribute("password_msg", msg);
                request.getRequestDispatcher("/altpassword.jsp").forward(request, response);
            }
        }

    }
}
