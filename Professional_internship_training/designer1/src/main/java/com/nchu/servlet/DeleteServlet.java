package com.nchu.servlet;

import com.nchu.dao.EmploymentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    com.nchu.dao.EmploymentDao EmploymentDao=new EmploymentDao();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        boolean b=EmploymentDao.delete(id);
        if(b){
            request.getRequestDispatcher("/showmine").forward(request , response );
        }
    }
}
