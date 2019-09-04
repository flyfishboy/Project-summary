package cn.keshe.servlet;

import cn.keshe.dao.TeacherDao;
import cn.keshe.entity.Student;
import cn.keshe.entity.Teacher;
import cn.keshe.services.VerifyServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("a_t_add_Servlet")
public class a_t_add_Servlet extends HttpServlet {
    private TeacherDao add = new TeacherDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String t_id = request.getParameter("t_id");
        String t_name = request.getParameter("t_name");
        String t_password = request.getParameter("t_password");
        String t_sex = request.getParameter("t_sex");
        String t_birthday = request.getParameter("t_birthday");
        String t_profession = request.getParameter("t_profession");
        String t_phone = request.getParameter("t_phone");
        String t_qq = request.getParameter("t_qq");

        VerifyServices v=new VerifyServices();
        String veid=v.IsTntegerT(t_id);
        String vename=v.Isempty(t_name);
        String vepas=v.IsPassword(t_password);
        String vebir=v.Isempty(t_birthday);
        String vepro=v.Isempty(t_profession);
        String veph=v.IsTntegerPhone(t_phone);
        String veqq=v.IsTntegerQQ(t_qq);

        if("".equals(veid)==false){
            String Smsg=veid;
            request.setAttribute("Smsg",Smsg);
            request.getRequestDispatcher("AdminAddTeacher.jsp").forward(request,response);
        }else if("".equals(vename)==false||"".equals(vebir)==false||"".equals(vepro)==false){
            String Smsg=vename;
            request.setAttribute("Smsg",Smsg);
            request.getRequestDispatcher("AdminAddTeacher.jsp").forward(request,response);
        }else if("".equals(vepas)==false){
            String Smsg=vepas;
            request.setAttribute("Smsg",Smsg);
            request.getRequestDispatcher("AdminAddTeacher.jsp").forward(request,response);
        }else if("".equals(veph)==false){
            String Smsg=veph;
            request.setAttribute("Smsg",Smsg);
            request.getRequestDispatcher("AdminAddTeacher.jsp").forward(request,response);
        }else if("".equals(veqq)==false){
            String Smsg=veqq;
            request.setAttribute("Smsg",Smsg);
            request.getRequestDispatcher("AdminAddTeacher.jsp").forward(request,response);
        }
        else {

            Teacher a = new Teacher();
            a.setT_id(t_id);
            a.setT_name(t_name);
            a.setT_password(t_password);
            a.setT_sex(t_sex);
            a.setT_birthday(t_birthday);
            a.setT_profession(t_profession);
            a.setT_phone(t_phone);
            a.setT_qq(t_qq);
            boolean d = add.insert(a);
            request.getRequestDispatcher("a_t_find_Servlet").forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
