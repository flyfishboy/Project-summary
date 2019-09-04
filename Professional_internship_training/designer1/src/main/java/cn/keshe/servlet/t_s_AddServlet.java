package cn.keshe.servlet;

import cn.keshe.dao.StudentDao;
import cn.keshe.entity.Student;
import cn.keshe.services.VerifyServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("t_s_AddServlet")
public class t_s_AddServlet extends HttpServlet {
    private StudentDao add = new StudentDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String s_id = request.getParameter("s_id");
        String s_name = request.getParameter("s_name");
        String s_password = request.getParameter("s_password");
        String s_sex = request.getParameter("s_sex");
        String s_birthday = request.getParameter("s_birthday");
        String s_clas = request.getParameter("s_class");
        String s_profession = request.getParameter("s_profession");
        String s_phone = request.getParameter("s_phone");
        String s_qq = request.getParameter("s_qq");
        String t_id=request.getParameter("t_id");
        String t_name=request.getParameter("t_name");

        VerifyServices v=new VerifyServices();
        String veid=v.IsTntegerS(s_id);
        String vename=v.Isempty(s_name);
        String vepas=v.IsPassword(s_password);
        String vebir=v.Isempty(s_birthday);
        String veclas=v.Isempty(s_clas);
        String vepro=v.Isempty(s_profession);
        String veph=v.IsTntegerPhone(s_phone);
        String veqq=v.IsTntegerQQ(s_qq);
        if("".equals(veid)==false){
            String Smsg=veid;
            request.setAttribute("Smsg",Smsg);
            request.getRequestDispatcher("TeacherAddStudent.jsp").forward(request,response);
        }else if("".equals(vename)==false||"".equals(vebir)==false||"".equals(veclas)==false||"".equals(vepro)==false){
            String Smsg=vename;
            request.setAttribute("Smsg",Smsg);
            request.getRequestDispatcher("TeacherAddStudent.jsp").forward(request,response);
        }else if("".equals(vepas)==false){
            String Smsg=vepas;
            request.setAttribute("Smsg",Smsg);
            request.getRequestDispatcher("TeacherAddStudent.jsp").forward(request,response);
        }else if("".equals(veph)==false){
            String Smsg=veph;
            request.setAttribute("Smsg",Smsg);
            request.getRequestDispatcher("TeacherAddStudent.jsp").forward(request,response);
        }else if("".equals(veqq)==false){
            String Smsg=veqq;
            request.setAttribute("Smsg",Smsg);
            request.getRequestDispatcher("TeacherAddStudent.jsp").forward(request,response);
        }
        else {
            Student a = new Student();
            a.setS_id(s_id);
            a.setS_name(s_name);
            a.setS_password(s_password);
            a.setS_sex(s_sex);
            a.setS_birthday(s_birthday);
            a.setS_profession(s_profession);
            a.setS_phone(s_phone);
            a.setS_qq(s_qq);
            a.setS_class(s_clas);
            a.setT_id(t_id);
            System.out.println("学号" + s_id + "姓名" + s_name + t_id + " " + t_name);
            boolean d = add.insert(a);
            request.getRequestDispatcher("t_s_seemsgServlet").forward(request, response);
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
