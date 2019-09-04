package cn.keshe.servlet;

import cn.keshe.dao.AdminDao;
import cn.keshe.dao.TeacherDao;
import cn.keshe.entity.Admin;
import cn.keshe.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("a_a_find_updateServlet")
public class a_a_find_updateServlet extends HttpServlet {  /*修改中从列表获取值得中转*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDao fi=new AdminDao();
        String a_id= (String) request.getParameter("aid");
        System.out.println("教师servlet收到的id为："+a_id);
        Admin t=fi.loadByUsername(a_id);//输入管理员工号
        String n=t.getA_name();
        String psd=t.getA_password();
        String sex=t.getA_sex();


        //传出数据  不想查什么删哪条就行
        request.getSession().setAttribute("aid",a_id);//工号
        request.getSession().setAttribute("aname",n);//姓名
        request.getSession().setAttribute("apsd",psd);//密码
        request.getSession().setAttribute("asex",sex);//性别
        //带回去
        request.getRequestDispatcher("AdminUpdateAdmin.jsp").forward(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
