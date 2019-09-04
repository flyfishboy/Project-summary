package cn.keshe.servlet;

import cn.keshe.dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("a_t_update_Servlet")
public class a_t_update_Servlet extends HttpServlet {
    private TeacherDao updat = new TeacherDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");


        String t_id = request.getParameter("t_id");
        String nid = request.getParameter("nid");
        String nname = request.getParameter("nname");
        String npasd = request.getParameter("npasd");
        String nsex = request.getParameter("nsex");
        String nbird = request.getParameter("nbird");
        String nprof = request.getParameter("nprof");
        String npho = request.getParameter("npho");
        String nqq = request.getParameter("nqq");

        boolean b = updat.update(t_id,nid,nname,npasd,nsex,nbird,nprof,npho,nqq);
        System.out.println("aa:"+t_id+"bb:"+nid+"名字 "+"  修改布尔值："+b);
        request.getRequestDispatcher("a_t_find_Servlet").forward(request , response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
