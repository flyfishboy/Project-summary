package com.nchu.servlet;

import com.nchu.dao.EmploymentDao;
import com.nchu.entity.Employment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showall")
public class ShowAllServlet extends HttpServlet {
    EmploymentDao EmploymentDao=new EmploymentDao();
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Employment> list=EmploymentDao.load_employment();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/showall.jsp").forward(request , response );
    }
}
