package com.nchu.servlet;

import com.nchu.dao.EmploymentDao;
import com.nchu.entity.Employment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/select")
public class SelectServlet extends HttpServlet {
com.nchu.dao.EmploymentDao EmploymentDao=new EmploymentDao();
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String select =request.getParameter("select");
        ArrayList<Employment> list=EmploymentDao.select(select);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/showall.jsp").forward(request , response );
    }
}
