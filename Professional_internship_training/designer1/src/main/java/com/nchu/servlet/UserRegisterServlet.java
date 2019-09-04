package com.nchu.servlet;

import com.nchu.services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userregister")
public class UserRegisterServlet extends HttpServlet {
    UserServices userServices = new UserServices() ;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String nickname=request.getParameter("nickname");
        String userinformation=request.getParameter("userinformation");
        if (username.trim().length() < 6 || username.trim().length() > 18) {
            String msg = "用户名的长度在6到18位之间 ";
            request.setAttribute("username_msg", msg);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
        else
        {
            // 检验用户名是否唯一
            boolean isUnique = userServices.isUnique(username);
            if (isUnique) {
                // 能进入到这里，应该是可以进行注册的（ 用户名是没有问题的）
                //检测密码
                if (password.trim().length()<6||username.trim().length()>18){
                    String msg = "密码的长度在6到18位之间 ";
                    request.setAttribute("password_msg", msg);
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
                }
                else
                {
                    if (password.equals(confirmPassword)) {
                        // 证明可以注册
                        boolean isRegist = userServices.regist(username, password, nickname,userinformation);
                        if (isRegist) {
                            // 注册成功
                            response.setContentType("text/html;charset=UTF-8");
                            response.getWriter().print("<h1>注册成功，2秒之后自动回到登陆界面</h1>");
                            response.setHeader("refresh", "2;url=/login.jsp");
                        } else {
                            // 注册失败
                            String msg = "出错了，请稍后重试 ";
                            request.setAttribute("msg", msg);
                            request.getRequestDispatcher("/register.jsp").forward(request, response);
                        }
                    } else {
                        // 友好提示
                        // 能进入到这里，证明 用户名已经存在
                        String msg = "两次密码不相等";
                        request.setAttribute("password_msg", msg);
                        request.getRequestDispatcher("/register.jsp").forward(request, response);
                    }
                }
            }
            else
            {
                // 能进入到这里，证明 用户名已经存在
                String msg = "用户名已经存在 ";
                request.setAttribute("username_msg", msg);
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
        }

    }
}
