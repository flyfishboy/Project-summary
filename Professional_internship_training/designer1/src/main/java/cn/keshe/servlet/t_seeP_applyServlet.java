package cn.keshe.servlet;

import cn.keshe.dao.P_applyDao;
import cn.keshe.dao.PracticeDao;
import cn.keshe.entity.P_apply;
import cn.keshe.entity.Practice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("t_seeP_applyServlet")
public class t_seeP_applyServlet extends HttpServlet {


    P_applyDao pDao=new P_applyDao();
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String totalPages = request.getParameter("page");
        if(totalPages==null){
            totalPages = ""+1;
        }
        String t_id =(String ) request.getSession().getAttribute("id");
        String s_id=(String) request.getParameter("s_id");
        System.out.println("收到的ID为"+t_id);
        response.setCharacterEncoding("UTF-8");
        ArrayList<Practice> list1=null;
        if(s_id==null){
            list1=pDao.select(t_id);
        }else{
            list1=pDao.selectone(s_id);
        }
        request.setAttribute("totalPages",totalPages);
        request.setAttribute("list1",list1);
        request.getRequestDispatcher("TeacherMApply.jsp").forward(request , response );
    }
}

