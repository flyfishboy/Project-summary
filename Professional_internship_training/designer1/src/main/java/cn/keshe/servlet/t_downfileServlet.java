package cn.keshe.servlet;

import cn.keshe.dao.Practice_workDao;
import cn.keshe.dao.fileDao;
import cn.keshe.entity.file;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("t_downfileServlet")
public class t_downfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tid = request.getParameter("tid");
        String tit = request.getParameter("tit");
        String date = request.getParameter("date");
        System.out.print("t_downfileServlet接收的TID："+tid);

        Practice_workDao p=new Practice_workDao();
        fileDao fi=new fileDao();


        ArrayList<file> f=fi.tselect(tid);

        request.setAttribute("list", f);

        System.out.print("\n接收的list："+f.isEmpty());

        request.getRequestDispatcher("Teacher_downFile.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
