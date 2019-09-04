package com.nchu.servlet;

import com.nchu.dao.EmploymentDao;
import com.nchu.entity.Employment;
import com.nchu.utils.StringHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    EmploymentDao ED=new EmploymentDao();
    Employment E=new Employment();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Part p= request.getPart("img");
        String id=StringHelper.uuid();
        String jobname=request.getParameter("jobname");
        String img=id+p.getSubmittedFileName();
        String username= (String) request.getSession().getAttribute("username");
        String pnumber=request.getParameter("pnumber");
        String introduction=request.getParameter("introduction");
        String salary=request.getParameter("salary");

        E.setId(id);E.setJobname(jobname);E.setImg(img);E.setUsername(username);E.setPnumber(pnumber);
        E.setIntroduction(introduction);E.setSalary(salary);
        boolean b=ED.insert(E);
        if (b){
            p.write( img );
            request.getRequestDispatcher("/showmine").forward(request , response );
        }

    }
}
