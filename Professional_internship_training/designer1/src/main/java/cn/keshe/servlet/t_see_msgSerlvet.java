package cn.keshe.servlet;

import cn.keshe.dao.TeacherDao;
import cn.keshe.entity.Student;
import cn.keshe.entity.Teacher;
import cn.keshe.utils.JDBCHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("t_see_msgSerlvet")


public class t_see_msgSerlvet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherDao teacherDao=new TeacherDao();
        String id= (String) request.getSession().getAttribute("id");
        System.out.println("教师servlet收到的id为："+id);
        Teacher t=teacherDao.loadByUsername(id);//输入学生学号
        String n=t.getT_name();
        String psd=t.getT_password();
        String sex=t.getT_sex();
        String d=t.getT_birthday();
        String tel=t.getT_phone();
        String q=t.getT_qq();
        String p=t.getT_profession();

        //传出数据  不想查什么删哪条就行
        request.getSession().setAttribute("id",id);//工号
        request.getSession().setAttribute("name",n);//姓名
        request.getSession().setAttribute("psd",psd);//密码
        request.getSession().setAttribute("sex",sex);//性别
        request.getSession().setAttribute("birth",d);//出生日期
        request.getSession().setAttribute("profess",p);//专业
        request.getSession().setAttribute("telphone",tel);//电话
        request.getSession().setAttribute("qq",q);//QQ
        //带回去
        System.out.println("收到的QQ为"+q);
        request.getRequestDispatcher("TeacherMessage.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
