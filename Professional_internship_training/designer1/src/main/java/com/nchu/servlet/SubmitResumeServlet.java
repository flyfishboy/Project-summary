package com.nchu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;


public class SubmitResumeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part p=request.getPart("resume");
        String id=request.getParameter("id");
        id=id+p.getSubmittedFileName();
        p.write(id);
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("<h1>上传简历成功，2秒之后自动回到招聘信息界面</h1>");
        response.setHeader("refresh", "2;url=/showall");
    }
}
