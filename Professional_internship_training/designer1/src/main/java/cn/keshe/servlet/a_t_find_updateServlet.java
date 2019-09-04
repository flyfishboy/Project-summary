package cn.keshe.servlet;

import cn.keshe.dao.TeacherDao;
import cn.keshe.entity.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("a_t_find_updateServlet")
public class a_t_find_updateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherDao teacherDao=new TeacherDao();
        String tid= (String) request.getParameter("tid");
        System.out.println("教师servlet收到的id为："+tid);
        Teacher t=teacherDao.loadByUsername(tid);//输入教师工号
        String n=t.getT_name();
        String psd=t.getT_password();
        String sex=t.getT_sex();
        String d=t.getT_birthday();
        String tel=t.getT_phone();
        String q=t.getT_qq();
        String p=t.getT_profession();

        //传出数据  不想查什么删哪条就行
        request.getSession().setAttribute("tid",tid);//工号
        request.getSession().setAttribute("tname",n);//姓名
        request.getSession().setAttribute("psd",psd);//密码
        request.getSession().setAttribute("sex",sex);//性别
        request.getSession().setAttribute("birth",d);//出生日期
        request.getSession().setAttribute("profess",p);//专业
        request.getSession().setAttribute("telphone",tel);//电话
        request.getSession().setAttribute("qq",q);//QQ
        //带回去
        request.getRequestDispatcher("AdminUpdateTeacher.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
