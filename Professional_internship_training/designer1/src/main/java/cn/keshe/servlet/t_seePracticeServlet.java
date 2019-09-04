package cn.keshe.servlet;

import cn.keshe.dao.PracticeDao;
import cn.keshe.entity.Practice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("t_seePracticeServlet")
public class t_seePracticeServlet extends HttpServlet {
    PracticeDao practiceDao=new PracticeDao();
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String totalPages = request.getParameter("page");
        if(totalPages==null){
            totalPages = ""+1;
        }
        String t_id =(String ) request.getSession().getAttribute("id");
        String s_name=(String) request.getParameter("s_name");
        System.out.println("收到的ID为"+t_id);
        response.setCharacterEncoding("UTF-8");
        ArrayList<Practice> list1=null;
        if(s_name==null){
            list1=practiceDao.select(t_id);
        }else{
            list1=practiceDao.selectone(s_name);
        }
        if(list1==null){
            System.out.println("收到的list为空");
        }
        request.setAttribute("totalPages",totalPages);
        request.setAttribute("list1",list1);
        request.getRequestDispatcher("TeacherMPractice.jsp").forward(request , response );
    }
}

