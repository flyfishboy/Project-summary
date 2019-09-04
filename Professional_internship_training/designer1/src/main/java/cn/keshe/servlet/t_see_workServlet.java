package cn.keshe.servlet;

import cn.keshe.dao.Practice_workDao;
import cn.keshe.entity.Practice_work;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("t_see_workServlet")
public class t_see_workServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String totalPages = request.getParameter("page");
        if(totalPages==null){
            totalPages = ""+1;
        }
        String tid = request.getParameter("tid");
        System.out.print("t_see_workServlet接收的TID："+tid);
        Practice_workDao dao=new Practice_workDao();

        ArrayList<Practice_work>  renwu=dao.sselect(tid);

        request.setAttribute("list", renwu);

        System.out.print("\n接收的list："+renwu.isEmpty());
        request.setAttribute("totalPages",totalPages);
        request.getRequestDispatcher("Teacher_seeWork.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
