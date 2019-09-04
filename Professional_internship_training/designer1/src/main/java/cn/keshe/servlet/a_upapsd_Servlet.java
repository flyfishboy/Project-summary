package cn.keshe.servlet;

import cn.keshe.dao.AdminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("a_upapsd_Servlet")
public class a_upapsd_Servlet extends HttpServlet { /**管理员更改个人密码**/
    private AdminDao up = new AdminDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");//传入教师的工号
        String oldpassword=request.getParameter("oldpassword");
        String pass=request.getParameter("password");//传入教师密码
        String npassword=request.getParameter("npassword");//传入教师更改后密码
        System.out.println("t_change_passServlet接收的密码为"+oldpassword+"原密码"+pass+"新密码"+npassword);
        if (npassword.trim().length()<6||npassword.trim().length()>18){
            String msg = "新密码的长度在6到18位之间 ";
            request.setAttribute("fmsg", msg);
            request.getRequestDispatcher("AdminupPas.jsp").forward(request, response);
        } else
        if(pass.equals(oldpassword)){
            if(npassword.equals(pass)){
                String msg = "修改后的密码不能与原密码一致！ ";
                request.setAttribute("fmsg", msg);
                request.getRequestDispatcher("AdminupPas.jsp").forward(request, response);
            } else{
                boolean b=up.update1(id,npassword);//传入教师学号,密码，出生日期，电话号码，QQ执行
                System.out.println("密码change获取的id："+id+"执行结果："+b);
                request.getSession().setAttribute("id",id);
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
        }else{
            String msg = "密码错误，请输入正确原密码 ";
            request.setAttribute("fmsg", msg);
            request.getRequestDispatcher("AdminupPas.jsp").forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
