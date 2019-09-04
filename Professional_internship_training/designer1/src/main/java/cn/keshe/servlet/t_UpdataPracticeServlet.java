package cn.keshe.servlet;

import cn.keshe.dao.PracticeDao;
import cn.keshe.dao.StudentDao;
import cn.keshe.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("t_UpdataPracticeServlet")

/**
 * 传入学生学号，可修改学生部分信息
 */
public class t_UpdataPracticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String p_id=request.getParameter("P_id");
        String bdate=request.getParameter("p_bdate");
        String edate=request.getParameter("p_edate");
        String type=request.getParameter("p_type");
        String unit=request.getParameter("p_unit");
        String uphone=request.getParameter("p_uphone");

        PracticeDao practiceDao=new PracticeDao();
        boolean b=practiceDao.change( p_id,bdate,edate,type,unit,uphone);
        System.out.println("执行Boolean值为："+b+"p_id: "+p_id);
        request.getRequestDispatcher("t_seePracticeServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
