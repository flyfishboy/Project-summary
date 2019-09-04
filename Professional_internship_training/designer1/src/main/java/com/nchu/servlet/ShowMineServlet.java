package com.nchu.servlet;

import com.nchu.dao.EmploymentDao;
import com.nchu.entity.Employment;
import com.nchu.services.EmploymentServices;

import javax.management.DynamicMBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showmine")
public class ShowMineServlet extends HttpServlet {
    EmploymentDao EmploymentDao=new EmploymentDao();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username= (String )request.getSession().getAttribute("username");
        String nickname= (String )request.getSession().getAttribute("nickname");
        ArrayList<Employment> list=EmploymentDao.load_mine(username);
        request.setAttribute("list" , list );
        request.getRequestDispatcher("/showmine.jsp").forward(request , response );
    }
}
