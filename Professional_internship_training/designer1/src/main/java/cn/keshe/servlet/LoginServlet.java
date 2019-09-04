package cn.keshe.servlet;

import cn.keshe.dao.AdminDao;
import cn.keshe.dao.StudentDao;
import cn.keshe.dao.TeacherDao;
import cn.keshe.entity.Admin;
import cn.keshe.entity.Student;
import cn.keshe.entity.Teacher;
import cn.keshe.services.AdminServices;
import cn.keshe.services.StudentServices;
import cn.keshe.services.TeacherServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("s_id");
        String password = request.getParameter("s_password");
        String usertype = request.getParameter("usertype") ;
        if(usertype.equals("1")){
            System.out.println("我是学生");

            StudentServices studentServices = new StudentServices() ;
            StudentDao studentDao=new StudentDao();
            Student u = studentDao.loadByUsername( id ) ;
            boolean b = StudentServices.load( id , password ) ;
            if(b==true){
                request.getSession().setAttribute("id" , id );
                request.getSession().setAttribute("name" , u.getS_name() );
                request.getSession().setAttribute("password",u.getS_password());
                request.getSession().setAttribute("sex",u.getS_sex());
                request.getSession().setAttribute("d",u.getS_birthday());
                request.getSession().setAttribute("p",u.getS_profession());
                request.getSession().setAttribute("c",u.getS_class());
               request.getSession().setAttribute("tel",u.getS_phone());
               request.getSession().setAttribute("q",u.getS_qq());
               request.getSession().setAttribute("teaid",u.getT_id());
                request.getRequestDispatcher("StudentMain.jsp").forward(request , response );
            }
            else{
                String msg = "账号或密码错误 ";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
        else if(usertype.equals("2")){
            System.out.println("我是老师");

            TeacherServices teacherServices = new TeacherServices();
            TeacherDao teacherDao = new TeacherDao();
            Teacher u = teacherDao.loadByUsername(id);
            boolean b = teacherServices.load(id, password);
            if (b) {
                request.getSession().setAttribute("id", id);
                request.getSession().setAttribute("name", u.getT_name());
                request.getSession().setAttribute("password",u.getT_password());
                request.getSession().setAttribute("sex", u.getT_sex());
                request.getSession().setAttribute("birth", u.getT_birthday());
                request.getSession().setAttribute("profess",u.getT_profession());
                request.getSession().setAttribute("telphone", u.getT_phone());
                request.getSession().setAttribute("q1", u.getT_qq());
                request.getRequestDispatcher("TeacherMain.jsp").forward(request , response );
            } else {
                String msg = "账号或密码错误 ";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }else if(usertype.equals("3")){
            System.out.println("我是老师他爹");
            AdminServices adminServices = new AdminServices();
            AdminDao adminDao = new AdminDao();
            Admin u = adminDao.loadByUsername(id);
            boolean b = adminServices.load(id, password);
            if (b) {
                request.getSession().setAttribute("id", id);
                request.getSession().setAttribute("name", u.getA_name());
                request.getSession().setAttribute("asex",u.getA_sex());
                request.getSession().setAttribute("password",u.getA_password());
                request.getRequestDispatcher("AdminMain.jsp").forward(request, response);
            } else {
                String msg = "账号或密码错误 ";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }

    }
}

